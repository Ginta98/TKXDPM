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

 


//    public void createItem(ItemDTO item) {
//        ResultSet rs = connector.executeQuery("INSERT INTO `Item` (`id`, `name`, `price`, `number`) VALUES ('5', 'Laptop', '1200', '200');");
//    }

}
