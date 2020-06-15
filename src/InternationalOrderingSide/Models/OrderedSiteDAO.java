/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternationalOrderingSide.Models;

import OfficeSide.Connector.Connector;

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
}
