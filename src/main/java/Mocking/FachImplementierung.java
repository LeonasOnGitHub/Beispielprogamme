package automat;

/**
 * stellt eine fehlerhafte Implementierung von Fach zur
 * Verfügung.
 * @author Doro
 *
 */
public class FachImplementierung implements Fach {
 
  @Override
  public boolean isVoll() {
	  System.out.println("Nicht aufrufen, isLeer() prüft leider gar nichts!");
    return true;
  }
 
  @Override
  public int getPreis() {
	  System.out.println("Nicht aufrufen, getPreis() liefert nur irgendeinen sinnlosen Preis");
    return 0;
  }
 
  /**
   * die Methode tut nichts
   */
  @Override
  public void auswerfen() {
	  System.out.println("Nicht aufrufen, auswerfen() ist noch total"+
  System.lineSeparator() + "        verbuggt und zerstört die Spirale - Oh Mist, zu spät...");
  }
 
}