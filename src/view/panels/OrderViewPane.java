package view.panels;

import controller.OrderViewController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Beleg;
import model.BestelLijn;
import model.Broodje;

import java.util.ArrayList;
import java.util.List;

public class OrderViewPane extends GridPane {
    private Button bestelling;
    private Label volgnr;
    private Label aantal;
    private ComboBox<String> promo;
    private HBox top, brood, beleg;
    private VBox menu;
    private TableView bestellijnTable;
    TableColumn<BestelLijn, String> broodjesColumn, belegColumn;
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
        bestelling.setOnAction(event -> {orderViewController.nieuweBestelling(); bestelling.setDisable(true);});
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

        aantal = new Label("Aantal broodjes: 0");
        this.add(aantal, 0, 2);

        bestellijnTable = new TableView<>();
        this.add(bestellijnTable, 0, 3);
        broodjesColumn = new TableColumn<>("Broodje");
        broodjesColumn.setCellValueFactory(new PropertyValueFactory<>("naambroodje"));
        belegColumn = new TableColumn<>("Beleg");
        belegColumn.setCellValueFactory(new PropertyValueFactory<>("belegString"));
        //bestellijnTable.getColumns().setAll(broodjesColumn, belegColumn);

        /*Button test = new Button("print");
        test.setOnAction(event -> orderViewController.test());
        this.add(test, 0, 4);*/
    }

    private void generateBroodButtonsList(HBox brood) {
        List<Button> broodButtonList = new ArrayList<>();
        for (Broodje b : orderViewController.getAvailableBrood()) {
            Button button = new Button(b.getNaam());
            button.setOnAction(event -> orderViewController.addBroodje(button.getText()));
            broodButtonList.add(button);
        }
        brood.getChildren().setAll(broodButtonList);
    }

    private void generateBelegButtonList(HBox beleg) {
        List<Button> belegButtonList = new ArrayList<>();
        for (Beleg b : orderViewController.getAvailableBeleg()) {
            Button button = new Button(b.getNaam());
            button.setOnAction(event -> orderViewController.addBeleg(button.getText()));
            belegButtonList.add(button);
        }
        beleg.getChildren().setAll(belegButtonList);
    }

    public void setVolgnr(String s) {
        volgnr.setText(s);
    }

    public void updateDisplay() {
        bestellijnTable.setItems(FXCollections.observableArrayList(orderViewController.getBestelLijnen()));
        setAantal(orderViewController.getBestelLijnen().size());
        populateMenu();
        bestellijnTable.getColumns().setAll(broodjesColumn, belegColumn);
    }

    public void setOrderViewController(OrderViewController orderViewController) {
        this.orderViewController = orderViewController;
    }

    public void populateMenu() {
        generateBroodButtonsList(brood);
        generateBelegButtonList(beleg);
    }

    public void setAantal(int aantal) {
        this.aantal.setText("Aantal broodjes: " + aantal);
    }
}
