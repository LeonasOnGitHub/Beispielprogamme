package getraenkeautomat;

import java.util.Scanner;

/**
 * startet einen Getränkeautomaten
 * @author Doro
 *
 */
public class GetraenkeKocher {
	/**
	 * startet den Getränkeautomaten
	 * @param args wird nicht benutzt
	 */
	public static void main(String[] args) {
		Automat gk = new LuxusAutomat();
		getraenkKochen(gk);
	}
	
	/**
	 * bietet die Oberfläche zu einem Getränkeautomaten an
	 * @throws InputMismatchException 
	 * @throws NoSuchElementException 
	 */
	public static void getraenkKochen(Automat a)
	{
		int auswahl;
		Scanner console = new Scanner(System.in);
		System.out.println(a.textErzeugen());
		auswahl = console.nextInt();
		AutomatenGetraenk g = a.erzeugen(auswahl);
		
		g.kochen();
	}
}
