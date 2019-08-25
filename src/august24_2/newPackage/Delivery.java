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
import net.sf.json.JSONObject;

/**
 *
 * @author 1895268
 */
public class Delivery {
    
    
    
    public void insertDelivery(Connection con,PreparedStatement stm, int noitem, String str ) throws SQLException{

      
        String sql= "insert into delivery values(?,?)";
        stm=con.prepareStatement(sql); 
        stm.setInt(1,noitem);
        stm.setTimestamp(2, java.sql.Timestamp.valueOf(str)); 
        int rs=stm.executeUpdate();
       // System.out.println(rs + " inserted ");
        String strin= rs + " row(s) inserted";
        JSONObject mainObject= new JSONObject();
        mainObject.accumulate("message", strin);
        System.out.println(mainObject);
      
}
    
    
    public void deleteDelivery(Connection con,PreparedStatement stm, int nodelivery) throws SQLException{

        String sql="delete from delivery where nodelivery=?";
        stm=con.prepareStatement(sql);
        stm.setInt(1,nodelivery);
        int rs=stm.executeUpdate();
        
        String str = rs + " row(s) updated successfully";
        JSONObject mainnObject  = new JSONObject();
        mainnObject.accumulate("message", str);
        System.out.println(mainnObject);
        //System.out.println(rs + " deleted ");
        

    }
    
    
    
    
    public void updateDelivery(Connection con,PreparedStatement stm, int nodelivery, String datedelivery) throws SQLException{
        

        String sql="update delivery set datedelivery= to_date(?,'DD_MM_YYYY') where nodelivery=?";
        stm= con.prepareStatement(sql);
        stm.setInt(2, nodelivery);
        stm.setString(1, datedelivery);
        int rs=stm.executeUpdate();
     //   System.out.println(rs+ " updated");
        String str= rs + " row(s) updated";
        JSONObject mainObject = new JSONObject();
        mainObject.accumulate("message", str);
        System.out.println(mainObject);
        /* String str = rs + " row(s) updated succefully";
        
        JSONObject mainObject = new JSONObject(); 
        mainObject.accumulate("Message", str);
        
        System.out.println(mainObject);*/
      
        

       
    }
    
    
    public void listDelivery(){
        
    
    
}
    
    
    public void singleDelivery(){
         
    }
}
