package application;
	
import controller.AdminViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.database.DataBaseContext;
import view.AdminView;
import view.KitchenView;
import view.OrderView;


public class BroodjeszaakMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		AdminViewController adminViewController = new AdminViewController();
		AdminView adminView = new AdminView(adminViewController);
		adminViewController.update();
		//adminViewController.setLoadSaveStrategy("Tekst");
		OrderView orderView = new OrderView();
		KitchenView kitchenView = new KitchenView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
