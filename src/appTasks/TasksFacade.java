/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTasks;

import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author nermeen
 */
public class TasksFacade {
    
    private static BillFactory aBillFactory ;
   // private static Bill aBill;
    private static Delete_Lens aDelete_Lens ;
    private static Lens_info aLens_info ;
    private static Report aReport ;
    private  static Search_for_lens aSearch_for_lens ;
   // private static Show_Lens_Table aShow_Lens_Table ;
    private static Update_Inventory aUpdate_Inventory ;
    private static View_Sale aView_Sale ;
    
    
   private static TasksFacade instance ;
   
   private TasksFacade(){
      
       aBillFactory = new BillFactory();
     //  aBill = new Bill();
       aDelete_Lens = new Delete_Lens();
       aLens_info = new Lens_info();
       aReport = new Report();
       aSearch_for_lens = new Search_for_lens();
       aUpdate_Inventory = new Update_Inventory();
       aView_Sale = new View_Sale();
               
   }
   
  public static TasksFacade getInstance(){
      if (instance == null) {
          instance = new TasksFacade();
      }
      return instance;
  }
  
  
   public Bill getBillCustomer(String CustomerType){
       return aBillFactory.getBillCustomer(CustomerType);
               
   }
  

  public void delete(float size) throws SQLException{
      aDelete_Lens.delete(size);
  }  
  
    
    public float calculate_total() throws Exception{
      return aReport.calculate_total();
        
    }
    
   public DefaultListModel  getReport() throws SQLException, Exception{
       return aReport.getReport();
   }  
   
   
   public DefaultListModel search(float size) throws SQLException{
       return aSearch_for_lens.search(size);
   } 
 
  
   public  void save_update(String type ,String color , float size , int  quantity , float  price){
       aUpdate_Inventory.save_update(type, color, size, quantity, price);
   }
   
   
    public void addMesurment(float m) {
        aView_Sale.addMesurment(m);
    }
    
    
  /* public DefaultListModel  getBill(float size) throws SQLException, Exception{
    return aBill.getBill(size);
   }*/
   
   public DefaultListModel<String>   getAllLense() throws SQLException, Exception{
      return aLens_info.getAllLense() ;
  }  
   
   
}
