package view;


import controller.AdminViewController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.SandwichOverviewPane;

public class AdminMainPane extends BorderPane {
    private SandwichOverviewPane sandwichOverviewPane;
    private AdminViewController adminViewController;

	public AdminMainPane(AdminViewController adminViewController) {
        this.adminViewController = adminViewController;
	    TabPane tabPane = new TabPane(); 	    
        //Tab spelVerloopTab = new Tab("Spelverloop");
        sandwichOverviewPane = new SandwichOverviewPane(adminViewController);
        Tab broodjesTab = new Tab("Broodjes/Beleg", sandwichOverviewPane);
        Tab statistiekTab = new Tab("Statistieken");
        Tab instellingTab = new Tab("Instellingen");
        //tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}

    public void updateDisplay() {
        sandwichOverviewPane.updateDisplay();
    }

    public void setAdminViewController(AdminViewController adminViewController) {
        this.adminViewController = adminViewController;
        (sandwichOverviewPane).setAdminViewController(adminViewController);
    }
}
