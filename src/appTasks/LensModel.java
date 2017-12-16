/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTasks;

import java.util.List;
import java.util.Observable;
import appTasks.Lens_info ;

/**
 *
 * @author nermeen
 */
public class LensModel  extends Observable{
    
     private List<Lens_info> lenses;
     
     
     public List<Lens_info> getLenses() {
        return lenses;
    }
     
     public void setLenses(List<Lens_info> lenses) {
        this.lenses = lenses;
        setChanged();
        notifyObservers();
    }
     
}
