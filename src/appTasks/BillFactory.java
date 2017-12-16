/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTasks;

/**
 *
 * @author nermeen
 */
public class BillFactory {
    
    public Bill getBillCustomer(String CustomerType){
        if (CustomerType == null) {
            return null;
        }
        if (CustomerType.equalsIgnoreCase("Normal")) {
            return new NormalCustomerBill();
        } else if (CustomerType.equalsIgnoreCase("Special")) {
            return new SpecialCustomerBill();
        }
        return null;
    }
        
    }
    

