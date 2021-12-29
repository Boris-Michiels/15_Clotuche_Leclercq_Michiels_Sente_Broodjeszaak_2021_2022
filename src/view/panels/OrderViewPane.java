package view.panels;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Beleg;
import model.Broodje;

import java.util.ArrayList;
import java.util.List;

public class OrderViewPane extends GridPane {
    private Button bestelling;
    private Label volgnr;
    private ComboBox<String> promo;
    private HBox top, brood, beleg;
    private VBox menu;
    private OrderViewController orderViewController;

    public OrderViewPane() {
        this.setPadding(new Insets(5));
        this.setVgap(5);
        this.setHgap(5);

        top = new HBox();
        top.setSpacing(10);
        top.setAlignment(Pos.CENTER_LEFT);
        this.add(top, 0, 0, 5, 1);
        bestelling = new Button("Nieuwe Bestelling");
        bestelling.setOnAction(event -> orderViewController.nieuweBestelling());
        volgnr = new Label("Volgnr: 0");
        promo = new ComboBox<>();
        promo.getItems().addAll("test", "pp ", "cncr");
        top.getChildren().add(0, bestelling);
        top.getChildren().add(1, volgnr);
        top.getChildren().add(2, promo);

        menu = new VBox();
        menu.setSpacing(10);
        menu.setAlignment(Pos.CENTER);
        this.add(menu, 0, 1);
        brood = new HBox();
        brood.setSpacing(10);
        beleg = new HBox();
        beleg.setSpacing(10);
        menu.getChildren().addAll(brood, beleg);

        Button test = new Button("print");
        test.setOnAction(event -> orderViewController.test());
        this.add(test, 0, 2);


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

    private void generateBroodButtonsList(HBox brood) {
        List<Button> broodButtonList = new ArrayList<>();
        for (Broodje b : orderViewController.getAvailableBrood()) {
            Button button = new Button(b.getNaam());
            button.setOnAction(event -> orderViewController.addBroodje(button.getText()));
            broodButtonList.add(button);
        }
        brood.getChildren().addAll(broodButtonList);
    }

    private void generateBelegButtonList(HBox beleg) {
        List<Button> belegButtonList = new ArrayList<>();
        for (Beleg b : orderViewController.getAvailableBeleg()) {
            Button button = new Button(b.getNaam());
            button.setOnAction(event -> orderViewController.addBeleg(button.getText()));
            belegButtonList.add(button);
        }
        beleg.getChildren().addAll(belegButtonList);
    }

    public void setVolgnr(String s) {
        volgnr.setText(s);
    }

    public void updateDisplay() {
        //brood.getChildren().setAll(FXCollections.observableArrayList(orderViewController.getAvailableBrood()));
        //beleg.getChildren().setAll(FXCollections.observableArrayList(orderViewController.getAvailableBeleg()));
    }

    public void setOrderViewController(OrderViewController orderViewController) {
        this.orderViewController = orderViewController;
    }

    public void populateMenu() {
        generateBroodButtonsList(brood);
        generateBelegButtonList(beleg);
    }
}
