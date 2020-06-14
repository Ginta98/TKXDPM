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

    public List<ItemDTO> loadItemsByOrderId(int orderId) {
        try {
            return itemDAO.loadAllItemsByOrderId(orderId);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteItem(int itemId) {
        try {
            return itemDAO.deleteItem(itemId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateItem(ItemDTO itemDTO) {
        try {
            return itemDAO.updateItem(itemDTO);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean createItem(ItemDTO itemDTO) {
        try {
            return itemDAO.createItem(itemDTO);
        } catch (Exception e) {
            return false;
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

    public List<OrderDTO> loadWaitingOrders() {
        try {
            List<OrderDTO> returnValue = orderDAO.loadAllWaitingOrders();
            return returnValue;

        } catch (Exception e) {
            return null;
        }
    }

    public List<OrderDTO> loadConfirmedOrders() {
        try {
            List<OrderDTO> returnValue = orderDAO.loadAllConfirmedOrders();
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

    public boolean deleteOrderItemByItemID(int itemID) {
        try {
            return itemOrderDAO.deleteItemOrderByItemID(itemID);
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

    public boolean updateOrderByOrderId(int orderID, int status) {
        try {
            return orderDAO.updateStatusOrderByOrderID(orderID, status);
        } catch (Exception e) {
            return false;
        }
    }

}
