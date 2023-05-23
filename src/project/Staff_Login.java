
package project;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Staff_Login {
    JDBC con=new JDBC();
    Connection con_obj=con.establishConnection();
    
    Statement stmt=null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        String name,password;
        
        public boolean userLogin(String username,String password){
            String loginString="select * from Table1 where sname='"+username+"' and "
                    + "spass='"+password+"'   ";
             boolean b;
            try
            {            
                
            pst=con_obj.prepareStatement(loginString);
            rs=pst.executeQuery();
            if(rs.next())
            {
                //JOptionPane.showMessageDialog(null,"Succcessfully Logged IN");
                b= true;
            }
            else
            {
                // JOptionPane.showMessageDialog(null,"Cannot Log In");
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
        
             public boolean adduser(String uname,String pass)
        {
            boolean b=false;
            String sql="insert into Table1(sname,spass) values ('"+uname+"','"+pass+"')";
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
       
         public boolean deleteuser(int id)
        {
            boolean b=false;
            String sql="delete from Table1 where ID =  '"+id+"'  ";
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
       
         
         
            public boolean fetchUser(int id)
        {
            boolean b=false;
            String sql="search * from Table1 where ID =  '"+id+"'  ";
            try
            {
                pst=con_obj.prepareStatement(sql);
           
        rs = pst.executeQuery();
         
         while(rs.next()){
           name= rs.getString("sname");
             password=rs.getString("spass");
             b=true;
         }
         
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
            return b;
        }
       
        public boolean updateRecord(int id,String uName,String uPass){
              boolean b=false;
                  String sql = "update Table1 set sname='"+uName+"' , spass='"+uPass+"' where ID='"+id+"'";
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

    boolean deleteuser(String name1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}