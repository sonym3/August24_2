 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package august24_2.newPackage;
import net.sf.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import net.sf.json.JSONArray;
import java.util.logging.Logger;


/**
 *
 * @author 1895321
 */
public class Client {
    
    public void clientUpdate(Connection con, PreparedStatement stm, String nameclient, String notelephone, Double noclient) throws SQLException {
        String sql;
        
        sql="update Client set nameclient=?, notelephone=? where noclient=?";
        stm=con.prepareStatement(sql);
        stm.setString(1, nameclient);
        stm.setString(2, notelephone);
        stm.setDouble(3, noclient);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str = rs + " row(s) updated succefully";
        
        JSONObject mainObject = new JSONObject(); 
        mainObject.accumulate("Message", str);
        
        System.out.println(mainObject);
      //  stm.close();
      //  con.close();
    }

    public void clientInsert(Connection con,PreparedStatement stm, Double noclient, String nameclient, String notelephone ) throws SQLException {
        String sql;
    
        sql="insert into client values (?,?,?) ";
        stm=con.prepareStatement(sql);
        stm.setDouble(1,noclient);
        stm.setString(2, nameclient);
        stm.setString(3, notelephone);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str= rs +" row(s) inserted successfully";
        
        JSONObject mainObject=new JSONObject();
        
        mainObject.accumulate("Message", str );
        System.out.println(mainObject);
       // stm.close();
       // con.close();
        
    }
    
    
    public void clientDelete(Connection con, PreparedStatement stm, int noclient ) throws SQLException{
        
        String sql = "delete from client where noclient =?";
        
        stm=con.prepareStatement(sql);
        stm.setInt(1,noclient);
        int rs=stm.executeUpdate();
        //System.out.println(rs);
        String str = rs + " row(s) deleted successfully";
        JSONObject mainObject = new JSONObject();
        mainObject.accumulate("Message", str);
        System.out.println(mainObject);
     //   stm.close();
      //  con.close();
        
    }
    
    
      public void clientList(Connection con,Statement stmt ) throws SQLException{
        
        String sql = "Select * from Client" ;
        
        stmt=con.createStatement();
             ResultSet rs=stmt.executeQuery(sql);
             
             JSONArray jsonArray=new JSONArray();
             
             
        while(rs.next()){
            JSONObject jsonObject=new JSONObject();
            
            jsonObject.accumulate("noclieny", rs.getInt(1));
            jsonObject.accumulate("nameclient", rs.getString(2));
            jsonObject.accumulate("notelephone", rs.getString(3));
            jsonArray.add(jsonObject);
            jsonObject.clear();
            
            
          //  System.out.println(rs.getInt(1) + " - " + rs.getString(2)+ " - " + rs.getString(3));
        }
        System.out.println(jsonArray);
         //  stmt.close();
       // con.close();
        
    }
    public void clientSingle(Connection con, PreparedStatement stm,int noclient) throws SQLException  {
    
    String sql="Select * from Client where noclient=?";
    
    stm=con.prepareStatement(sql);
    stm.setInt(1, noclient);
   // stmt=con.createStatement();
    ResultSet rs=stm.executeQuery();
    JSONObject mainObject = new JSONObject();
    while(rs.next()){
      //  System.out.println(rs.getInt("noclient") + " " + rs.getString("nameclient") + " " + rs.getString("notelephone"));
        mainObject.accumulate("noclient", rs.getInt("noclient"));
        mainObject.accumulate("nameclient",rs.getString("nameclient"));
        mainObject.accumulate("notelephone", rs.getString("notelephone"));
    }
    
        System.out.println(mainObject);
    
    
   
       stm.close();
      // stmt.close();
        con.close();  
        
    }
          
}


