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
public class Delete_Lens {
    
    
    Data_Access aData_Access =
                    Data_Access.getDataAccess();
    private Statement aStatement;
    ResultSet rs ;
    
    
    public void delete(float size) throws SQLException{
        
          Data_Access aData_Access =
                    Data_Access.getDataAccess();
        try {
            aStatement = aData_Access.getStatement();
        } catch (Exception ex) {
            Logger.getLogger(Delete_Lens.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            aStatement.execute("delete from lens " + "where size = " + size + "");
             JOptionPane.showMessageDialog(null, " Deleted Successfully");
    }
    
    
    
    
}
