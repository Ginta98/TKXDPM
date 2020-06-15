/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Site.Models;

import OfficeSide.Models.ItemDTO;
import Site.Connector.Connector;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wind
 */
public class SiteDAO {

    Connector connector = new Connector();

    public String SiteLogin(String username, String password) throws SQLException {
        String sql = "Select * from Account where username = '" + username + "' and password = '" + password + "'";
        ResultSet rs = connector.executeQuery(sql);
        String data = "null";
        while (rs.next()) {
            data = rs.getString("type");
        }
        return data;
    }

    public List<ItemDTO> getSiteItem(int siteId) throws SQLException {
        String sql = "Select * from Item;";
        List<ItemDTO> items = new ArrayList<>();
        ResultSet rs = connector.executeQuery(sql);
        while (rs.next()) {
            items.add(new ItemDTO(rs.getInt("id"), rs.getInt("price"), rs.getInt("number"), rs.getString("name")));
        }
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setNumber(0);
        }
        String sql2 = "Select * from Site_Item where site_id =" + siteId + ";";
        List<SiteItemDTO> siteItems = new ArrayList<>();
        ResultSet rs2 = connector.executeQuery(sql2);
        while (rs2.next()) {

            siteItems.add(new SiteItemDTO(rs2.getInt("id"), rs2.getInt("site_id"), rs2.getInt("item_id"), rs2.getInt("amount")));
        }
        for (int i = 0; i < siteItems.size(); i++) {
            for (int j = 0; j < items.size(); j++) {
                if (items.get(j).getId() == siteItems.get(i).getItem_id()) {
                    items.get(j).setNumber(siteItems.get(i).getAmount());
                    break;
                }
            }
        }
        return items;

    }

    public boolean updateSiteItem(int siteID, int itemID, int amount) {
//          String sql = "Update `Order` set status = " + status + " where id =" + orderId;
        String sql = "Update `Site_Item` set amount = " + amount + " where site_id = " + siteID + " and item_id =" + itemID + ";";
        return connector.updateQuery(sql);
    }

    public boolean createNewSiteItem(int siteID, int itemID, int amount) {
//           String sql = "Insert into `Item`(name,price,number) values " + values + ";";
        String values = "(" + siteID + ", " + itemID + ", " + amount + ")";
        String sql = "Insert into `Site_Item`(site_id,item_id,amount) values " + values + ";";
        return connector.updateQuery(sql);
    }

    public boolean deleteSiteItem(int siteID, int itemID) {
//           String sql = "Insert into `Item`(name,price,number) values " + values + ";";
        String sql = "Delete from `Site_Item` where site_id = " + siteID + " and item_id = " + itemID;
        return connector.updateQuery(sql);
    }

    public int getIDSite(String type) throws SQLException {
        String sql = "Select * from `Account` where type = '" + type + "';";
        ResultSet rs = connector.executeQuery(sql);
        int siteId = -1;
        while (rs.next()) {
            siteId = rs.getInt("id");
        }
        return siteId;
    }

    public List<SiteItemDTO> getSiteWithDeliverTypeAndItemIDSortASC(int itemID, String deliverType) throws SQLException {
        List<SiteItemDTO> siteItems = new ArrayList<>();
        String sql = "Select si.site_id,si.amount from Site s, Site_Item si where s.id = si.site_id and si.item_id = " + itemID + " and s.delivery_type='" + deliverType + "' order by amount ASC;";
        ResultSet rs = connector.executeQuery(sql);
        while (rs.next()) {
            siteItems.add(new SiteItemDTO(rs.getInt("site_id"), rs.getInt("amount")));

        }
        return siteItems;
    }


}
