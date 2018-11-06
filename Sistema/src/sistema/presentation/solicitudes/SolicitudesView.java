
package sistema.presentation.solicitudes;

import java.util.Observer;
import javax.swing.JOptionPane;
import sistema.Application;
import sistema.logic.Funcionario;
import sistema.logic.Solicitud;
import sistema.logic.Usuario;

/**
 *
 * @author Rachel
 */
public class SolicitudesView extends javax.swing.JInternalFrame implements Observer {

    SolicitudesController controller;
    SolicitudesModel model;
    Solicitud soli;

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
        
        saveRegButton.setEnabled(false);
        numSolicutdTxt.setEditable(false);
        cancelRegButton.setEnabled(false);
        funcionariosDropDown.setEditable(false);
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
        jSeparator1 = new javax.swing.JSeparator();
        solocitudId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        funcionariosDropDown = new javax.swing.JComboBox<>();
        numSolicutdTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        saveRegButton = new javax.swing.JButton();
        cancelRegButton = new javax.swing.JButton();

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

        solocitudId.setText("Numero de solicitud:");

        jLabel1.setText("Asignar registrador:");

        numSolicutdTxt.setToolTipText("");
        numSolicutdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numSolicutdTxtActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/register.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        saveRegButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/save.png"))); // NOI18N
        saveRegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRegButtonActionPerformed(evt);
            }
        });

        cancelRegButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/close.png"))); // NOI18N
        cancelRegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelRegButtonActionPerformed(evt);
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
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(printButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(28, 28, 28)
                                    .addComponent(funcionariosDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(solocitudId)
                                    .addGap(22, 22, 22)
                                    .addComponent(numSolicutdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(67, 67, 67)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(saveRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGap(19, 19, 19))))
                .addGap(29, 29, 29)
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
                .addContainerGap(28, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(printButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(solocitudId)
                        .addComponent(numSolicutdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(saveRegButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(funcionariosDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addContainerGap(106, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelRegButton)
                .addContainerGap())
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
            Application.SOLICITUD_CONTROLLER.refrescarPantalla();
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

    private void numSolicutdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numSolicutdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numSolicutdTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int row = this.solicitudesTable.getSelectedRow();
       
        if (row!=-1){
            soli = controller.Solicitud(row);
            numSolicutdTxt.setText(String.valueOf(soli.getSolicitudId()));
            addButton.setEnabled(false);
            cancelButton.setEnabled(false);
            printButton.setEnabled(false);
        }else
            soli = null;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelRegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelRegButtonActionPerformed
        numSolicutdTxt.setText("");
        funcionariosDropDown.setSelectedIndex(0);
    }//GEN-LAST:event_cancelRegButtonActionPerformed

    private void saveRegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRegButtonActionPerformed
        addButton.setEnabled(true);
        cancelButton.setEnabled(true);
        printButton.setEnabled(true);
        saveRegButton.setEnabled(false);
        cancelRegButton.setEnabled(false);
        numSolicutdTxt.setEditable(false);
        funcionariosDropDown.setEditable(false);
        
        soli.setSolicitudRegistradorDeBienes((Funcionario) funcionariosDropDown.getSelectedItem());
        
        controller.editarSolicitud(soli);
    }//GEN-LAST:event_saveRegButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel bienesLbl;
    private javax.swing.JTable bienesTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelRegButton;
    private javax.swing.JComboBox<Usuario> funcionariosDropDown;
    private javax.swing.JButton incorporarBttn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField numSolicutdTxt;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveRegButton;
    private javax.swing.JButton searchBttn;
    private javax.swing.JTextField searchFld;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JSeparator separator;
    private javax.swing.JTable solicitudesTable;
    private javax.swing.JLabel solocitudId;
    // End of variables declaration//GEN-END:variables
}
