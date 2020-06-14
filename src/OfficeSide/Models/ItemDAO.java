/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Models;

import OfficeSide.Connector.Connector;
import java.beans.Transient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class ItemDAO {

    Connector connector = new Connector();

    public ArrayList<ItemDTO> loadAllItems() throws SQLException {
        ArrayList<ItemDTO> items = new ArrayList<>();
        ResultSet rs = connector.executeQuery("Select * from Item;");
        while (rs.next()) {
            items.add(new ItemDTO(rs.getInt("id"), rs.getInt("price"), rs.getInt("number"), rs.getString("name")));
        }
        return items;
    }

    public ArrayList<ItemDTO> loadAllItemsByOrderId(int orderID) throws SQLException {
        ArrayList<ItemDTO> items = new ArrayList<>();
        ResultSet rs = connector.executeQuery("Select i.id,i.name,i.price,i.number from `Item` i, `Order_Item` oi WHERE i.id = oi.item_id AND oi.order_id =" + orderID + ";");
        while (rs.next()) {
            items.add(new ItemDTO(rs.getInt("id"), rs.getInt("price"), rs.getInt("number"), rs.getString("name")));
        }
        return items;
    }

    public boolean deleteItem(int itemId) {
        try {

            String deleteItemQuery = "Delete from `Item` where id = " + itemId + ";";
            return connector.updateQuery(deleteItemQuery);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean createItem(ItemDTO itemDTO) {
        String values = "('"
                + itemDTO.getName() + "',"
                + itemDTO.getPrice() + ","
                + itemDTO.getNumber()
                + ")";
        String sql = "Insert into `Item`(name,price,number) values " + values + ";";
        return connector.updateQuery(sql);
    }

    public boolean updateItem(ItemDTO itemDTO) {
        String sql = "Update `Item` set name = '" + itemDTO.getName() + "', price = " + itemDTO.getPrice() + " where id = " + itemDTO.getId() + ";";
        return connector.updateQuery(sql);
    }

}
