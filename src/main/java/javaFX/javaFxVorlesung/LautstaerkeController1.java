package javaFxVorlesung;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

/**
 * Startpunkt der Lautstärkeregelungsanwendung und Controller für
 * die Ereignisse der Oberfläche
 * @author Doro
 *
 */
public class LautstaerkeController1 extends Application 
{
	/**
	 * Das Model mit den aktuellen Daten der Lautstärke
	 */
	private LautstaerkeModel acModel = new LautstaerkeModel();
	/**
	 * Das Hauptfenster der Anwendung
	 */
	private Stage stage;
	
	@Override
	public void start(Stage primaryStage)
	{
		stage = primaryStage;
		Parent lc = new LautstaerkeOberflaeche1(acModel, this);
		Scene scene = new Scene(lc, 320, 343);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Audio Configuration");
		primaryStage.show();
	}
	
/*	public static void main(String[] args) {
		launch(args);
	}
*/
	
	/**
	 * Ereignisbehandlung für die Auswahl einer neuen 
	 * Musikrichtung
	 * @param selected Index der gewählten Musikrichtung
	 */
	protected void aendern(String selected) {
		switch (selected) {
		case "Chamber":
			acModel.setLautstaerke(80);
			break;
		case "Country":
			acModel.setLautstaerke(100);
			break;
		case "Cowbell":
			acModel.setLautstaerke(150);
			break;
		case "Metal":
			acModel.setLautstaerke(140);
			break;
		case "Polka":
			acModel.setLautstaerke(120);
			break;
		case "Rock":
			acModel.setLautstaerke(130);
		}
//TODO: entfernen, ist ausschließlich zum Testen in
		// der Vorlesung:
		System.out.println("Lautstärke geändert: " + selected + " - " + acModel.getLautstaerke());
	}
	
	/**
	 * Schließen des Fensters
	 */
	public void schliessen()
	{
		stage.close();
	}
}
