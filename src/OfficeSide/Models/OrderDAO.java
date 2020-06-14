/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Models;

import OfficeSide.Connector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wind
 */
public class OrderDAO {

    Connector connector = new Connector();

//    public boolean createOrder(OrderDTO orderDTO) {
//        String values = "('"
//                + orderDTO.getDateCreated() + "',"
//                + orderDTO.getAmount() + ","
//                + orderDTO.getStatus() + ","
//                + orderDTO.getItem_id() + ",'"
//                + orderDTO.getName()
//                + "')";
//        String sql = "Insert into Order_Item (date_created,amount,status,item_id,name) values " + values + ";";
//        return connector.updateQuery(sql);
//    }
//
    public List<OrderDTO> loadAllOrders() throws SQLException {
        List<OrderDTO> orders = new ArrayList<>();
        String sql = "Select * from `Order`;";
        ResultSet rs = connector.executeQuery(sql);
        while (rs.next()) {
            orders.add(new OrderDTO(rs.getInt("id"), rs.getInt("status"), rs.getString("deliver_date")));
        }
        return orders;

    }

    public List<OrderDTO> loadAllWaitingOrders() throws SQLException {
        List<OrderDTO> orders = new ArrayList<>();
        String sql = "Select * from `Order` where status = 0;";
        ResultSet rs = connector.executeQuery(sql);
        while (rs.next()) {
            orders.add(new OrderDTO(rs.getInt("id"), rs.getInt("status"), rs.getString("deliver_date")));
        }
        return orders;

    }

    public List<OrderDTO> loadAllConfirmedOrders() throws SQLException {
        List<OrderDTO> orders = new ArrayList<>();
        String sql = "Select * from `Order` where status = 1;";
        ResultSet rs = connector.executeQuery(sql);
        while (rs.next()) {
            orders.add(new OrderDTO(rs.getInt("id"), rs.getInt("status"), rs.getString("deliver_date")));
        }
        return orders;

    }

    public boolean updateStatusOrderByOrderID(int orderId, int status) {
        String sql = "Update `Order` set status = " + status + " where id =" + orderId;
        return connector.updateQuery(sql);
    }

    public boolean createOrder(OrderDTO orderDTO) {
        String values = "("
                + orderDTO.getStatus() + ",'"
                + orderDTO.getDeliver_date()
                + "')";
        String sql = "Insert into `Order`(status,deliver_date) values " + values + ";";

        return connector.updateQuery(sql);
    }

    public boolean deleteOrder(int orderID) {
        String sql = "Delete from `Order` where id = " + orderID;
        return connector.updateQuery(sql);
    }
}
