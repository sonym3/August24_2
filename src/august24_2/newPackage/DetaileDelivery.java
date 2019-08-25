/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package august24_2.newPackage;

import august24_2.August24_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1895268
 */
public class DetaileDelivery {
    
    
    public void deleteDetaileDelivery(Connection con,PreparedStatement stm, int nodelivery) throws SQLException{

       String  sql="delete from detailedelivery where nodelivery=?";
        stm=con.prepareStatement(sql);
        stm.setInt(1,nodelivery);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        stm.close();
        con.close();

        
    }
    
    
    
    
    public void insertDetaileDelivery(Connection con,PreparedStatement stm, int nodelivery, int noorder, int noitem, int quantitydelivery ) throws SQLException{
    
      
        String sql= "insert into detailedelivery values(?,?,?,?)";
        stm=con.prepareStatement(sql);
        stm.setInt(1,nodelivery);
        stm.setInt(2,noorder);
        stm.setInt(3,noitem);
        stm.setInt(4,quantitydelivery);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        
        stm.close();
        con.close();
  
}
    
    
    
    public void updateDetaileDelivery(Connection con,PreparedStatement stm, int nodelivery, int  noitem ) throws SQLException{

        
        String sql="update detailedelivery set nodelivery=? where noitem=?";
        stm= con.prepareStatement(sql);
        stm.setInt(1,nodelivery);
        stm.setInt(2,noitem);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        stm.close();
        con.close();
        
        
    }
    
    
    public void listDetaileDelivery(Connection con,Statement stmt, int noitem, String str ) throws SQLException{
       
        String sql ="select * from DETAILDELIVERY";
        stmt = con.createStatement();
     
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getInt(1) + " - " + rs.getString(2));
        }
    
}
    
    
    public void singleDetaileDelivery(Connection con,PreparedStatement stm, int noitem, String str ) throws SQLException{
 
    
    
    
}
}
