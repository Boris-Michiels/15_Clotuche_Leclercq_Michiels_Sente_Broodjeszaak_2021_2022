package view;

import controller.OrderViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.panels.OrderViewPane;

public class OrderView {
	private Stage stage = new Stage();
	private GridPane gridPane;
	private OrderViewController orderViewController;
		
	public OrderView() {
		stage.setTitle("ORDER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 650);
		gridPane = new OrderViewPane();
		root.getChildren().add(gridPane);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public void updateDisplay() {
		((OrderViewPane) gridPane).updateDisplay();
	}

	public void setOrderViewController(OrderViewController orderViewController) {
		this.orderViewController = orderViewController;
		((OrderViewPane) gridPane).setOrderViewController(orderViewController);
	}

	public void populateMenu() {
		((OrderViewPane) gridPane).populateMenu();
	}

	public void updateBestellijnen() {
		((OrderViewPane) gridPane).updateDisplay();
	}

	public void updateStatusBroodjesKnoppen() {
		((OrderViewPane) gridPane).updateDisplay();
	}

    public void displayMessage(String message) {
		Stage popup = new Stage();
		popup.initStyle(StageStyle.UTILITY);
		popup.setTitle("Error");
		VBox dialogVbox = new VBox(20);
		dialogVbox.getChildren().add(new Text(message));
		Scene dialogScene = new Scene(dialogVbox, 300, 200);
		popup.setScene(dialogScene);
		popup.sizeToScene();
		popup.show();
    }
}
