package application;
	
import controller.AdminViewController;
import controller.OrderViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.database.DataBaseService;
import view.AdminView;
import view.KitchenView;
import view.OrderView;


public class BroodjeszaakMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		AdminView adminView = new AdminView();
		AdminViewController adminViewController = new AdminViewController(adminView);
		//adminViewController.update();
		//adminViewController.setLoadSaveStrategy("Tekst");
		OrderView orderView = new OrderView();
		OrderViewController orderViewController = new OrderViewController(orderView);
		KitchenView kitchenView = new KitchenView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
