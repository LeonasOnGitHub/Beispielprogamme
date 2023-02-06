package buchhandlung;

/**
 * Käufer in der Ein-Buch-Buchhandlung. Er holt 100 mal ein Buch aus dem Regal
 *
 */
public class Kaeufer implements Runnable
{
	/**
	 * die Buchhandlung
	 */
	private Buchhandlung handlung;
	private int insgesamt;
	
	/**
	 * erstellt einen Käufer, der in der angegebenen Buchhandlung "einkauft"
	 * @param handlung
	 */
	public Kaeufer(Buchhandlung handlung, int insgesamt)
	{
		this.handlung = handlung;
		this.insgesamt = insgesamt;
	}
	
	/**
	 * Der Käufer nimmt nacheinander viele Bücher aus dem Regal
	 */
	@Override
	public void run()
	{
		int i = 0;
		while (i < this.insgesamt && !handlung.isGeschlossen())
		{
			int anzahl;
			synchronized(this.handlung)
			{
				anzahl = handlung.getAnzahlBuecher();
				while(anzahl <= 0)
				{
					try {
						this.handlung.wait();
							//warten, dass es in this.handlung irgendeine
							//Veränderung gibt
					} catch (InterruptedException e) {}
					anzahl = handlung.getAnzahlBuecher();
				}
				
				anzahl = anzahl - 1;
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
				}
				handlung.setAnzahlBuecher(anzahl);
			}
			System.out.println("Kaeufer: "+anzahl);
			i++;
		}
		System.out.println("Käufer verlässt den Laden");
	}
}