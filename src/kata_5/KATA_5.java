package kata_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class KATA_5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        //Class.forName("org.sqlite.JDBC");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conec = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.32:1521:orcl","system","orcl"); 
        
        //Connection conec = DriverManager.getConnection("jdbc:sqlite:DDBBKATA");
        Statement state = conec.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM MAIL");
        
        while(rs.next()) {
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString("MAIL"));
        }
        
        String nameFile = "C:\\Users\\usuario\\Desktop\\mails.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
        String mail;
        while((mail=reader.readLine()) != null) {
            String query = "INSERT INTO MAIL (MAIL) VALUES ('" + mail + "')";
            state.executeUpdate(query);
        }
        rs.close();
        state.close();
        conec.close();
    }
}
