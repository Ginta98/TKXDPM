/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Site.Models;

import Site.Connector.Connector;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
