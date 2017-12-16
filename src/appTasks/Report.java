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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nermeen
 */
public class Report {
    
    
     Data_Access aData_Access =
                    Data_Access.getDataAccess();
    private Statement aStatement;
  
    private ResultSet rs ;
   
     public float calculate_total() throws Exception{
       
       float total = 0 ;
         Data_Access aData_Access =
                    Data_Access.getDataAccess();
         
         aStatement = aData_Access.getStatement();
          rs = aStatement.executeQuery("select * from sales ");
          
            
          while(rs.next()){
              
              float a =   rs.getFloat("price");
              int b =   rs.getInt("numOfSales");
            total += a*b ; 
          }
         return total ;
     }
     
     
      public DefaultListModel  getReport() throws SQLException, Exception{
          
 
           Data_Access aData_Access =
                    Data_Access.getDataAccess();
         
           aStatement = aData_Access.getStatement();
           rs = aStatement.executeQuery("select * from sales ");
           
           
           DefaultListModel<String> aDefaultListModel = new DefaultListModel<String>();
               
          aDefaultListModel.addElement("Type --  Size -- Price -- Num Of Sales");
          aDefaultListModel.addElement("====================");
           
          while(rs.next()){
              String a =  rs.getString("type"); 
              float b =   rs.getFloat("size");
              float c =   rs.getFloat("price");
              int d =   rs.getInt("numOfSales");
               String row = a;
            row += " -- " + b;
            row += " -- " + c;
            row += " -- " + d;
            
            aDefaultListModel.addElement(row);
            
       
          } 
          return aDefaultListModel ;
    } 
     
   
}
