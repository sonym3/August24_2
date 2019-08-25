/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package august24_2;
import august24_2.newPackage.*;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1895268
 */
public class August24_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Delivery d = new Delivery();
        DetaileDelivery dd = new DetaileDelivery();
          try{
          Connection con=null;
          PreparedStatement stm=null;
          Statement stmt = null;
          DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
          con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
           
           
           
           /*
           //DELIVERY CLASS
           String str = "2013-09-04 13:30:00";
           int noitem = 28;
           d.insertDelivery(con, stm, noitem, str);
           */
           int nodelivery = 101;
           d.deleteDelivery(con, stm, nodelivery);
           
           /*
           int no_delivery =104; 
           String datedelivery = "2013-09-04 13:30:00";
           d.updateDelivery(con, stm, no_delivery, datedelivery);
           
           
           
           //DETAILEDDELIVERY CLASS
           int no_delivery2 = 104;
           dd.deleteDetaileDelivery(con, stm, no_delivery2);
           
           int no_delivery3 = 101;
           int no_item2 = 95;
           dd.updateDetaileDelivery(con, stm, no_delivery3, no_item2);
     
           */
           
    } catch (SQLException ex) {
            Logger.getLogger(August24_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    }
    
