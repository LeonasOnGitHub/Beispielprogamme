package getraenkeautomat;

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
	 * Auswahltext des Automaten
	 * @return
	 */
	public abstract String textErzeugen();

}
