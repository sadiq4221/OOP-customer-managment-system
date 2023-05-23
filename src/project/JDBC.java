
package project;


import java.sql.*;
import javax.swing.*;

public class JDBC {
   Connection con=null;
    
    public Connection establishConnection(){
                try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con=DriverManager.getConnection("jdbc:ucanaccess://G:\\Login.accdb");
          //  JOptionPane.showMessageDialog(null, "Connected");
           
        }
        catch(Exception ex)
                {
                     JOptionPane.showMessageDialog(null,ex);
                }
    return con;
}
} 

