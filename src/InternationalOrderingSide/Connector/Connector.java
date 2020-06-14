/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternationalOrderingSide.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {

    Connection connection = null;

    public Connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return;
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://128.199.239.13:3306/LeDucThang", "root", "gn1C4IrvFiGesuwK");

        } catch (SQLException e) {
            System.out.println(e);
            return;
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            System.out.println("Executing query: " + query);
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean updateQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            System.out.println("Executing query: " + query);
            stmt.execute(query);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean closeConnection() {
        try {
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}

