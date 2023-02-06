package automat;

/**
 * stellt ein fehlerhaftes Kassenmodul dar. 
 * @author Doro
 *
 */
public class KasseImplementierung implements Kassenmodul {

	@Override
	public int getKontostand() {
		System.out.println("Nicht aufrufen, getKontostand() liefert nur Unsinn!");
		return 0;
	}

	@Override
	public void abziehen(int betrag) {
		System.out.println("Nicht aufrufen, abziehen() steuert die Mechanik nicht korrekt."
				+ System.lineSeparator() + "           Oh Mist, zu spät... schon kaputt!");
	}

}
