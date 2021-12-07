package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.database.DataBaseContext;
import view.AdminView;
import view.KitchenView;
import view.OrderView;


public class BroodjeszaakMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		DataBaseContext dataBaseContext = new DataBaseContext();
		dataBaseContext.setBroodjesLoadSaveStrategy("BROODJESTEKST");
		dataBaseContext.setBelegLoadSaveStrategy("BELEGTEKST");
		dataBaseContext.loadBroodjes("src/bestanden/broodjes.txt");
		dataBaseContext.loadBeleg("src/bestanden/beleg.txt");
		AdminView adminView = new AdminView(dataBaseContext);
		OrderView orderView = new OrderView();
		KitchenView kitchenView = new KitchenView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
