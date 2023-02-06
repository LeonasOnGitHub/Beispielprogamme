package buchhandlung;

/**
 * beendet einen Thread
 * @author Doro
 *
 */
public class Feierabend2 implements Runnable{

	private Thread t;
	
	/**
	 * erstellt einen Feierabend für den angegebenen Thread
	 * @param t anzuhaltender Thread
	 */
	public Feierabend2(Thread t)
	{
		this.t = t;
	}
	/**
	 * beendet des Thread nach angemessener Wartezeit
	 */
	public void run()
	{
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
		}
		t.interrupt();
		try {
			t.join();
		} catch (InterruptedException e) {}
		System.out.println("Jetzt ist echt alles aus...");
	}
}
