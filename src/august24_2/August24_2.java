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
          Client c = new Client();
           
           
           /*
           //DELIVERY CLASS
           String str = "2013-09-04 13:30:00";
           int noitem = 27;
           d.insertDelivery(con, stm, noitem, str);
         
          int no_delivery =27; 
           String datedelivery = "2001-01-01 01:01:01";
           d.updateDelivery(con, stm, no_delivery, datedelivery);
           
           
           int nodelivery = 27;
           d.deleteDelivery(con, stm, nodelivery);
         
           */
           
          /* 
           //DETAILEDDELIVERY CLASS
           int no_delivery2 = 104;
           dd.deleteDetaileDelivery(con, stm, no_delivery2);
           
           int no_delivery3 = 101;
           int no_item2 = 95;
           dd.updateDetaileDelivery(con, stm, no_delivery3, no_item2);
     
           */
          
          //CLIENT CLASS
          
            Double noclient2=97.0;
            String nameclient2="Asma";
            String notelephone2= "12345678";
            
            c.clientInsert(con, stm, noclient2, nameclient2, notelephone2);
             
            String nameclient =  "ASMAROKADIYA";
            String notelephone ="789654123";
            Double noclient=97.0;
            
            c.clientUpdate(con, stm, nameclient, notelephone, noclient);
            
       
            int noclient3 = 97;
            c.clientDelete(con, stm, noclient3);
             
             c.clientList(con, stmt);   
             
             int noclient4=60;
             c.clientSingle(con, stm, noclient4);
       
           
    } catch (SQLException ex) {
            Logger.getLogger(August24_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    }
    
