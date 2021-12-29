package view.panels;

import controller.OrderViewController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Broodje;

import java.util.ArrayList;
import java.util.List;

public class OrderViewPane extends GridPane {
    private Button bestelling;
    private Label volgnr;
    private ComboBox<String> promo;
    private HBox brood, beleg;
    private OrderViewController orderViewController;

    public OrderViewPane(OrderViewController orderViewController) {
        this.orderViewController = orderViewController;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        HBox top = new HBox();
        top.setSpacing(10);
        top.setAlignment(Pos.CENTER);
        this.add(top, 0, 0, 5, 1);
        bestelling = new Button("Nieuwe Bestelling");
        volgnr = new Label("Volgnr: 0");
        promo = new ComboBox<>();
        promo.getItems().addAll("test", "pp ", "cncr");
        top.getChildren().add(0, bestelling);
        top.getChildren().add(1, volgnr);
        top.getChildren().add(2, promo);

        VBox menu = new VBox();
        this.add(menu, 0, 1);
        brood = new HBox();
        //generateBroodButtonsList(brood);
        //brood.getChildren().addAll();
        beleg = new HBox();
        //generateBelegButtonList(beleg);
        menu.getChildren().addAll(brood, beleg);


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
    }

    /*private void generateBroodButtonsList(HBox brood) {
        List<Button> broodList = new ArrayList<>();
        for (Broodje b : orderViewController.getAvailableBrood()) {
            Button button = new Button(b.getNaam());
            //button
        }
    }*/

    public void setVolgnr(String s) {
        volgnr.setText(s);
    }

    public void updateDisplay() {
        //brood.getChildren().setAll(FXCollections.observableArrayList(orderViewController.getAvailableBrood()));
        //beleg.getChildren().setAll(FXCollections.observableArrayList(orderViewController.getAvailableBeleg()));
    }
}
