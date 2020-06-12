
import OfficeSide.Controller.Controller;
import OfficeSide.Models.ItemDAO;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wind
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date d = new Date();
        System.out.println(df.format(d));

    }
}
