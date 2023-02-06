package buchhandlung;

/**
 * Diese Klasse simuliert eine Buchandlung als Test für Thread-Programmierung.
 * Leider gibt es hier nur ein Buch zu kaufen, so dass nur die Anzahl der im Regal
 * stehenden Exemplare des Buches interessant ist.
 *
 */
public class Buchhandlung {
	/**
	 * Anzahl der Bücher im Regal
	 */
	private int anzahlBuecher =0;
	/**
	 * ob die Buchhandlung geschlossen ist oder nicht
	 */
	private boolean geschlossen = false;

	/**
	 * @return the geschlossen
	 */
	public boolean isGeschlossen() {
		return geschlossen;
	}

	/**
	 * @param geschlossen the geschlossen to set
	 */
	public void setGeschlossen(boolean geschlossen) {
		this.geschlossen = geschlossen;
	}

	/**
	 * liefert die Anzahl der im Regal stehenden Bücher
	 * @return Anzahl der Bücher im Regal
	 */
	public int getAnzahlBuecher() {
		return anzahlBuecher;
	}

	/**
	 * Ändert die Anzahl der Bücher im Regal
	 * @param anzahlBuecher neue Anzahl Bücher
	 */
	public void setAnzahlBuecher(int anzahlBuecher) {
		this.anzahlBuecher = anzahlBuecher;
	}

	/**
 	* stellt nacheinander insgesamt viele Bücher ins Regal
 	* @param insgesamt Die Zahl der neuen Bücher
 	*/
	public void auffuellen(int insgesamt)
	{
		int i = 0;
		while (i < insgesamt && !Thread.interrupted())
		{
			int anzahl;
			synchronized(this)
			{
				anzahl = this.getAnzahlBuecher();
				anzahl = anzahl + 1;
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					this.notifyAll();
					break;
				}
				this.setAnzahlBuecher(anzahl);
				this.notifyAll();
			}
			System.out.println("im Regal: "+anzahl);
			i++;
		}
		System.out.println("Tür abschließen");
	}
	
	/**
	 * schliesst die Buchhandlung nach der angegebenen Wartezeit
	 * @param wartezeit Wartezeit in Millisekunden
	 */
	public void schliessen(int wartezeit)
	{
		try {
			Thread.sleep(wartezeit);
		} catch (InterruptedException e) {}
		this.setGeschlossen(true);
	}
	
	/**
	 * lässt Buchhändler und Käufer arbeiten
	 * @param args wird nicht benutzt
	 */
	public static void main(String[] args){
		Buchhandlung buchUndZeitschrift = new Buchhandlung();
		Kaeufer kaeufer = new Kaeufer(buchUndZeitschrift, 500);
		Runnable feierabend = () -> buchUndZeitschrift.schliessen(2500);
		Runnable feierabend2 = new Feierabend2(Thread.currentThread());

		Thread ft = new Thread(feierabend);
		ft.start();
		Thread ft2 = new Thread(feierabend2);
		ft2.start();
		Thread kt = new Thread(kaeufer);
		kt.start();
		buchUndZeitschrift.auffuellen(1000);
		
		


		
	}

}










