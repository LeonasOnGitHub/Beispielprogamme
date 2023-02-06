package javaFxVorlesung;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.event.ActionEvent;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Oberfläche für Lautstärkeregelung
 * @author Doro
 *
 */
public class LautstaerkeOberflaeche1 extends Group{
	
	/**
	 * baut die gesamte Oberfläche auf
	 * @param lsModel Model, in dem die aktuellen Laustärkedaten 
	 * 			gespeichert sind/werden
	 * @param controller  Controller für die Ereignisbehandlung
	 */
	public LautstaerkeOberflaeche1(LautstaerkeModel lsModel,
			LautstaerkeController1 controller)
	{
		this.lsModel = lsModel;
		this.controller = controller;
		this.aufbauen();
	}
	
	private Slider slider;
	private CheckBox stummCheckBox;
	private ChoiceBox<String> stilChoiceBox;
	private Text dbText;

	private LautstaerkeModel lsModel;
	private LautstaerkeController1 controller;
	
	/**
	 * erstellt die Oberfläche
	 */
	private void aufbauen() {
		Text titleText = new Text();
		titleText.setLayoutX(65);
		titleText.setLayoutY(20);
		titleText.setText("Audio Configuration");
		titleText.setFill(Color.RED);
		titleText.setFont(new Font("Sans Serif", 20));
		
		dbText = new Text("db");
		dbText.setLayoutX(18);
		dbText.setLayoutY(69);
		dbText.setTextOrigin(VPos.TOP);
		dbText.setFill(Color.web("#131021"));
		dbText.setFont(Font.font("SansSerif", FontWeight.BOLD, 18));
		
		Text mutingText = new Text(18, 113, "Muting");
		mutingText.setTextOrigin(VPos.TOP);
		mutingText.setFont(Font.font("SanSerif", FontWeight.BOLD, 18));
		mutingText.setFill(Color.web("#131021"));
		
		Text genreText = new Text(18,154,"Genre");
		genreText.setTextOrigin(VPos.TOP);
		genreText.setFill(Color.web("#131021"));
		genreText.setFont(Font.font("SanSerif", FontWeight.BOLD, 18));
		
		slider = new Slider();
		slider.setLayoutX(135);
		slider.setLayoutY(69);
		slider.setPrefWidth(162);
		slider.setMin(lsModel.getMinLautstaerke());
		slider.setMax(lsModel.getMaxLautstaerke());
		
		stummCheckBox = new CheckBox();
		stummCheckBox.setLayoutX(280);
		stummCheckBox.setLayoutY(113);
		
		stilChoiceBox = new ChoiceBox<String>();
		stilChoiceBox.setLayoutX(204);
		stilChoiceBox.setLayoutY(154);
		stilChoiceBox.setPrefWidth(93);
		stilChoiceBox.setItems(lsModel.getStile());
		
		Button schliessen = new Button("schließen");
		schliessen.setLayoutX(130);
		schliessen.setLayoutY(200);
		
		/*
		Color color = Color.color(0.66, 0.67, 0.69);
		Stop[] stops = new Stop[]{new Stop(0, Color.web("0xAEBBCC")), new Stop(1,
		Color.web("0x6D84A3"))};
		LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true,
		CycleMethod.NO_CYCLE, stops);
		Rectangle rectangle = new Rectangle(0, 0, 320, 45);
		rectangle.setFill(linearGradient);
		Rectangle rectangle2 = new Rectangle(0, 43, 320, 300);
		rectangle2.setFill(Color.rgb(199, 206, 213));
		Rectangle rectangle3 = new Rectangle(8, 54, 300, 130);
		rectangle3.setArcHeight(20);
		rectangle3.setArcWidth(20);
		rectangle3.setFill(Color.WHITE);
		rectangle3.setStroke(color);
		Line line1 = new Line(9, 97, 309, 97);
		line1.setStroke(color);
		Line line2 = new Line(9, 141, 309, 141);
		line2.setFill(color);
		*/

		this.getChildren().add(titleText);
		this.getChildren().add(dbText);
		this.getChildren().add(slider);
		this.getChildren().add(mutingText);
		this.getChildren().add(stummCheckBox);
		this.getChildren().add(genreText);
		this.getChildren().add(stilChoiceBox);
		this.getChildren().add(schliessen);
		
		schliessen.setOnAction(e -> controller.schliessen());
		/*stilChoiceBox.setOnAction(
		 */
		/*stilChoiceBox.addEventHandler(ActionEvent.ACTION,
				(e -> controller.aendern(stilChoiceBox.getValue())));
				*/
		stilChoiceBox.valueProperty().addListener
				(e -> controller.aendern(stilChoiceBox.getValue()));
		
		/*lsModel.lautstaerkeProperty().addListener
			(e -> slider.setValue(lsModel.getLautstaerke()));
		*/
		slider.valueProperty().bindBidirectional(lsModel.lautstaerkeProperty());
		dbText.textProperty().bind(
				lsModel.lautstaerkeProperty().asString().concat(" db"));

		stilChoiceBox.getSelectionModel().selectFirst();
	}
}
