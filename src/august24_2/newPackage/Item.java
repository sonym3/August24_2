/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package august24_2.newPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 1895268
 */
public class Item {

    public void itemUpdate(Connection con, PreparedStatement stm, Double priceItem, int noItem) throws SQLException {
        String sql;
        sql="update Item set unitprice=? where noItem=?";
        stm=con.prepareStatement(sql);
        stm.setDouble(1, priceItem);
        stm.setInt(2, noItem);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str = rs + " row(s) updated succefully";
        
        JSONObject mainObject = new JSONObject(); 
        mainObject.accumulate("Message", str);
        
        System.out.println(mainObject);
        }
    
    
    public void itemInsert(Connection con,PreparedStatement stm, int noItem, String description, Double price, int quantity ) throws SQLException {
        String sql;
    
        sql="insert into Item values (?,?,?,?) ";
        stm=con.prepareStatement(sql);
        stm.setInt(1,noItem);
        stm.setString(2, description);
        stm.setDouble(3, price);
        stm.setInt(4, quantity);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str= rs +" row(s) inserted successfully";
        
        JSONObject mainObject=new JSONObject();
        
        mainObject.accumulate("Message", str );
        System.out.println(mainObject);
       // stm.close();
       // con.close();
        
    }
    
    
    public void itemDelete(Connection con, PreparedStatement stm, int noItem ) throws SQLException{
        
        String sql = "delete from item where noItem =?";
        
        stm=con.prepareStatement(sql);
        stm.setInt(1,noItem);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str = rs + " row(s) deleted successfully";
        JSONObject mainObject = new JSONObject();
        mainObject.accumulate("Message", str);
        System.out.println(mainObject);
     //   stm.close();
      //  con.close();
        
    }
    
    public void itemList(Connection con,Statement stmt ) throws SQLException{
        
        String sql = "Select * from Item" ;
        
        stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
             
        JSONArray jsonArray=new JSONArray();
             
             
        while(rs.next()){
            JSONObject jsonObject=new JSONObject();
            
            jsonObject.accumulate("noItem", rs.getInt(1));
            jsonObject.accumulate("description", rs.getString(2));
            jsonObject.accumulate("price", rs.getString(3));
            jsonObject.accumulate("quantity", rs.getString(4));
            jsonArray.add(jsonObject);
            jsonObject.clear();
            
            
          //  System.out.println(rs.getInt(1) + " - " + rs.getString(2)+ " - " + rs.getString(3));
        }
        System.out.println(jsonArray);
   
        
    }
    
    public void itemSingle(Connection con, PreparedStatement stm,int noitem) throws SQLException  {
    
    String sql="Select * from item where noitem=?";
    
    stm=con.prepareStatement(sql);
    stm.setInt(1, noitem);
   // stmt=con.createStatement();
    ResultSet rs=stm.executeQuery();
    JSONObject mainObject = new JSONObject();
    while(rs.next()){
      //  System.out.println(rs.getInt("noclient") + " " + rs.getString("nameclient") + " " + rs.getString("notelephone"));
        mainObject.accumulate("noItem", rs.getInt("noItem"));
        mainObject.accumulate("description",rs.getString("description"));
        mainObject.accumulate("price", rs.getString("unitprice"));
        mainObject.accumulate("quantity", rs.getString("stockquantity"));    
    }
    
        System.out.println(mainObject);
    

       
        
    }
          
}
