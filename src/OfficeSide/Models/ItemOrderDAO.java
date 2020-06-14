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
public class ItemOrderDAO {

    Connector connector = new Connector();

    public boolean createItemOrder(ItemOrderDTO itemOrderDTO) {
        String values = "("
                + itemOrderDTO.getItemID() + ","
                + itemOrderDTO.getOrderID() + ","
                + itemOrderDTO.getAmount()
                + ")";
        String sql = "Insert into `Order_Item`(item_id,order_id,amount) values " + values + ";";

        return connector.updateQuery(sql);
    }

    public List<ItemOrderDTO> getItemsOfOrderByOrderID(int orderID) throws SQLException {
        List<ItemOrderDTO> orderDetail = new ArrayList<>();
        String sql = "Select * from `Order_Item` where  order_id = " + orderID + ";";
        ResultSet rs = connector.executeQuery(sql);

        while (rs.next()) {
            orderDetail.add(new ItemOrderDTO(rs.getInt("id"), rs.getInt("item_id"), rs.getInt("order_id"), rs.getInt("amount")));
        }
        System.out.println("DAO:" + orderDetail.size());
        return orderDetail;
    }

    public boolean deleteItemOrderByOrderID(int orderID) {
        String sql = "Delete from `Order_Item` where order_id =" + orderID;
        return connector.updateQuery(sql);
    }

    public boolean deleteItemOrderByItemID(int itemID) {
        String sql = "Delete from `Order_Item` where item_id =" + itemID;
        return connector.updateQuery(sql);
    }

}
