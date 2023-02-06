package verschiedenes;
import bankprojekt.verarbeitung.Kunde;

/**
 * wandelt Kunden in String um
 * @author Doro
 *
 */
public interface Umwandlung
{
	/**
	 * macht aus k einen String
	 * @param k
	 * @return
	 */
	public String umwandeln(Kunde k);
}