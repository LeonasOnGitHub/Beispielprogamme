package automat;

/**
 * Geldmodul eines Automaten
 * @author Doro
 *
 */
public interface Kassenmodul {
 
  /**
   * aktueller Kontostand, eingeworfener Betrag
   * @return verfügbarer Betrag
   */
  public int getKontostand();
 
  /**
   * zieh den angegebenen Betrag vom aktuellen Kontostand ab
   * @param betrag abzuziehender Betrag
   */
  public void abziehen(int betrag);
 
}