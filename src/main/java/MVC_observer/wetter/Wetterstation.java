package wetter;

import java.util.Random;

/**
 * stellt eine Wetterstation 
 * @author Doro
 *
 */
public class Wetterstation {
	
	/**
	 * simuliert den Empfang von Messdaten aus einer Wetterstation mit verschiedenen Anzeigen
	 * der empfangenen Daten
	 */
	public static void main(String[] args) {
			Wetterdaten wetterDaten = new Wetterdaten();

			AktuelleBedingungenAnzeige aktuelleAnzeige
				=new AktuelleBedingungenAnzeige();
			StatistikAnzeige statistikAnzeige
				=new StatistikAnzeige();
			Beobachter vor = new VorhersageAnzeige();
			
			wetterDaten.anmelden(vor);
			wetterDaten.anmelden(aktuelleAnzeige);
			wetterDaten.anmelden(statistikAnzeige);

			// Das Messgerät liefert neue Wetterdaten:
			wetterDaten.setMesswerte(30, 65, 1013);
			wetterDaten.abmelden(vor);
			wetterDaten.setMesswerte(30, 70, 1020);
			wetterDaten.abmelden(statistikAnzeige);
			wetterDaten.abmelden(aktuelleAnzeige);
			wetterDaten.setMesswerte(28, 90, 980);	

		}



}
