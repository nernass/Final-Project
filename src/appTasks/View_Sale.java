/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTasks;

import dbConnection.Data_Access;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nermeen
 */
public class View_Sale {
    
    
    Data_Access aData_Access =
                    Data_Access.getDataAccess();
    private Statement aStatement;
    ResultSet rs ;
  
    
    public void addMesurment(float m) {
         int numOfSales = 1 ;
        Data_Access aData_Access =
                    Data_Access.getDataAccess();
        try {
            aStatement = aData_Access.getStatement();
             rs = aStatement.
             executeQuery("select * from lens where size='" + m +"'");
            
         
             while(rs.next()) {
             String a = rs.getString("type");
             String b = rs.getString("color");
             float c = rs.getFloat("size");
             int d = rs.getInt("quantity");
             float e = rs.getFloat("price");
             int newD = --d ;
           
             
                 if (rs.getInt("quantity")<= 10) {
            JOptionPane.showMessageDialog(null, "Num of lenses is  "+rs.getInt("quantity"));
                }
               
                 
                  String sql = "update lens set quantity='" + newD + "' where size = '" + m+"'";
                  aStatement.executeUpdate(sql);
                 
                 
                 rs = aStatement.
             executeQuery("select * from sales where size='" + m +"'");
                 
              if(rs.next())  {
                     
               int inc  = numOfSales + 1;  
                
                   sql = "update sales set numOfSales='" + inc + "' where size = '" + m+"'";
                  aStatement.executeUpdate(sql);
                  JOptionPane.showMessageDialog(null, "Done Successfully ");
              }else{
                         
             aStatement.execute("insert into sales(type,color,size,quantity,price,numOfSales) values ('" + a+ "','"  + b + "','" +c + "','"+ newD + "','" + e + "','" + numOfSales + "')");
             JOptionPane.showMessageDialog(null, "Done Successfully ");
              }
                  
          
              
           
              
             
             }  
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }  
             
        
    }
    
 
    
}
