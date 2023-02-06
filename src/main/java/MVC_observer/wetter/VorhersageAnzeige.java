package wetter;

/**
 * Anzeige, mit der aus den bisherigen Wetterdaten eine Vorhersage abgeleitet wird
 */
public class VorhersageAnzeige implements Beobachter 
{
    private double letzterLuftdruck;

        /**
         * erstellt eine Anzeige, die Normalbedingungen vorhersagt
         */
    public VorhersageAnzeige()
    {
    	this.letzterLuftdruck = 1013; 
    }
        /**
         * die übergebenen Wetterdaten werden genutzt, um die Vorhersage für den nächsten Tag zu berechnen und anzuzeigen
         * @param wetter die aktuellen Wetterbedingungen
         */
	public void aktualisieren(Wetterdaten wetter)
	{
		double aktuellerLuftdruck = wetter.getLuftdruck();
        	letzterLuftdruck = aktuellerLuftdruck;

		System.out.println("Vorhersage: ");
		if (aktuellerLuftdruck > letzterLuftdruck) {
			System.out.println("Wetter-Besserung in Sicht!");
		} else if (aktuellerLuftdruck == letzterLuftdruck) {
			 System.out.println("Wetter geht weiter so." );
		} else if (aktuellerLuftdruck < letzterLuftdruck) {
			System.out.println( "Gehen Sie von kälterem, regnerischem Wetter aus.");
		}
	}
}
