package wetter;

/**
 * Anzeigeelement fürs Wetter
 * @author Admin
 *
 */
public interface Beobachter {
	/** wird bei jeder Wetteränderung aufgerufen
	 * 
	 * @param w
	 */
	void aktualisieren(Wetterdaten w);
}
