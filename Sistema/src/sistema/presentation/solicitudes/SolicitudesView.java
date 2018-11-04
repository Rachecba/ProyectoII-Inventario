
package sistema.presentation.solicitudes;

import java.util.Observer;
import javax.swing.JOptionPane;
import sistema.Application;
import sistema.logic.Funcionario;
import sistema.logic.Solicitud;

/**
 *
 * @author Rachel
 */
public class SolicitudesView extends javax.swing.JInternalFrame implements Observer {

    SolicitudesController controller;
    SolicitudesModel model;

    public SolicitudesController getController() {
        return controller;
    }

    public void setController(SolicitudesController controller) {
        this.controller = controller;
    }

    public SolicitudesModel getModel() {
        return model;
    }

    public void setModel(SolicitudesModel model) {
        this.model = model;
        model.addObserver(this);
    }
    
    @Override
    public void update(java.util.Observable updatedModel,Object parametros){
        this.limpiarErrores();
        this.inicializaPantalla();
        Solicitud filtro = model.getFilter();
        this.fromEstado(filtro);
        solicitudesTable.setModel(model.getSolicitudes());
    }
    
    /**
     * Creates new form SolicitudesView
     */
    public SolicitudesView() {
        super("Solicitudes",false,true);
        initComponents();
    }
    
    public void inicializaPantalla(){
        
        if(controller.getSession() == true){
            if(controller.permisoRegistrador()){
                this.separator.setVisible(false);
                this.bienesTable.setVisible(false);
                this.bienesLbl.setVisible(false);
                this.incorporarBttn.setVisible(false);
            }
        }
    }
    
    public void limpiarErrores(){
        this.searchFld.setForeground(Application.COLOR_OK);
    }
    
    public void fromEstado(Solicitud filtro){
      searchFld.setText(filtro.getSolicitudEstado()); 
   }   
   
    Solicitud toEstado(){
        Solicitud result = new Solicitud();
        result.setSolicitudEstado(searchFld.getText());
        return result;
    }
    
    void mensaje(String error){
        JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE); 
    }
    
    public Solicitud filtro(){
        Solicitud solicitud = new Solicitud();
        solicitud.setSolicitudId(Integer.valueOf(this.searchFld.getText()));
        return solicitud;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchLbl = new javax.swing.JLabel();
        searchFld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        solicitudesTable = new javax.swing.JTable();
        searchBttn = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        separator = new javax.swing.JSeparator();
        bienesLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bienesTable = new javax.swing.JTable();
        incorporarBttn = new javax.swing.JButton();

        searchLbl.setText("Search");

        solicitudesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        solicitudesTable.setRowHeight(25);
        jScrollPane1.setViewportView(solicitudesTable);

        searchBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/search.png"))); // NOI18N
        searchBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBttnActionPerformed(evt);
            }
        });

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/add.png"))); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/close.png"))); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/print.png"))); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bienesLbl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bienesLbl.setText("Bienes de Solicitud");

        bienesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(bienesTable);

        incorporarBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/folder.png"))); // NOI18N
        incorporarBttn.setText("Incorporar bien");
        incorporarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incorporarBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(searchLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(60, 60, 60)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(bienesLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(incorporarBttn)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchLbl))
                    .addComponent(searchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(addButton)
                        .addGap(32, 32, 32)
                        .addComponent(cancelButton)
                        .addGap(35, 35, 35)
                        .addComponent(printButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separator)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(bienesLbl)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(incorporarBttn)
                        .addContainerGap(31, Short.MAX_VALUE))))
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
                controller.buscar(this.filtro());
            }
            catch(Exception ex){
                this.mensaje(ex.getMessage());
            }
        } 
    }//GEN-LAST:event_searchBttnActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            Application.SOLICITUD_CONTROLLER.mostrar();
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int row = this.solicitudesTable.getSelectedRow();
        if (row!=-1){
            controller.cancelarSolicitud(row);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void incorporarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incorporarBttnActionPerformed
        
    }//GEN-LAST:event_incorporarBttnActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // print
    }//GEN-LAST:event_printButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel bienesLbl;
    private javax.swing.JTable bienesTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton incorporarBttn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JButton searchBttn;
    private javax.swing.JTextField searchFld;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JSeparator separator;
    private javax.swing.JTable solicitudesTable;
    // End of variables declaration//GEN-END:variables
}
