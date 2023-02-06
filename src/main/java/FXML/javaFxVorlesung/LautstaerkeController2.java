package javaFxVorlesung;

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Startpunkt der Lautstärkeregelungsanwendung und Controller für
 * die Ereignisse der Oberfläche
 * @author Doro
 *
 */
public class LautstaerkeController2 extends Application
{	
	/**
	 * Das Hauptfenster der Anwendung
	 */
	private Stage stage;
	/**
	 * Das Model mit den aktuellen Daten der Lautstärke
	 */
	@FXML private LautstaerkeModel lsModel;
	
	@FXML private Slider slider;
	@FXML private CheckBox stummCheckBox;
	@FXML private ChoiceBox<String> stilChoiceBox;
	@FXML private Text dbText;
	
	@FXML public void initialize()
	{
		stilChoiceBox.getSelectionModel().selectFirst();
		dbText.textProperty().bind(lsModel.lautstaerkeProperty().asString().concat(" dB"));
		slider.valueProperty().bindBidirectional(lsModel.lautstaerkeProperty());
		stummCheckBox.selectedProperty().bindBidirectional(lsModel.stummProperty());
		stilChoiceBox.valueProperty().addListener(
				(Observable e)-> aendern(stilChoiceBox.getValue()));
	}
	
	/**
	 * Ereignisbehandlung für die Auswahl einer neuen 
	 * Musikrichtung
	 * @param selected Index der gewählten Musikrichtung
	 */
	@FXML private void aendern(String selected) {
		switch (selected) {
		case "Chamber":
			lsModel.setLautstaerke(80);
			break;
		case "Country":
			lsModel.setLautstaerke(100);
			break;
		case "Cowbell":
			lsModel.setLautstaerke(150);
			break;
		case "Metal":
			lsModel.setLautstaerke(140);
			break;
		case "Polka":
			lsModel.setLautstaerke(120);
			break;
		case "Rock":
			lsModel.setLautstaerke(130);
		}
	}
	
	/**
	 * Schließen des Fensters
	 */
	@FXML private void schliessen()
	{
		stage.close();
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		stage = primaryStage;
		FXMLLoader loader = 
				new FXMLLoader(getClass().
					getResource("../LautstaerkeOberflaeche2.fxml"));
		loader.setController(this);
		Parent lc = loader.load();
	    Scene scene = new Scene(lc, 300, 275);
        primaryStage.setTitle("Audio Configuration");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
