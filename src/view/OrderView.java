package view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class OrderView {
	private Stage stage = new Stage();
		
	public OrderView() {
		stage.setTitle("ORDER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 650);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
        VBox NBestelling = new VBox(40);
		NBestelling.setAlignment(Pos.TOP_LEFT);
		Label type = new Label("Nieuwe Bestelling");
		////
		VBox bestelOpties = new VBox(40);
		bestelOpties.setAlignment(Pos.TOP_RIGHT);
		ComboBox<String> promotie = new ComboBox<>();
		promotie.getItems().addAll("Test", "Goedkoopste broodje gratis");
		////





		VBox beleg = new VBox(400);
		//beleg.setBackground(new Background(new BackgroundFill(new Color(0, 10, 50, 10))));

		VBox AantalBroodjes = new VBox(40);
		NBestelling.setAlignment(Pos.CENTER_LEFT);
		Label aantal_broodjes = new Label("Aantal broodjes");

		HBox broodjesbox = new HBox(100);

		HBox belegbox = new HBox(100);


		////










	}
}
