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

    public boolean createOrder(OrderDTO orderDTO) {
        String values = "('"
                + orderDTO.getDateCreated() + "',"
                + orderDTO.getAmount() + ","
                + orderDTO.getStatus() + ","
                + orderDTO.getItem_id() + ",'"
                + orderDTO.getName()
                + "')";
        String sql = "Insert into Order_Item (date_created,amount,status,item_id,name) values " + values + ";";
        return connector.updateQuery(sql);
    }

    public List<OrderDTO> loadAllOrders() throws SQLException {
        List<OrderDTO> items = new ArrayList<>();
        String sql = "Select * from Order_Item;";
        ResultSet rs = connector.executeQuery(sql);
        while (rs.next()) {
            items.add(new OrderDTO(rs.getInt("id"), rs.getInt("amount"), rs.getInt("status"), rs.getInt("item_id"), rs.getString("date_created"), rs.getString("name")));
        }
        return items;

    }
}
