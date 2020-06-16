/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock.Model;

import Stock.Connector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wind
 */
public class StockItemDAO {

    Connector connector = new Connector();

    public List<StockItemDTO> getAllItemInStock() throws SQLException {
        List<StockItemDTO> stockItems = new ArrayList<>();
        String sql = "Select os.id,s.name as site,i.id as item_id,i.name as item,os.amount from Ordered_Site os,Site s,Item i WHERE os.site_id = s.id and os.item_id = i.id AND os.status =1 order by id asc;";
        ResultSet rs = connector.executeQuery(sql);
        while (rs.next()) {            
            stockItems.add(new StockItemDTO(rs.getInt("id"),rs.getString("site"),rs.getInt("item_id"),rs.getString("item"),rs.getInt("amount")));
        }
        return stockItems;
    }
}
