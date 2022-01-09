package application;

import controller.AdminViewController;
import controller.OrderViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.BestelFacade;
import view.AdminView;
import view.KitchenView;
import view.OrderView;


public class BroodjeszaakMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        BestelFacade bestelFacade = new BestelFacade();
        AdminView adminView = new AdminView();
        AdminViewController adminViewController = new AdminViewController(adminView, bestelFacade);
        OrderView orderView = new OrderView();
        OrderViewController orderViewController = new OrderViewController(orderView, bestelFacade);
        KitchenView kitchenView = new KitchenView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
