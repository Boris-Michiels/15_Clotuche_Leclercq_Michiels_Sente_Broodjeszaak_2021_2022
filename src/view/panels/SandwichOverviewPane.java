package view.panels;

import controller.AdminViewController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Beleg;
import model.Broodje;


public class SandwichOverviewPane extends GridPane {
	private TableView<Broodje> BroodjesTable = new TableView<>();
	private TableView<Beleg> BelegTable = new TableView<>();
	private AdminViewController adminViewController;


	public SandwichOverviewPane(AdminViewController adminViewController) {
		this.adminViewController = adminViewController;
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		this.add(new Label("Broodjes:"), 0, 0, 1, 1);
		this.add(BroodjesTable, 0, 1, 2, 1);
		TableColumn<Broodje, String> nameColumnBroodje = new TableColumn<>("Naam");
		nameColumnBroodje.setCellValueFactory(new PropertyValueFactory<>("naam"));
		TableColumn<Broodje, String> priceColumnBroodje = new TableColumn<>("Prijs");
		priceColumnBroodje.setCellValueFactory(new PropertyValueFactory<>("verkoopprijs"));
		TableColumn<Broodje, String> stockColumnBroodje = new TableColumn<>("Voorraad");
		stockColumnBroodje.setCellValueFactory(new PropertyValueFactory<>("voorraad"));
		BroodjesTable.getColumns().addAll(nameColumnBroodje, priceColumnBroodje, stockColumnBroodje);

		this.add(new Label("Beleg:"), 0, 2, 1, 1);
		this.add(BelegTable, 0, 3, 2, 1);
		TableColumn<Beleg, String> nameColumnBeleg = new TableColumn<>("Naam");
		nameColumnBeleg.setCellValueFactory(new PropertyValueFactory<>("naam"));
		TableColumn<Beleg, String> priceColumnBeleg = new TableColumn<>("Prijs");
		priceColumnBeleg.setCellValueFactory(new PropertyValueFactory<>("verkoopprijs"));
		TableColumn<Beleg, String> stockColumnBeleg = new TableColumn<>("Voorraad");
		stockColumnBeleg.setCellValueFactory(new PropertyValueFactory<>("voorraad"));
		BelegTable.getColumns().addAll(nameColumnBeleg, priceColumnBeleg, stockColumnBeleg);
	}

	public void updateDisplay() {
		BroodjesTable.setItems(FXCollections.observableArrayList(adminViewController.getBroodjes().values()));
		BelegTable.setItems(FXCollections.observableArrayList(adminViewController.getBeleg().values()));
	}

	public void setAdminViewController(AdminViewController adminViewController) {
		this.adminViewController = adminViewController;
	}
}
