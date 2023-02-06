package buchhandlungMitExecutors;

/**
 * Käufer in der Ein-Buch-Buchhandlung.
 *
 */
public class Kaeufer implements Runnable
{
	/**
	 * die Buchhandlung
	 */
	private Buchhandlung handlung;
	private int gesamt;
	
	/**
	 * erstellt einen Käufer, der in der angegebenen Buchhandlung "einkauft"
	 * @param handlung
	 */
	public Kaeufer(Buchhandlung handlung)
	{
		this.handlung = handlung;
	}
	
	/**
	 * Der Käufer nimmt nacheinander viele Bücher aus dem Regal
	 * @param insgesamt Anzahl der zu kaufenden Bücher
	 */
	public void kaufen(int insgesamt)
	{
		int i = 0;
		while (i < insgesamt && !handlung.isGeschlossen())
		{
			int anzahl;
			handlung.getAnzahlLock().lock();
				anzahl = handlung.getAnzahlBuecher().get();
				while(anzahl <= 0)
				{
					handlung.getAnzahlGroesser0().awaitUninterruptibly();
					anzahl = handlung.getAnzahlBuecher().get();
				}
				anzahl = handlung.getAnzahlBuecher().getAndDecrement();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			handlung.getAnzahlLock().unlock();
			System.out.println("Kaeufer: "+anzahl);
			i++;
		}
		System.out.println("Käufer verlässt den Laden");
	}

	@Override
	public void run() {
		this.kaufen(this.gesamt);	
	}

	/**
	 * @return the gesamt
	 */
	public int getGesamt() {
		return gesamt;
	}

	/**
	 * @param gesamt the gesamt to set
	 */
	public void setGesamt(int gesamt) {
		this.gesamt = gesamt;
	}
}