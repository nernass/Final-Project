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
public  abstract class Bill {
    
     Data_Access aData_Access =
                    Data_Access.getDataAccess();
    private Statement aStatement;
  
    private ResultSet rs ;
   
     public abstract void calculate_cost(String type, float size, float price) throws Exception;
     
     
      public DefaultListModel  getBill(float size) throws SQLException, Exception{
          
 
           Data_Access aData_Access =
                    Data_Access.getDataAccess();
         
           aStatement = aData_Access.getStatement();
           rs = aStatement.executeQuery("select * from bill where size='" + size +"'");
           
           
           DefaultListModel<String> aDefaultListModel = new DefaultListModel<String>();
               
          aDefaultListModel.addElement("Type --  Size -- Price -- Cost");
          aDefaultListModel.addElement("====================");
           
          while(rs.next()){
              String a =  rs.getString("type"); 
              float b =   rs.getFloat("size");
              float c =   rs.getFloat("price");
              float d =   rs.getFloat("cost");
               String row = a;
            row += " -- " + b;
            row += " -- " + c;
            row += " -- " + d;
            
            aDefaultListModel.addElement(row);
            
       
          } 
          return aDefaultListModel ;
    } 
     
   
     
     
}
