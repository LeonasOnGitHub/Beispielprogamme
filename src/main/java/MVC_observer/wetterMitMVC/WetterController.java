package wetterMitMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ein Controller für eine Wetteroberfläche
 * @author Doro
 *
 */
public class WetterController implements ActionListener{
	private Wetterdaten berlin;
	private Wetteroberflaeche wo;
	
	/**
	 * erstellt den Controller für die beiden angegebenen Wetterdaten und bringt die zugehörige 
	 * Wetteroberflaeche auf den Bildschirm
	 * @param b die Wetterdaten
	 */
	public WetterController(Wetterdaten b)
	{
		berlin = b;
		wo = new Wetteroberflaeche(this);
		berlin.anmelden(wo);
	}
	
	/**
	 * reagiert auf den Sonnentanz-Button
	 */
	public void sonne()
	{
		berlin.sonnentanz();
		wo.aktionSetzen(true);
	}

	/**
	 * regiert auf den Regentanz-Button
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		berlin.regentanz();	
		wo.aktionSetzen(false);
	}
}
