package javaFxVorlesung;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Model-Klasse für die Laustärkeregelung
 * 
 * @author Doro
 *
 */
public class LautstaerkeModel {
	/**
	 * Minimal einstellbare Lautstärke
	 * @return
	 */
	public int getMinLautstaerke() {
		return 30;
	}

	/**
	 * Maximal einstellbare Lautstärke
	 * @return
	 */
	public int getMaxLautstaerke() {
		return 160;
	}

	/**
	 * aktuelle Lautstärke
	 * @return
	 */
	public int getLautstaerke() {
		return laustaerke.get();
	}

	/**
	 * aktuelle Lautstärke setzen
	 * @param laustaerke
	 */
	public void setLautstaerke(int laustaerke) {
		this.laustaerke.set(laustaerke);
		//Benachrichtigt die Beobachter
	}
	
	/**
	 * liefert die aktuelle Lautstärke
	 * @return
	 */
	public IntegerProperty lautstaerkeProperty()
	{
		return this.laustaerke;
	}

	/**
	 * Stummschaltung
	 * @return
	 */
	public boolean isStumm() {
		return stumm.get();
	}
	
	/**
	 * Stummschaltung
	 * @return
	 */
	public ReadOnlyBooleanProperty stummProperty()
	{
		return this.stumm.getReadOnlyProperty();
				//das Ergebnis ist jetzt wirklich readonly, ohne set-Methode
	}

	/**
	 * The selected audio volume in decibels
	 */
	private IntegerProperty laustaerke = 
			new SimpleIntegerProperty(50);
		//ersetzt: private int lautstaerke = 50;
	/**
	 * Indicates whether audio is muted
	 */
	private ReadOnlyBooleanWrapper stumm = 
			new ReadOnlyBooleanWrapper(false);
	/**
	 * List of some musical genres
	 */
	private ObservableList<String> stile = FXCollections.observableArrayList("Chamber", "Country", "Cowbell", "Metal", "Polka",
			"Rock");

	/**
	 * Liste der verfügbaren Musikrichtungen
	 * @return
	 */
	public ObservableList<String> getStile() {
		return stile;
	}

}
