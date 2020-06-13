/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Controller;

import OfficeSide.Models.ItemDAO;
import OfficeSide.Models.ItemDTO;
import OfficeSide.Models.ItemOrderDAO;
import OfficeSide.Models.ItemOrderDTO;
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
    ItemOrderDAO itemOrderDAO = new ItemOrderDAO();

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

    public boolean createItemOrder(ItemOrderDTO itemOrderDTO) {
        return itemOrderDAO.createItemOrder(itemOrderDTO);
    }

    public List<OrderDTO> loadOrders() {
        try {
            List<OrderDTO> returnValue = orderDAO.loadAllOrders();
            return returnValue;

        } catch (Exception e) {
            return null;
        }
    }

    public List<ItemOrderDTO> getOrderDetail(int orderID) {
        try {
            return itemOrderDAO.getItemsOfOrderByOrderID(orderID);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteOrderItemByOrderID(int orderID) {
        try {
            return itemOrderDAO.deleteItemOrderByOrderID(orderID);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteOrder(int orderID) {
        try {
            return orderDAO.deleteOrder(orderID);
        } catch (Exception e) {
            return false;
        }
    }

}
