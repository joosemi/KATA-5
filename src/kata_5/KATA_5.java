package kata_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA_5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conec = DriverManager.getConnection("jdbc:sqlite:DDBBKATA");
        Statement state = conec.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM PEOPLE");
        
        while(rs.next()) {
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString("NAME"));
        }
    }
}
