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
import javax.swing.JOptionPane;

/**
 *
 * @author nermeen
 */
public class Update_Inventory {
    
      
    Data_Access aData_Access =
                    Data_Access.getDataAccess();
    private Statement aStatement;
    ResultSet rs ;
    
  
    
    
    public  void save_update(String type ,String color , float size , int  quantity , float  price){
        
        Data_Access aData_Access =
                    Data_Access.getDataAccess();
        try {
            aStatement = aData_Access.getStatement();
        } catch (Exception ex) {
            Logger.getLogger(Update_Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
        try {
            
             String sql = "update lens set type= '"+type+"', color= '"+color+"' , size = "+size+" , quantity = "+quantity +" , price = "+price+" where size ="+size+""; 
            aStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Updated Successfully ");
        } catch (SQLException ex) {
            Logger.getLogger(Update_Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        
    }
    
}
