package getraenkeautomatMitFactoryMethod;

import java.io.*;
import java.util.Scanner;

/**
 * bietet die Oberfläche zu einem Getränkeautomaten an
 */
public abstract class Automat {
	
	/**
	 * erzeutg ein zur Ausewahl passendes getränk
	 * @param auswahl
	 * @return
	 */
	public abstract AutomatenGetraenk erzeugen(int auswahl);

	
	/**
	 * bietet die Oberfläche zu einem Getränkeautomaten an
	 * @throws InputMismatchException 
	 * @throws NoSuchElementException 
	 */
	public void getraenkKochen()
	{
		int auswahl;
		Scanner console = new Scanner(System.in);
		System.out.println("Wollen Sie Kaffee (1) oder Tee (2)?");
		auswahl = console.nextInt();
		AutomatenGetraenk g = erzeugen(auswahl);
		
		g.kochen();
	}

}
