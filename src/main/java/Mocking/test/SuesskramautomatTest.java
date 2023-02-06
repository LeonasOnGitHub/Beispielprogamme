package automat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.junit.jupiter.api.DisplayName;
 
public class SuesskramautomatTest{
 
  @Test
  @DisplayName("prüft, ob waehlen(0) im Süßkramautomat korrekt arbeitet, d.h: Rückgabewert stimmt, Geld wird abgezogen, Süßkram kommt raus")
  public void erstesVollesFachMitGenugGeldWaehlenTest() throws Exception {
 	//SetUp:
	  Kassenmodul kasse = Mockito.mock(Kassenmodul.class);
	  Mockito.when(kasse.getKontostand()).thenReturn(150);
	  Fach fach = Mockito.mock(Fach.class);
	  Fach fach2 = Mockito.mock(Fach.class);
	  Mockito.when(fach.isVoll()).thenReturn(true);
	  Mockito.when(fach.getPreis()).thenReturn(99);
	  Fach[] faecher = {fach, fach2};
	  InOrder reihenfolge = Mockito.inOrder(fach, kasse);
	  
	  Suesskramautomat automat = new Suesskramautomat(kasse, faecher);
	//Exercise:
	  boolean hatGeklappt = automat.waehlen(0);
	//Verify:
	  assertTrue(hatGeklappt);
	  //assertEquals(51, kasse.getKontostand());
	  reihenfolge.verify(fach).auswerfen();
	  reihenfolge.verify(kasse).abziehen(99);	  
	  Mockito.verifyNoInteractions(fach2);
  }
  
  @Test
  @DisplayName("prüft, ob waehlen(0) im Süßkramautomat korrekt arbeitet, d.h: Rückgabewert stimmt, Geld wird abgezogen, Süßkram kommt raus")
  public void erstesLeeresFachMitGenugGeldWaehlenTest() throws Exception {
 	//SetUp:
	  Kassenmodul kasse = Mockito.mock(Kassenmodul.class);
	  Mockito.when(kasse.getKontostand()).thenReturn(150);
	  Fach fach = Mockito.mock(Fach.class);
	  Mockito.when(fach.isVoll()).thenReturn(false);
	  Mockito.when(fach.getPreis()).thenReturn(99);
	  Fach[] faecher = {fach};
	  Suesskramautomat automat = new Suesskramautomat(kasse, faecher);
	//Exercise:
	  boolean hatGeklappt = automat.waehlen(0);
	//Verify:
	  assertFalse(hatGeklappt);
	  Mockito.verify(fach, Mockito.times(0)).auswerfen();
	  Mockito.verify(kasse, Mockito.times(0)).abziehen(99);
  }
  
  @Test
  @DisplayName("prüft, ob waehlen(0) im Süßkramautomat korrekt arbeitet, d.h: Rückgabewert stimmt, Geld wird abgezogen, Süßkram kommt raus")
  public void erstesVollesVerklemmtestFachMitGenugGeldWaehlenTest() throws Exception {
 	//SetUp:
	  Kassenmodul kasse = Mockito.mock(Kassenmodul.class);
	  Mockito.when(kasse.getKontostand()).thenReturn(150);
	  Fach fach = Mockito.mock(Fach.class);
	  Mockito.when(fach.isVoll()).thenReturn(true);
	  Mockito.when(fach.getPreis()).thenReturn(99);
	  Mockito.doThrow(new VerklemmtException()).when(fach).auswerfen();
	  Fach[] faecher = {fach};
	  Suesskramautomat automat = new Suesskramautomat(kasse, faecher);
	//Exercise:
	  try {
		   boolean hatGeklappt = automat.waehlen(0);
	  		Assertions.fail("Keine VerklemmtException!");
	  } catch (VerklemmtException e)
	  {}
	//Verify:
	  Mockito.verify(kasse, Mockito.times(0))
	  					.abziehen(ArgumentMatchers.anyInt());
  }
 
 
}