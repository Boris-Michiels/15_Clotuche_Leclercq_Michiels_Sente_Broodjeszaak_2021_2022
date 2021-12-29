package view;

import controller.AdminViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminView {
	private Stage stage = new Stage();
	private BorderPane borderPane;
	private AdminViewController adminViewController;
		
	public AdminView() {
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(680);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 400);
		borderPane = new AdminMainPane();
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public void updateDisplay() {
		((AdminMainPane) borderPane).updateDisplay();
	}

	public void setAdminViewController(AdminViewController adminViewController) {
		this.adminViewController = adminViewController;
		((AdminMainPane) borderPane).setAdminViewController(adminViewController);
	}
}
