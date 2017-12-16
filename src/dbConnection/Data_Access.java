/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nermeen
 */
public class Data_Access {
    
    private static Data_Access aData_Access ;
    private Connection aConnection;
    private  Statement aStatement;
   
    
    private Data_Access(){}
    
   
    public static Data_Access getDataAccess(){
        
         if(aData_Access == null){
            aData_Access = new Data_Access();
            
        }
        return aData_Access ;
        
    }
    
   public Statement getStatement()
            throws Exception, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        aConnection = 
                DriverManager.getConnection("jdbc:mysql://localhost/lensesmanagementsystem", "root", "");
        aStatement = aConnection.createStatement();
        return aStatement;
        
    }
    
    
}
