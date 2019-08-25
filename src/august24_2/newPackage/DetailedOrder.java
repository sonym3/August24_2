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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1895268
 */
public class DetailedOrder {
    public void deleteDetailedOrder(){
        
        try{
          Connection con=null;
          PreparedStatement stm=null;
            
           String sql;
            
           DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
           con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
              
        
        
        sql="delete from detailedelivery where nodelivery=?";
        stm=con.prepareStatement(sql);
        stm.setInt(1,104);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        stm.close();
        con.close();
        
           
           
            } catch (SQLException ex) {
            Logger.getLogger(August24_2.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    
    
    
    
    public void insertDetailedOrder(){
    try{
          Connection con=null;
          PreparedStatement stm=null;
            
           String sql;
            
           DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
           con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
             
      
        sql= "insert into detailedelivery values(?,?,?,?)";
       
       
        stm=con.prepareStatement(sql);
         
        stm.setInt(1,123);
        stm.setInt(2,43);
        stm.setInt(3,32);
        stm.setInt(4,65);
        
        int rs=stm.executeUpdate();
        System.out.println(rs);
        
        stm.close();
        con.close();
           
           
           
              
           
        } catch (SQLException ex) {
            Logger.getLogger(August24_2.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    
    public void updateDetailedOrder(){
        
        try{
          Connection con=null;
          PreparedStatement stm=null;
            
           String sql;
            
           DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
           con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
             
        

        sql="update detailedelivery set nodelivery=? where noitem=?";
        stm= con.prepareStatement(sql);
        stm.setInt(1,045);
        stm.setInt(2,70);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        stm.close();
        con.close();
        
        
        
         } catch (SQLException ex) {
            Logger.getLogger(August24_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void listDetailedOrder(){
         try{
          Connection con=null;
          PreparedStatement stm=null;
            
           String sql;
            
           DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
           con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
             
           
           
           
    } catch (SQLException ex) {
            Logger.getLogger(August24_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
    
    
    public void singleDetailedOrder(){
         try{
          Connection con=null;
          PreparedStatement stm=null;
            
           String sql;
            
           DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
           con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
             
           
           
           
           
           
           
    } catch (SQLException ex) {
            Logger.getLogger(August24_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
