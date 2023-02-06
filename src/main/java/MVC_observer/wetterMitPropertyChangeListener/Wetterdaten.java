package wetterMitPropertyChangeListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.List;

/**
 * enthält die Beschreibung einer Wettersituation aus Temperatur,
 * Luftfeuchtigkeit und Luftdruck
 */
public class Wetterdaten {

	private double temperatur;
	private double feuchtigkeit;
	private double luftdruck;
	private double sonne = 0;
	private double regen = 0;
	
	private PropertyChangeSupport prop = 
			new PropertyChangeSupport(this);
	
	/**
	* meldet b am Subjekt an
	*/
        public void anmelden(PropertyChangeListener b)
        {
            prop.addPropertyChangeListener(b);
        }

	/**
	* meldet b am Subjekt wieder ab
	*/
        public void abmelden(PropertyChangeListener b)
        {
        	prop.removePropertyChangeListener(b);
        }

	/**
	* Benachrichtigung an Beobachter senden
	* @param name Name des veränderten Wertes
	* @param alt bisheriger Wert
	* @param neu aktueller Wert
	*/
	protected void firePropertyChange(String name, Object alt, Object neu)
	{
		prop.firePropertyChange(name, alt, neu);
	}


	/**
	 * erstellt eine Wettersituation, in der Temperatur, Luftfeuchtigkeit und
	 * Luftdruck 0 sind
	 */
	public Wetterdaten() {
		this.temperatur = 0;
		this.feuchtigkeit = 0;
		this.luftdruck = 0;
	}

	/**
	 * Setzen der aktuellen Wettersituation
	 * 
	 * @param temp
	 *            aktueller Temperaturwert
	 * @param feucht
	 *            aktuelle Luftfeuchtigkeit
	 * @param druck
	 *            aktueller Luftdruck
	 */
	public void setMesswerte(double temp, double feucht, double druck) {
		double alt = this.temperatur;
		this.temperatur = temp + sonne;
		prop.firePropertyChange("Temperatur", alt, this.temperatur);
				//wenn alt == neu, dann keine Benachrichtigung senden
		alt = this.feuchtigkeit;
		this.feuchtigkeit = feucht + regen;
		prop.firePropertyChange("Feuchtigkeit", alt, this.feuchtigkeit);
		alt = this.luftdruck;
		this.luftdruck = druck;
		prop.firePropertyChange("Druck", alt, this.luftdruck);
	}

	/**
	 * liefert die aktuelle gespeicherte Temperatur zurück
	 * 
	 * @return aktuelle Temperatur
	 */
	public double getTemperatur() {
		return temperatur;
	}

	/**
	 * liefert die aktuelle gespeicherte Luftfeuchtigkeit zurück
	 * 
	 * @return aktuelle Luftfeuchtigkeit
	 */
	public double getFeuchtigkeit() {
		return feuchtigkeit;
	}

	/**
	 * liefert den aktuell gespeicherten Luftdruck zurück
	 * 
	 * @return aktueller Luftdruck
	 */
	public double getLuftdruck() {
		return luftdruck;
	}
	
	/**
	 * führt einen Sonnentanz durch und erhöht dadurch grundsätzlich die Temperatur
	 */
	public void sonnentanz()
	{
		sonne++;
	}
	
	/**
	 * führt einen Regentanz durch und erhöht dadurch grundsätzlich die Feuchtigkeit
	 */
	public void regentanz()
	{
		regen++;
	}
}