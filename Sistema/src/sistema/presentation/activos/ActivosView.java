
package sistema.presentation.activos;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.Application;
import sistema.logic.ActivoUniversitario;
import sistema.logic.Labor;

/**
 *
 * @author Rachel
 */
public class ActivosView extends javax.swing.JInternalFrame implements Observer {
    
    ActivosController controller;
    ActivosModel model;
    
    public ActivosController getController() {
        return controller;
    }
    
    public ActivosModel getModel() {
        return model;
    }
    
    public void setController(ActivosController controller) {
        this.controller = controller;
    }
    
    public void setModel(ActivosModel model) {
        this.model = model;
        model.addObserver(this);
    }
    
    public ActivosView() {
        super("Activos",false,true);
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchLbl = new javax.swing.JLabel();
        searchFld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        activosTable = new javax.swing.JTable();
        searchBttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        etiquetadosBttn = new javax.swing.JButton();
        imprimirBttn = new javax.swing.JButton();
        ubicacionLbl = new javax.swing.JLabel();
        laborLbl = new javax.swing.JLabel();
        laborBox = new javax.swing.JComboBox();
        saveBttn = new javax.swing.JButton();
        procesadaBttn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/generales/diamond(1).png"))); // NOI18N

        searchLbl.setText("Search");

        activosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        activosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activosTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(activosTable);

        searchBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/search.png"))); // NOI18N
        searchBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBttnActionPerformed(evt);
            }
        });

        etiquetadosBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/tag.png"))); // NOI18N
        etiquetadosBttn.setText("Activos etiquetados");
        etiquetadosBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiquetadosBttnActionPerformed(evt);
            }
        });

        imprimirBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/print.png"))); // NOI18N
        imprimirBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirBttnActionPerformed(evt);
            }
        });

        ubicacionLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/placeholder(1).png"))); // NOI18N
        ubicacionLbl.setText("Registrar/Modificar datos de ubicacion");

        laborLbl.setText("Labor");

        laborBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        saveBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/save.png"))); // NOI18N
        saveBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBttnActionPerformed(evt);
            }
        });

        procesadaBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/success.png"))); // NOI18N
        procesadaBttn.setText("Solicitud Procesada");
        procesadaBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesadaBttnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(searchLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetadosBttn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(procesadaBttn)
                    .addComponent(imprimirBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(saveBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(laborLbl)
                                .addGap(26, 26, 26)
                                .addComponent(laborBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ubicacionLbl)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchLbl)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetadosBttn)
                            .addComponent(searchBttn)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ubicacionLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(imprimirBttn)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(procesadaBttn)
                                    .addComponent(saveBttn))
                                .addGap(102, 102, 102))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(laborLbl)
                                    .addComponent(laborBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(187, 187, 187))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void searchBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBttnActionPerformed
        if(this.searchFld.getText().isEmpty()){
            try{
                controller.buscarTodos();
            }
            catch(Exception ex){
                this.mensaje(ex.getMessage());
            }
        }
        else{
            try{
                controller.buscar(this.searchFld.getText());
            }
            catch(Exception ex){
                this.mensaje(ex.getMessage());
            }
        } 
    }//GEN-LAST:event_searchBttnActionPerformed
    
    private void etiquetadosBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiquetadosBttnActionPerformed
        try{
            controller.buscarEtiquetados();
        }
        catch(Exception ex){
            this.mensaje(ex.getMessage());
        }
    }//GEN-LAST:event_etiquetadosBttnActionPerformed
    
    private void saveBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBttnActionPerformed
        int fila = this.activosTable.getSelectedRow();
        
        try {
            controller.datosUbicacion(fila, (Labor) this.laborBox.getSelectedItem());
            this.mensajeAgregado("Datos agregados con exito.");
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
        
        
    }//GEN-LAST:event_saveBttnActionPerformed
    
    private void procesadaBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesadaBttnActionPerformed
        int fila = this.activosTable.getSelectedRow();
        
        try {
            controller.changeEstadoProcesada(fila);
            this.mensajeAgregado("Solicitud Procesada con exito.");
        } catch (Exception ex) {
            this.mensaje(ex.getMessage());
        }
    }//GEN-LAST:event_procesadaBttnActionPerformed
    
    private void imprimirBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirBttnActionPerformed
        int fila = this.activosTable.getSelectedRow();
        
        try {
            controller.codigoDeBarras(fila);
            this.mensajeAgregado("Se creo correctamente el PDF para imprimir. El archivo se encuentra en el escritorio.");
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }//GEN-LAST:event_imprimirBttnActionPerformed
    
    private void activosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activosTableMouseClicked
        if(evt.getClickCount() == 2){
            
            controller.setModo(Application.EDITAR);
            
        }
    }//GEN-LAST:event_activosTableMouseClicked
    
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
            java.util.logging.Logger.getLogger(ActivosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActivosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActivosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActivosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActivosView().setVisible(true);
            }
        });
    }
    
    public void limpiarErrores(){
        this.searchFld.setForeground(Application.COLOR_OK);
        
    }
    
    public void inicializaPantalla(){
        
        this.etiquetadosBttn.setVisible(true);
        this.imprimirBttn.setVisible(true);
        this.procesadaBttn.setVisible(true);
        this.jSeparator1.setVisible(true);
        this.ubicacionLbl.setVisible(true);
        this.laborLbl.setVisible(true);
        this.laborBox.setVisible(true);
        this.saveBttn.setVisible(true);
        this.activosTable.setVisible(true);
        
        this.activosTable.setModel(model.getActivos());
        this.laborBox.setModel(model.getLabores());
        
        if(controller.getSession() == true){
            if(!controller.permisoAdmin()){
                this.etiquetadosBttn.setVisible(false);
                this.imprimirBttn.setVisible(false);
                this.procesadaBttn.setVisible(false);
                this.jSeparator1.setVisible(false);
                this.ubicacionLbl.setVisible(false);
                this.laborLbl.setVisible(false);
                this.laborBox.setVisible(false);
                this.saveBttn.setVisible(false);
                
                this.setSize(539, 449);
                
            }
            
            if(!controller.permisoJefeOCCB()){
                this.etiquetadosBttn.setVisible(false);
                this.imprimirBttn.setVisible(false);
                this.procesadaBttn.setVisible(false);
                this.jSeparator1.setVisible(false);
                this.ubicacionLbl.setVisible(false);
                this.laborLbl.setVisible(false);
                this.laborBox.setVisible(false);
                this.saveBttn.setVisible(false);
                
                this.setSize(539, 449);
            }
            
            if(!controller.permisoRegistrador()){
                this.etiquetadosBttn.setVisible(true);
                this.imprimirBttn.setVisible(true);
                this.procesadaBttn.setVisible(true);
                this.jSeparator1.setVisible(true);
                this.ubicacionLbl.setVisible(true);
                this.laborLbl.setVisible(true);
                this.laborBox.setVisible(true);
                this.saveBttn.setVisible(true);
                
                this.setSize(1093, 449);
            }
            
        }
        
    }
    
    void mensajeAgregado(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    void mensaje(String error){
        JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activosTable;
    private javax.swing.JButton etiquetadosBttn;
    private javax.swing.JButton imprimirBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox laborBox;
    private javax.swing.JLabel laborLbl;
    private javax.swing.JButton procesadaBttn;
    private javax.swing.JButton saveBttn;
    private javax.swing.JButton searchBttn;
    private javax.swing.JTextField searchFld;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JLabel ubicacionLbl;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void update(Observable o, Object arg) {
        this.limpiarErrores();
        //ActivoUniversitario filtro = model.getFiltro();
        this.inicializaPantalla();
    }
}
