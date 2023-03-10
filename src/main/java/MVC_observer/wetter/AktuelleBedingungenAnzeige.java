package wetter;

/**
 * zeigt die aktuellen Wetterbedingungen an
 */
public class AktuelleBedingungenAnzeige implements Beobachter{

        /**
         * speichert die ├╝bergebenen Werte und zeigt sie an
         * @param w die aktuellen Wetterbedingungen
         */
	public void aktualisieren(Wetterdaten w)
	{
		System.out.println("Aktuelle Bedingungen: " + w.getTemperatur()
		+ " Grad C und " + w.getFeuchtigkeit() + "% Luftfeuchtigkeit");
	}
}