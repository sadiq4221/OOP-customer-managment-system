
package project;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Complaint {
    JDBC con=new JDBC();
    Connection con_obj=con.establishConnection();
    
    Statement stmt=null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        String Complain;
        
       
             public boolean addComplain(String complain)
        {
            boolean b=false;
            String sql="insert into Table2(Complain) values ('"+complain+"')";
            try
            {
                stmt=con_obj.createStatement();
           
         int res = stmt.executeUpdate(sql);
         if(res>0)
         {
            
              b=true;
         }
         else
         {
b=false;
         }
           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
            return b;
        }
       
         public boolean deleteComplain(int id)
        {
            boolean b=false;
            String sql="delete from Table2 where ID =  '"+id+"'  ";
            try
            {
                stmt=con_obj.createStatement();
           
         int res = stmt.executeUpdate(sql);
         if(res>0)
         {
            
              b=true;
         }
         else
         {
b=false;
         }
           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
            return b;
        }
       
         
         
          public boolean fetchComplain(int id)
        {
            boolean b=false;
            String sql="search * from Table2 where ID =  '"+id+"'";
            try
            {
                pst=con_obj.prepareStatement(sql);
           
        rs = pst.executeQuery();
         
         while(rs.next()){
         Complain= rs.getString("Complain");

             b=true;
         }
         
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }
            return b;
        }
       
        public boolean updateSolution(int id ,String solution){
              boolean b=false;
                  String sql = "update Table2 set Solution = '"+solution+"'where ID='"+id+"'";
            try
            {
                stmt=con_obj.createStatement();
          
         int res = stmt.executeUpdate(sql);
            b=true;
    
           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
            return b;
    }

    boolean addComplain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
