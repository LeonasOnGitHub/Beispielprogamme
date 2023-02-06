package automat;

/**
 * Ein Automat mit Kassenmodul und mehreren Fächern
 * 
 * @author Doro
 *
 */
public class Suesskramautomat {

	private Kassenmodul cashBox = null;
	private Fach[] boxes = null;

	/**
	 * erstellt einen Automaten mit dem angegebenen Kassenmodul und der
	 * angegebenen Fächerliste
	 * 
	 * @param kasse   das zu verwendende Kassenmodul
	 * @param faecher alle Fächer, die im Automaten zur Verfügung stehen
	 */
	public Suesskramautomat(Kassenmodul kasse, Fach[] faecher) {
		this.cashBox = kasse;
		this.boxes = faecher;
	}

	/**
 * wählt eine Fachnummer aus, dessen Produkt der Kunde zu 
 * erwerben wünscht, zieht den Kaufpreis vom Kassenmodul ab
 * und öffnet das gewählte Fach
 * @param fachnr gewählte Fachnummer
 * @return false, wenn das Geld nicht ausreicht, das Fach leer
 * ist oder die Fachnr ungültig ist
 * @throw VerklemmtException wenn das gewählte Fach verklemmt ist
 */
	public boolean waehlen(int fachnr){
		if(0 > fachnr || fachnr >= this.boxes.length)
			return false;
		Fach box = this.boxes[fachnr];
		if (!box.isVoll()) {
			return false;
		} 
		else {
			int betrag= box.getPreis();
			if (betrag > this.cashBox.getKontostand()) {
				return false;
			} 
			else {					
				box.auswerfen();
				this.cashBox.abziehen(betrag);
				return true;
			}
		}
	}

}