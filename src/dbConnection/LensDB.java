/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import appTasks.Lens_info;
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
public class LensDB {
    
    
     private Statement aStatement;
     ResultSet rs ;
     

      public void steInfo(Lens_info aLens_info){
         Data_Access aData_Access =
                    Data_Access.getDataAccess();
         
        try {
            aStatement = aData_Access.getStatement();
            
            aStatement.execute("insert into lens(type,color,size,quantity,price) values ('" + aLens_info.getType()+ "','"  + aLens_info.getColor() + "','" +aLens_info.getSize() + "','"+ aLens_info.getQuantity() + "','"+ aLens_info.getPrice() + "')");
             JOptionPane.showMessageDialog(null, "Added Successfully ");
        } catch (Exception ex) {
            Logger.getLogger(Lens_info.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      
      
        public List<Lens_info>  getAllLense() throws SQLException, Exception{
          
           List<Lens_info> Lenses = new ArrayList<>();
           Data_Access aData_Access =
                    Data_Access.getDataAccess();
         
           aStatement = aData_Access.getStatement();
           rs = aStatement.executeQuery("select * from lens ");
     
           
          while(rs.next()){
              
              Lens_info aLens_info = new Lens_info();
              aLens_info.setType(rs.getString("type"));
              aLens_info.setColor( rs.getString("color"));
              aLens_info.setSize( rs.getFloat("size"));
              aLens_info.setQuantity(rs.getInt("quantity"));
              aLens_info.setPrice( rs.getFloat("price"));
              Lenses.add(aLens_info);
                      
       
          } 
         
          return Lenses ;
    } 
 
    
 
    
}
