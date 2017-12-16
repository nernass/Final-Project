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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nermeen
 */
public class Search_for_lens {
    
    
     Data_Access aData_Access =
                    Data_Access.getDataAccess();
    private Statement aStatement;
    ResultSet rs ;
    
    public DefaultListModel search(float size) throws SQLException{
      Data_Access aData_Access =
                    Data_Access.getDataAccess();
        try {
            aStatement = aData_Access.getStatement();
        } catch (Exception ex) {
            Logger.getLogger(Delete_Lens.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            rs = aStatement.
             executeQuery("select * from lens where size='" + size +"'");
            
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
