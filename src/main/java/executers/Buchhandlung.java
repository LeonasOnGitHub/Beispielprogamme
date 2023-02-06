package buchhandlungMitExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
	private AtomicInteger anzahlBuecher = new AtomicInteger(0);
	/**
	 * ob die Buchhandlung geschlossen ist oder nicht
	 */
	private boolean geschlossen = false;
	
	private Lock anzahlLock = new ReentrantLock();
	private Condition anzahlGroesser0 = anzahlLock.newCondition();
	

	/**
	 * @return the anzahlGroesser0
	 */
	public Condition getAnzahlGroesser0() {
		return anzahlGroesser0;
	}

	/**
	 * @return the anzahlLock
	 */
	public Lock getAnzahlLock() {
		return anzahlLock;
	}

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
	public AtomicInteger getAnzahlBuecher() {
		return anzahlBuecher;
	}

	/**
 	* stellt nacheinander insgesamt viele Bücher ins Regal
 	*/
	public void auffuellen()
	{
			int anzahl;
			anzahlLock.lock();
				anzahl = this.getAnzahlBuecher().getAndIncrement();
				anzahlGroesser0.signalAll();
			anzahlLock.unlock();
			System.out.println("im Regal: "+anzahl);
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
		Kaeufer kaeufer = new Kaeufer(buchUndZeitschrift);
		
		ExecutorService service;
		service = Executors.newCachedThreadPool();
		
		 
		Runnable kaeuferTask = () -> kaeufer.kaufen(200);
		for(int i=0; i< 5; i++)
		{
			service.submit(kaeuferTask);
		}
		ScheduledExecutorService zeitService;
		zeitService = Executors.newScheduledThreadPool(0);
		
		Future<?> feierabend2 = zeitService.scheduleWithFixedDelay(() -> buchUndZeitschrift.auffuellen(),
				0, 5, TimeUnit.MILLISECONDS);
		
		Future<AtomicInteger> inventur = zeitService.schedule(() -> 
			{feierabend2.cancel(false);
			 buchUndZeitschrift.setGeschlossen(true);
			 return buchUndZeitschrift.getAnzahlBuecher();
			},
				1, TimeUnit.SECONDS);
		
		System.out.println("passiert sofort");
		try {
			System.out.println("Jetzt noch im Laden: " + inventur.get());
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}
		
/*		Runnable feierabend = () -> buchUndZeitschrift.schliessen(200);
		Thread tf = new Thread(feierabend);
		tf.start();
*/		
		service.shutdown();
	}

}










