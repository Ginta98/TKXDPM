/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock.Controller;

import InternationalOrderingSide.Models.OrderedSiteDAO;
import OfficeSide.Models.ItemDAO;
import Stock.Model.LackOrderedDAO;
import Stock.Model.LackOrderedDTO;
import Stock.Model.StockItemDAO;
import Stock.Model.StockItemDTO;
import java.util.List;

/**
 *
 * @author Wind
 */
public class Controller {

    private Controller() {
    }
    OrderedSiteDAO orderedSiteDAO = new OrderedSiteDAO();
    LackOrderedDAO lackOrderedDAO = new LackOrderedDAO();
    StockItemDAO stockItemDAO = new StockItemDAO();
    ItemDAO itemDAO = new ItemDAO();

    public static Controller getInstance() {
        return ControllerHolder.INSTANCE;
    }

    private static class ControllerHolder {

        private static final Controller INSTANCE = new Controller();
    }

    public boolean addLackOrdered(LackOrderedDTO lackOrderedDTO) {
        try {
            return lackOrderedDAO.addLackOrdered(lackOrderedDTO);
        } catch (Exception e) {
            return false;
        }
    }

    public List<StockItemDTO> getAllStockItem() {
        try {
            return stockItemDAO.getAllItemInStock();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean doneCommitStock(int orderedId) {
        try {
            return orderedSiteDAO.updateOrderedItemStatus(orderedId, 2);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addItemAmount(String itemName, int amount) {
        try {
            return itemDAO.addItemAmountWithItemName(itemName, amount);
        } catch (Exception e) {
            return false;
        }
    }

    public int getItemOriginNumber(String itemName) {
        try {
            return itemDAO.getAmountOfItemWithItemName(itemName);
        } catch (Exception e) {
            return -2;
        }
    }
   
}
