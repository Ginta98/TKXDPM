/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternationalOrderingSide.Models;

import OfficeSide.Connector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wind
 */
public class OrderedSiteDAO {

    Connector connector = new Connector();

    public boolean addOrderedSite(OrderedSiteDTO orderedSiteDTO) {
        String value = "(" + orderedSiteDTO.getSiteId() + ", " + orderedSiteDTO.getItemId() + ", " + orderedSiteDTO.getAmount() + ", " + orderedSiteDTO.getStatus() + ");";
        String sql = "Insert into `Ordered_Site` (site_id,item_id,amount,status) values " + value;
        return connector.updateQuery(sql);
    }

    public List<OrderSiteConvertItemIdToItemNameDTO> getAllOrderedItemByStatusAndSiteID(int status, int siteId) throws SQLException {
        List<OrderSiteConvertItemIdToItemNameDTO> orderedItems = new ArrayList<>();
        String sql = "Select os.id,i.name,os.amount,os.status from `Ordered_Site` os, `Item` i WHERE os.item_id = i.id AND os.status =" + status + " and os.site_id =" + siteId + ";";
        ResultSet rs = connector.executeQuery(sql);
        while (rs.next()) {
            orderedItems.add(new OrderSiteConvertItemIdToItemNameDTO(rs.getInt("id"), rs.getString("name"), rs.getInt("amount"), rs.getInt("status")));
        }
        return orderedItems;
    }

    public boolean updateOrderedItemStatus(int orderedItemId, int status) {
        String sql = "Update `Ordered_Site` set status =" + status + " where id = " + orderedItemId;
        return connector.updateQuery(sql);
    }
}
