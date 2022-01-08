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
import java.util.Map;
import java.util.stream.Collectors;

public class OrderViewPane extends GridPane {
    private Button bestelling, idemButton, removeButton;
    private Label volgnr;
    private Label aantal;
    private ComboBox<String> promo;
    private HBox top, brood, beleg;
    private VBox menu, buttonBox;
    private TableView<BestelLijn> bestellijnTable;
    private TableColumn<BestelLijn, String> broodjesColumn, belegColumn;
    private boolean inWacht;
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
        promo.getItems().addAll("test", "pp", "cncr");
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
        bestellijnTable.setOnMouseClicked(event -> setLijnButtons());
        this.add(bestellijnTable, 0, 3);
        broodjesColumn = new TableColumn<>("Broodje");
        broodjesColumn.setCellValueFactory(new PropertyValueFactory<>("naambroodje"));
        belegColumn = new TableColumn<>("Beleg");
        belegColumn.setCellValueFactory(new PropertyValueFactory<>("belegString"));
        bestellijnTable.getColumns().setAll(broodjesColumn, belegColumn);

        idemButton = new Button("Zelfde broodje toevoegen");
        idemButton.setDisable(true);
        idemButton.setOnAction(event -> idemButtonClicked());

        removeButton = new Button("Verwijder broodje");
        removeButton.setDisable(true);
        removeButton.setOnAction(event -> removeButtonClicked());

        buttonBox = new VBox();
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.TOP_LEFT);
        buttonBox.getChildren().setAll(idemButton, removeButton);
        this.add(buttonBox, 1, 3);

        Button test = new Button("println");
        test.setOnAction(event -> orderViewController.test());
        this.add(test, 0, 5);
    }

    private void setLijnButtons() {
        setRemoveButton();
        setIdemButton();
    }

    public void setVolgnr(String s) {
        volgnr.setText(s);
    }

    public void updateDisplay() {
        updateMenu();
        updateBestellijnen();
    }

    public void setOrderViewController(OrderViewController orderViewController) {
        this.orderViewController = orderViewController;
    }

    private void setRemoveButton() {
        removeButton.setDisable(bestellijnTable.getSelectionModel().getSelectedItem() == null || inWacht);
    }

    public void removeButtonClicked() {
        orderViewController.removeBestellijn(bestellijnTable.getSelectionModel().getSelectedItem());
        setLijnButtons();
    }

    private void setIdemButton() {
        idemButton.setDisable(bestellijnTable.getSelectionModel().getSelectedItem() == null || inWacht);
    }

    public void idemButtonClicked() {
        orderViewController.addBestellijn(bestellijnTable.getSelectionModel().getSelectedItem());
    }

    public void updateMenu() {
        updateBroodButtonList();
        updateBelegButtonList();
    }

    public void updateBestellijnen() {
        bestellijnTable.setItems(FXCollections.observableArrayList(orderViewController.getBestelLijnen()));
        setAantal(orderViewController.getBestelLijnen().size());
        bestellijnTable.getColumns().setAll(broodjesColumn, belegColumn);
    }

    private void updateBroodButtonList() {
        List<Button> broodButtonList = new ArrayList<>();
        Map<String, Integer> broodjes = orderViewController.getVoorraadlijstBroodjes();
        for (String n : broodjes.keySet().stream().sorted().collect(Collectors.toList())) {
            Button button = new Button(n);
            button.setOnAction(event -> orderViewController.addBroodje(button.getText()));
            button.setDisable(broodjes.get(n) == 0 || getInWacht());
            broodButtonList.add(button);
        }
        this.brood.getChildren().setAll(broodButtonList);
    }

    private void updateBelegButtonList() {
        List<Button> belegButtonList = new ArrayList<>();
        Map<String, Integer> beleg = orderViewController.getVoorraadlijstBeleg();
        for (String n : beleg.keySet().stream().sorted().collect(Collectors.toList())) {
            Button button = new Button(n);
            button.setOnAction(event -> orderViewController.addBeleg(button.getText(), bestellijnTable.getSelectionModel().getSelectedItem()));
            button.setDisable(beleg.get(n) == 0 || getInWacht());
            belegButtonList.add(button);
        }
        this.beleg.getChildren().setAll(belegButtonList);
    }

    public void setAantal(int aantal) {
        this.aantal.setText("Aantal broodjes: " + aantal);
    }

    public void selectLastBestellijn() {
        if (bestellijnTable.getItems().size() > 0) bestellijnTable.getSelectionModel().select(bestellijnTable.getItems().size() - 1);
        setLijnButtons();
    }

    public void setInWacht(boolean b) {
        this.inWacht = b;
        bestelling.setDisable(!inWacht);
        promo.setDisable(inWacht);
        setLijnButtons();
        updateBroodButtonList();
        updateBelegButtonList();
    }

    public boolean getInWacht() {
        return inWacht;
    }
}
