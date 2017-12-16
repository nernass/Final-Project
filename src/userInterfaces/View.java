/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaces;

import appTasks.LensModel;
import appTasks.Lens_info;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;

/**
 *
 * @author nermeen
 */
public class View extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        jList1.setBackground(new java.awt.Color(255, 153, 153));
        jList1.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        
          
          DefaultListModel<String> aDefaultListModel = new DefaultListModel<String>();
               
          aDefaultListModel.addElement("Type -- Color -- Size -- Quantity -- Price");
          aDefaultListModel.addElement("====================");
        List<Lens_info> Lenses = ((LensModel) o).getLenses();
      
       
        
        for(Lens_info aLens_info : Lenses){
            String row = aLens_info.getType() ;
            row += " -- " + aLens_info.getColor();
            row += " -- " + aLens_info.getSize();
            row += " -- " + aLens_info.getQuantity();
            row += " -- " + aLens_info.getPrice();
            
            aDefaultListModel.addElement(row);
        }
        jList1.setModel(aDefaultListModel);
    }
    }

