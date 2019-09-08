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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 1895268
 */
public class DetailedOrder {
    
    public void DetailedOrderUpdate(Connection con, PreparedStatement stm, int noOrder, int noItem, int quantity) throws SQLException {
        String sql;
        
        sql="update DETAILORDER set quantity=? where noorder=? and noitem=?";
        stm=con.prepareStatement(sql);
        stm.setInt(1, noOrder);
        stm.setInt(2, noItem);
        stm.setInt(3, quantity);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str = rs + " row(s) updated succefully";
        
        JSONObject mainObject = new JSONObject(); 
        mainObject.accumulate("Message", str);
        
        System.out.println(mainObject);
      //  con.close();
      //  stm.close();
    }
    
    
     public void DetailedOrderInsert(Connection con,PreparedStatement stm, int noOrder, int noItem, int quantity ) throws SQLException {
        String sql;
        
        
        
        sql="insert into DETAILORDER values (?,?,?) ";
        stm=con.prepareStatement(sql);
        stm.setInt(1,noOrder);
        stm.setInt(2, noItem);
        stm.setInt(3, quantity);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str= rs +" row(s) inserted successfully";
        
        JSONObject mainObject=new JSONObject();
        
        mainObject.accumulate("Message", str );
        System.out.println(mainObject);
       // stm.close();
       // con.close();
        
    }
    
     
      public void DetailedOrderDelete(Connection con, PreparedStatement stm, int noOrder, int noItem ) throws SQLException{
        
        String sql = "delete from DETAILORDER where noorder =? and noitem=?";
        
        stm=con.prepareStatement(sql);
        stm.setInt(1,noOrder);
        stm.setInt(2,noItem);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str = rs + " row(s) deleted successfully";
        JSONObject mainObject = new JSONObject();
        mainObject.accumulate("Message", str);
        System.out.println(mainObject);
     //   stm.close();
      //  con.close();
        
    }
      
      public void DetailedOrderList(Connection con,Statement stmt ) throws SQLException{
        
        String sql = "Select * from DETAILORDER" ;
        
        stmt=con.createStatement();
             ResultSet rs=stmt.executeQuery(sql);
             
             JSONArray jsonArray=new JSONArray();
             
             
        while(rs.next()){
            JSONObject jsonObject=new JSONObject();
            
            jsonObject.accumulate("noOrder", rs.getInt(1));
            jsonObject.accumulate("noItem", rs.getString(2));
            jsonObject.accumulate("quantity", rs.getString(3));
            jsonArray.add(jsonObject);
            jsonObject.clear();
            
            
          //  System.out.println(rs.getInt(1) + " - " + rs.getString(2)+ " - " + rs.getString(3));
        }
        System.out.println(jsonArray);
         //  stmt.close();
       // con.close();
        
    }
      
      
      public void DetailedOrderSingle(Connection con, PreparedStatement stm,int noOrder, int noItem) throws SQLException  {
    
    String sql="Select * from DETAILORDER where noorder=? and noitem=?";
    
    stm=con.prepareStatement(sql);
    stm.setInt(1, noOrder);
    stm.setInt(2, noItem);
   // stmt=con.createStatement();
    ResultSet rs=stm.executeQuery();
    JSONObject mainObject = new JSONObject();
    while(rs.next()){
      //  System.out.println(rs.getInt("noclient") + " " + rs.getString("nameclient") + " " + rs.getString("notelephone"));
        mainObject.accumulate("noOrder", rs.getInt("noorder"));
        mainObject.accumulate("noItem",rs.getString("noitem"));
        mainObject.accumulate("quanitiy", rs.getString("quantity"));
    }
    
        System.out.println(mainObject);
    
    
   
    stm.close();
    con.close();
   
        
    }
    
    }
    

