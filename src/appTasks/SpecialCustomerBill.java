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
public class SpecialCustomerBill extends Bill{
    
    Data_Access aData_Access =
                    Data_Access.getDataAccess();
    private Statement aStatement;
  
    private ResultSet rs ;
    
    
    @Override
     public void calculate_cost(String type, float size, float price) throws Exception{
       
         float cost = (float) (price + price*20/100) ;
         
         Data_Access aData_Access =
                    Data_Access.getDataAccess();
         
         aStatement = aData_Access.getStatement();
         
         aStatement.execute("insert into bill(type,size,price,cost) values ('" + type+ "','"  + size + "','" +price + "','"+ cost + "')");
             JOptionPane.showMessageDialog(null, "Done Successfully ");
         
     }
    
}
