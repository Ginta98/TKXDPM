/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Controller;

import OfficeSide.Models.ItemDAO;
import OfficeSide.Models.ItemDTO;
import OfficeSide.Views.View;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class Controller {

    ItemDAO model;
    View view; 

    public Controller(ItemDAO model, View view) {
        this.model = model;
        this.view = view;
    }

    public Controller() {
    }

    public ArrayList<ItemDTO> getItems() throws SQLException {
        return model.loadAllItems();
    }

    public void updateViewData(ArrayList<ItemDTO> data) {
        view.consoleAllItem(data);
    }
  
}
