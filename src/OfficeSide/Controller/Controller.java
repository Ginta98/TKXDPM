/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Controller;

import OfficeSide.Models.ItemDAO;
import OfficeSide.Models.ItemDTO;
import OfficeSide.Models.OrderDAO;
import OfficeSide.Models.OrderDTO;
import java.awt.image.SampleModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wind
 */
public class Controller {

    private static Controller SINGLETON_CONTROLLER = null;

    private Controller() {

    }

    public static Controller getInstance() {
        if (SINGLETON_CONTROLLER == null) {
            synchronized (Controller.class) {
                SINGLETON_CONTROLLER = new Controller();
            }
        }
        return SINGLETON_CONTROLLER;

    }
    ItemDAO itemDAO = new ItemDAO();
    OrderDAO orderDAO = new OrderDAO();

    public List<ItemDTO> loadItems() {
        try {
            return itemDAO.loadAllItems();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean createOrder(OrderDTO orderDTO) {
        return orderDAO.createOrder(orderDTO);
    }

    public List<OrderDTO> loadOrders() {
        try {
            return orderDAO.loadAllOrders();
        } catch (Exception e) {
            return null;
        }
    }

}
