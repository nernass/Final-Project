/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTasks;

import dbConnection.Data_Access;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nermeen
 */
public class Lens_info {
    
    private String type ;
    private String color ;
    private float size ;
    private int quantity ;
     private float price ;

   
    
     Data_Access aData_Access =
                    Data_Access.getDataAccess();
    private Statement aStatement;
    private ResultSet rs ;
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
     public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
 
     public DefaultListModel<String>  getAllLense() throws SQLException, Exception{
          
       
           Data_Access aData_Access =
                    Data_Access.getDataAccess();
         
           aStatement = aData_Access.getStatement();
           rs = aStatement.executeQuery("select * from lens ");
           
           
           DefaultListModel<String> aDefaultListModel = new DefaultListModel<String>();
               
          aDefaultListModel.addElement("Type -- Color -- Size -- Quantity -- Price");
          aDefaultListModel.addElement("====================");
           
          while(rs.next()){
       
              String a =  rs.getString("type");
              String b =  rs.getString("color");
              float c =   rs.getFloat("size");
              int d =     rs.getInt("quantity");
              float e =   rs.getFloat("price");
              
               String row = a;
            row += " -- " + b;
            row += " -- " + c;
            row += " -- " + d;
            row += " -- " + e;
            aDefaultListModel.addElement(row);
            
       
          } 
          return aDefaultListModel ;
        
    } 
    

}
