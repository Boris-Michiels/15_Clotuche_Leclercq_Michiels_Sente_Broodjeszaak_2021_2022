package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.database.DataBaseContext;
import view.panels.SandwichOverviewPane;

import java.util.ArrayList;

public class AdminMainPane extends BorderPane {
    private SandwichOverviewPane sandwichOverviewPane;

	public AdminMainPane() {
	    TabPane tabPane = new TabPane(); 	    
        //Tab spelVerloopTab = new Tab("Spelverloop");
        sandwichOverviewPane = new SandwichOverviewPane();
        Tab broodjesTab = new Tab("Broodjes/Beleg", sandwichOverviewPane);
        Tab statistiekTab = new Tab("Statistieken");
        Tab instellingTab = new Tab("Instellingen");
        //tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}

    public void updateDisplay(DataBaseContext dataBaseContext) {
        sandwichOverviewPane.updateDisplay(dataBaseContext);
    }
}
