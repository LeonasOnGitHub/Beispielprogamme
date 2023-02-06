package verschiedenes;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

import bankprojekt.verarbeitung.*;


/**
 * Spielereien mit Dateien
 * @author Doro
 *
 */
public class DateiLesen {

	/**
	 * liest und schreibt Dateien
	 * @param args wird nicht genutzt
	 * @throws IOException tritt nicht auf
	 */
	public static void main(String[] args) throws IOException
	{
		
		Kunde ich = new Kunde("Dorothea", "Hubrich", "zuhause", "13.07.76");
		Konto k = new Girokonto(ich, 1234, 0);

		Ueberweisebank b = new Ueberweisebank(34569);
		
		FileOutputStream fo = new FileOutputStream("konto.blub");
		ObjectOutputStream oo = new ObjectOutputStream(fo);
		oo.writeObject(k);
		oo.writeObject("Hallo, hier ist ein Objekt");
		oo.writeObject(b);
		oo.close();
		
		FileInputStream fi = new FileInputStream("konto.blub");
		ObjectInputStream oi = new ObjectInputStream(fi);
		Konto gelesen;
		try {
			gelesen = (Konto) oi.readObject();
			String s = (String) oi.readObject();
			System.out.println(gelesen);
			Ueberweisebank neueBank = (Ueberweisebank) oi.readObject();
			System.out.println(neueBank.getManager());
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		oi.close();
		
		
		BufferedReader console = new BufferedReader(
									new InputStreamReader(System.in));
		String datei;
		
		datei = console.readLine();
		System.out.println(datei);
		
		//PrintStream anders = new PrintStream("irgendwohin.txt");
		//System.setOut(anders);
		
		
		try 
		(FileReader stromInnen = new FileReader(datei);
			BufferedReader stromAussen = new BufferedReader(stromInnen);
			LineNumberReader lnr = new LineNumberReader(stromAussen);)
		{
			String zeile;
			while(lnr.ready())
			{
				zeile = lnr.readLine();
				System.out.println(lnr.getLineNumber() + ": " + zeile);
				if(zeile.equals("Ende"))
					return;
			}
		}
		catch (FileNotFoundException e) {System.out.println("im Catch");}	

		
		
	}

}
