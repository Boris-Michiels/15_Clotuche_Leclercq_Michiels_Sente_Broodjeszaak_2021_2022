package controller;

import model.database.DataBaseContext;
import view.OrderView;

import javax.xml.crypto.Data;

public class OrderViewController {
    private OrderView orderView;
    private DataBaseContext dataBaseContext;


    public OrderViewController() {
        dataBaseContext = DataBaseContext.getInstance();
        dataBaseContext.setLoadSaveStrategy("Tekst");
    }

    public void setOrderView(){
        this.orderView = orderView;
    }
    public void setLoadSaveStrategy(String loadSaveStrategy){
        dataBaseContext.setLoadSaveStrategy(loadSaveStrategy);

    }


}
