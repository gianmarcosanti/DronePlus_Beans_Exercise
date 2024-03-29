
import com.mycompany.dronesBean.Drone;
import com.mycompany.dronesBean.Coordinate;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gianmarcosanti
 */
public class DronesGUI extends javax.swing.JFrame implements VetoableChangeListener {

    /**
     * Creates new form DronesGUI
     */
    public DronesGUI() {
        initComponents();
    }
    
    @Override
    public void vetoableChange(PropertyChangeEvent evt)
      throws PropertyVetoException {
        
        
        
        int previewNewX = ((Coordinate)evt.getNewValue()).getX();
        int previewNewY = ((Coordinate)evt.getNewValue()).getY();
        Object oldValue = evt.getOldValue();
        
        
        if(oldValue != null){
            previewNewX += ((Coordinate)oldValue).getX();
            previewNewY += ((Coordinate)oldValue).getY();            
        }
            
        
        if(!this.checkPositions(previewNewX, previewNewY))
            throw new PropertyVetoException("The drone is trying to escape the panel/n", evt);

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDrones = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 0));

        pnlDrones.setBackground(new java.awt.Color(204, 204, 204));
        pnlDrones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlDrones.setSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout pnlDronesLayout = new javax.swing.GroupLayout(pnlDrones);
        pnlDrones.setLayout(pnlDronesLayout);
        pnlDronesLayout.setHorizontalGroup(
            pnlDronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
        pnlDronesLayout.setVerticalGroup(
            pnlDronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnAdd.setText("Add Drone");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDrones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 272, Short.MAX_VALUE))
                    .addComponent(pnlDrones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Drone newDrone = new Drone();
        DroneGUI droneGUI = new DroneGUI(newDrone, pnlDrones);
        
        newDrone.addPropertyChangeListener(droneGUI);
        newDrone.addVetoableChangeListener(this);
        newDrone.takeOff(new Coordinate((int)(Math.random()*(pnlDrones.getWidth())+1),
                (int)(Math.random()*(pnlDrones.getHeight())+1)));
        //newDrone.takeOff(new Coordinate(pnlDrones.getWidth(), pnlDrones.getHeight() - 21));
        pnlDrones.add(droneGUI);
        pnlDrones.revalidate();
        pnlDrones.repaint();
        System.out.println(pnlDrones.getWidth()+"\n");
        System.out.print(pnlDrones.getHeight());
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DronesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DronesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DronesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DronesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DronesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JPanel pnlDrones;
    // End of variables declaration//GEN-END:variables

    private boolean checkPositions(Integer previewNewX, Integer previewNewY) {
        Boolean xBounds = previewNewX > 0 && previewNewX + 
                (previewNewX.toString().length() + previewNewY.toString().length() + 2)*9 < this.pnlDrones.getWidth();
        Boolean yBounds = previewNewY > 0 && previewNewY< this.pnlDrones.getHeight();
        
        return xBounds && yBounds;
    }
}
