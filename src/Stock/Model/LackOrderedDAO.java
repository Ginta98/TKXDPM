/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock.Model;

import Stock.Connector.Connector;

/**
 *
 * @author Wind
 */
public class LackOrderedDAO {

    Connector connector = new Connector();

    public boolean addLackOrdered(LackOrderedDTO lackOrderedDTO) {
        String values = "(" + lackOrderedDTO.getOrderedSiteId() + ", " + lackOrderedDTO.getAmount() + ")";
        String sql = "Insert into `Lack_Ordered` (ordered_site_id,amount) values " + values + ";";
        return connector.updateQuery(sql);
    }


}
