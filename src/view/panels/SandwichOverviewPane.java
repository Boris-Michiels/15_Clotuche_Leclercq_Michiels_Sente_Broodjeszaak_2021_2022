package view.panels;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Beleg;
import model.Broodje;
import model.database.DataBaseContext;

import java.util.ArrayList;


public class SandwichOverviewPane extends GridPane {
	private TableView<Broodje> BroodjesTable = new TableView<>();
	private TableView<Beleg> BelegTable = new TableView<>();


	public SandwichOverviewPane() {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
		this.add(new Label("Broodjes:"), 0, 0, 1, 1);
		this.add(BroodjesTable, 0, 1, 2, 1);
		TableColumn<Broodje,String> nameColumnBroodje = new TableColumn<Broodje,String>("Naam");
		nameColumnBroodje.setCellValueFactory(new PropertyValueFactory<Broodje,String>("naam"));
		TableColumn<Broodje,String> priceColumnBroodje = new TableColumn<Broodje,String>("Prijs");
		priceColumnBroodje.setCellValueFactory(new PropertyValueFactory<Broodje,String>("verkoopprijs"));
		TableColumn<Broodje,String> stockColumnBroodje = new TableColumn<Broodje,String>("Voorraad");
		stockColumnBroodje.setCellValueFactory(new PropertyValueFactory<Broodje,String>("voorraad"));
		BroodjesTable.getColumns().addAll(nameColumnBroodje,priceColumnBroodje,stockColumnBroodje);

		this.add(new Label("Beleg:"), 0, 2, 1, 1);
		this.add(BelegTable, 0, 3, 2, 1);
		TableColumn<Beleg,String> nameColumnBeleg = new TableColumn<Beleg,String>("Naam");
		nameColumnBeleg.setCellValueFactory(new PropertyValueFactory<Beleg,String>("naam"));
		TableColumn<Beleg,String> priceColumnBeleg = new TableColumn<Beleg,String>("Prijs");
		priceColumnBeleg.setCellValueFactory(new PropertyValueFactory<Beleg,String>("verkoopprijs"));
		TableColumn<Beleg,String> stockColumnBeleg = new TableColumn<Beleg,String>("Voorraad");
		stockColumnBeleg.setCellValueFactory(new PropertyValueFactory<Beleg,String>("voorraad"));
		BelegTable.getColumns().addAll(nameColumnBeleg,priceColumnBeleg,stockColumnBeleg);
	}

	public void updateDisplay(DataBaseContext dataBaseContext) {
		BroodjesTable.setItems(FXCollections.observableArrayList(dataBaseContext.getBroodjes().values()));
		BelegTable.setItems(FXCollections.observableArrayList(dataBaseContext.getBeleg().values()));
	}
}
