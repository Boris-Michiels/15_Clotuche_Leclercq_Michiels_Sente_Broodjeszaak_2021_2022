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
import model.database.BelegDatabase;
import model.database.BroodjesDatabase;


public class SandwichOverviewPane extends GridPane{
	private BroodjesDatabase broodjesDatabase = new BroodjesDatabase();
	private BelegDatabase belegDatabase = new BelegDatabase();
	private TableView<Broodje> BroodjesTable = new TableView<Broodje>();
	private TableView<Beleg> BelegTable = new TableView<Beleg>();


	public SandwichOverviewPane() {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
		this.add(new Label("Broodjes:"), 0, 0, 1, 1);
		BroodjesTable.setItems(FXCollections.observableArrayList(BroodjesDatabase.getBroodjes().values()));
		BroodjesTable.refresh();
		TableColumn<Broodje,String> nameColumnBroodje = new TableColumn<Broodje,String>("Naam Brood");
		nameColumnBroodje.setCellValueFactory(new PropertyValueFactory<Broodje,String>("naam"));
		TableColumn<Broodje,String> priceColumnBroodje = new TableColumn<Broodje,String>("Prijs");
		priceColumnBroodje.setCellValueFactory(new PropertyValueFactory<Broodje,String>("prijs"));
		TableColumn<Broodje,String> stockColumnBroodje = new TableColumn<Broodje,String>("Voorraad");
		stockColumnBroodje.setCellValueFactory(new PropertyValueFactory<Broodje,String>("voorraad"));
		BroodjesTable.getColumns().addAll(nameColumnBroodje,priceColumnBroodje,stockColumnBroodje);

		BelegTable.setItems(FXCollections.observableArrayList(BelegDatabase.getBeleg().values()));
		BelegTable.refresh();
		TableColumn<Beleg,String> nameColumnBeleg = new TableColumn<Beleg,String>("Naam Beleg");
		nameColumnBeleg.setCellValueFactory(new PropertyValueFactory<Beleg,String>("naam"));
		TableColumn<Beleg,String> priceColumnBeleg = new TableColumn<Beleg,String>("Prijs");
		priceColumnBeleg.setCellValueFactory(new PropertyValueFactory<Beleg,String>("prijs"));
		TableColumn<Beleg,String> stockColumnBeleg = new TableColumn<Beleg,String>("Voorraad");
		stockColumnBeleg.setCellValueFactory(new PropertyValueFactory<Beleg,String>("voorraad"));
		BelegTable.getColumns().addAll(nameColumnBeleg,priceColumnBeleg,stockColumnBeleg);


	}
}
