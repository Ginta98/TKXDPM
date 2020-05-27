
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

    public static void main(String[] argv) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return;
        }
        System.out.println("Connected");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://128.199.239.13:3306/LeDucThang", "root", "gn1C4IrvFiGesuwK");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Item");
            while (rs.next()) {

                System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", price: " + rs.getInt("price") + ", number: Z" + rs.getInt("number"));
            }
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
            return;
        }
    }
}
