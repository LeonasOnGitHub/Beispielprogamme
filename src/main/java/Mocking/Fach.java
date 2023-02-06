package automat;

/**
 * Verwaltung des Faches eines Automaten
 * @author Doro
 *
 */
public interface Fach {
 
  /**
   * gibt zurück, ob das Fach voll ist
   * @return true, wenn das Fach voll ist
   */
  public boolean isVoll();
 
  /**
   * liefert den Preis des Produktes im Fach zurück
   * @return Produktpreis
   */
  public int getPreis();
 
  /**
   * wirft das Produkt im Fach aus
   * @throw VerklemmtException wenn das Fach verklemmt ist
   */
  public void auswerfen();
 
}