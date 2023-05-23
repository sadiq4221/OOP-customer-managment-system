

  package project;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Admin_Login {
    JDBC con=new JDBC();
    Connection con_obj=con.establishConnection();
    
    Statement stmt=null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        String name,password;
        
        public boolean adminLogin(String username,String password){
            String loginString="select * from Table3 where name='"+username+"' and "
                    + "pass='"+password+"'   ";
             boolean b;
            try
            {            
                
            pst=con_obj.prepareStatement(loginString);
            rs=pst.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Succcessfully Logged IN");
                b= true;
                        
                        
            }
     
            else
            {
                JOptionPane.showMessageDialog(null,"Cannot Log In");
                 b= false;
            }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
                b=false;
            }
            return b;
        }

}

