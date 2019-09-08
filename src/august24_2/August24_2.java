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
        
        
          try{
          Connection con=null;
          PreparedStatement stm=null;
          Statement stmt = null;
          DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
          con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
          Client c = new Client();
          DetailedOrder deO = new DetailedOrder();
           System.out.println("::::::::::::::::CLIENT CLASS:::::::::::::::::::");
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
       
           /// ITEM CLASS
           
              System.out.println("::::::::::::::::ITEM CLASSS:::::::::::::::::::");
           Item i = new Item();
           int noItem =1110;
           String description="T shirt";
           Double price=67.6;
           int quanity=10;
           i.itemInsert(con, stm, noItem, description, price, quanity);
           
           
           Double price2 =12.3;
           int noItem2=1110;
           i.itemUpdate(con, stm, price2, noItem2);
           
           
           
          int noItem3=1110; 
          i.itemDelete(con, stm, noItem3);
          
          i.itemList(con, stmt);
          
          int noItem4=10;
          i.itemSingle(con, stm, noItem4);
          
      // DETAILED ORDER
         System.out.println("::::::::::::::::DETAILED ORDER:::::::::::::::::::");
      int noItem9=10;
      int noOrder9=1;
     // deO.DetailedOrderInsert(con, stm, noOrder9, noItem9, quantity9);
      
      int quantity8=34;
      
      
      deO.DetailedOrderUpdate(con, stm, noOrder9, noItem9, quantity8);
      int x=4,y=50;
      
      deO.DetailedOrderDelete(con, stm, x, y);
          
      
      deO.DetailedOrderList(con, stmt);
      
      
      int noOrder7=1;
      int noItem7=10;
      deO.DetailedOrderSingle(con, stm, noOrder7, noItem7);
          
      
      
      
    } catch (SQLException ex) {
            Logger.getLogger(August24_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    }
    
