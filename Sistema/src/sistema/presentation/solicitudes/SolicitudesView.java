
package sistema.presentation.solicitudes;

import java.awt.Color;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.Application;
import sistema.logic.Bien;
import sistema.logic.Categoria;
import sistema.logic.Funcionario;
import sistema.logic.Solicitud;

/**
 *
 * @author Rachel
 */
public class SolicitudesView extends javax.swing.JInternalFrame implements Observer {

    SolicitudesController controller;
    SolicitudesModel model;
    int filaSolicitud;

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
        Solicitud filtro = model.getFilter();
        this.inicializaPantalla(filtro);
    }
    
    /**
     * Creates new form SolicitudesView
     */
    public SolicitudesView() {
        super("Solicitudes",false,true);
        initComponents();
    }
    
    public void inicializaPantalla(Solicitud filtro){
        
        this.fromEstado(filtro);
        solicitudesTable.setModel(model.getSolicitudes());
        
        if(controller.getSession() == true){
            if(!controller.permisoRegistrador()){ // si es registrador de bienes
                
                this.addButton.setVisible(false);
                this.cancelButton.setVisible(false);
                this.printButton.setVisible(false);
                this.aceptarBttn.setVisible(false);
                this.rechazarBttn.setVisible(false);
                this.saveBttn.setVisible(false);
                this.rechazoLbl.setVisible(false);
                this.jScrollPane3.setVisible(false);
                
                this.bienesTable.setModel(model.getBienes());
                this.categoriaBox.setModel(model.getCategorias());
                this.categoriaBox.setEnabled(false);
                
                if(model.getModo() == Application.EDITAR){
                    this.bienesTable.setModel(model.getBienes());
                    this.categoriaBox.setEnabled(true);
                    
                this.setSize(1177, 384);    
            }
            }
            else{
  
                if(controller.permisoSecretario()){ //si es secretario
                    this.separator.setVisible(false);
                    this.bienesLbl.setVisible(false);
                    this.jScrollPane2.setVisible(false);
                    this.incorporarBttn.setVisible(false);
                    this.categoriaBox.setVisible(false);
                    this.categoriaLbl.setVisible(false);
                    this.addButton.setVisible(false);
                    this.cancelButton.setVisible(false);
                    this.printButton.setVisible(false);
                    this.rechazoFld.setEditable(false);
                    
                    this.setSize(440, 552);
                    
                    if(model.getModo() == Application.EDITAR){
                        this.rechazoFld.setEditable(true);
                    }
                
                }else{
                    //si es administrador
                    this.separator.setVisible(false);
                    this.bienesLbl.setVisible(false);
                    this.jScrollPane2.setVisible(false);
                    this.incorporarBttn.setVisible(false);
                    this.categoriaBox.setVisible(false);
                    this.categoriaLbl.setVisible(false);
                    this.aceptarBttn.setVisible(false);
                    this.rechazarBttn.setVisible(false);
                    this.saveBttn.setVisible(false);
                    this.rechazoLbl.setVisible(false);
                    this.jScrollPane3.setVisible(false);
                
                    this.setSize(489, 393);
                }
                }
            }
        }
    
    public void limpiarErrores(){
        this.searchFld.setForeground(Application.COLOR_OK);
        this.rechazoLbl.setForeground(Application.COLOR_OK);
        
        this.rechazoFld.setText("");
    }
    
    public void fromEstado(Solicitud filtro){
        if(filtro.getSolicitudId() != null)
            searchFld.setText(String.valueOf(filtro.getSolicitudId())); 
   }   
   
    Solicitud toEstado(){
        Solicitud result = new Solicitud();
        result.setSolicitudEstado(searchFld.getText());
        return result;
    }
    
    void mensaje(String error){
        JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE); 
    }
    
    void mensajeAgregado(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Solicitud filtro(){
        Solicitud solicitud = new Solicitud();
        solicitud.setSolicitudId(Integer.valueOf(this.searchFld.getText()));
        return solicitud;
    }
   
    public boolean validaIncorporacion(){
        Solicitud solicitud = controller.getSolicitud(this.filaSolicitud);
        boolean valido = true;
        
        for(Bien bien : solicitud.getSolicitudComprobante().getBienCollection()){
            if(bien.getBienCategoria() == null){
                valido = false;    
                this.categoriaLbl.setForeground(Color.red);}
        }
        
        return valido;
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
        categoriaLbl = new javax.swing.JLabel();
        categoriaBox = new javax.swing.JComboBox();
        categoriaBttn = new javax.swing.JButton();
        aceptarBttn = new javax.swing.JButton();
        rechazarBttn = new javax.swing.JButton();
        rechazoLbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rechazoFld = new javax.swing.JTextArea();
        saveBttn = new javax.swing.JButton();

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
        solicitudesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                solicitudesTableMouseClicked(evt);
            }
        });
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
        incorporarBttn.setText("Incorporar bienes");
        incorporarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incorporarBttnActionPerformed(evt);
            }
        });

        categoriaLbl.setText("Selecciona la categoria");

        categoriaBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        categoriaBttn.setText("Asignar Categoria");
        categoriaBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaBttnActionPerformed(evt);
            }
        });

        aceptarBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/success(1).png"))); // NOI18N
        aceptarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBttnActionPerformed(evt);
            }
        });

        rechazarBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/close.png"))); // NOI18N
        rechazarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazarBttnActionPerformed(evt);
            }
        });

        rechazoLbl.setText("Razon de rechazo:");

        rechazoFld.setColumns(20);
        rechazoFld.setRows(5);
        jScrollPane3.setViewportView(rechazoFld);

        saveBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/save.png"))); // NOI18N
        saveBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBttnActionPerformed(evt);
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
                .addGap(59, 59, 59)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(categoriaLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(categoriaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(categoriaBttn)
                                .addGap(95, 95, 95))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bienesLbl)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(incorporarBttn)
                        .addGap(250, 250, 250))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(aceptarBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rechazarBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rechazoLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
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
                                        .addComponent(printButton))))
                            .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(bienesLbl)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoriaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoriaLbl)
                            .addComponent(categoriaBttn))
                        .addGap(18, 18, 18)
                        .addComponent(incorporarBttn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rechazarBttn)
                    .addComponent(aceptarBttn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rechazoLbl)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveBttn)
                        .addGap(29, 29, 29))))
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
         try{           
             this.controller.getSolicitud(this.filaSolicitud);
             
             if(this.validaIncorporacion()){
                 controller.incorporarBienes(filaSolicitud);
                 controller.changeEstado(this.filaSolicitud, "Espera de Rotulacion", "");
                 this.mensajeAgregado("Bienes incorporados con exito.");
             }else{
                 this.mensaje("Debe asignarle una categoria a cada bien.");
             }
        }catch(Exception ex){
            this.mensaje(ex.getMessage());        
    }      
    }//GEN-LAST:event_incorporarBttnActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // print
    }//GEN-LAST:event_printButtonActionPerformed

    private void solicitudesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solicitudesTableMouseClicked
       if(evt.getClickCount() == 2){
            filaSolicitud = this.solicitudesTable.getSelectedRow();
            
           controller.setModo(Application.EDITAR, filaSolicitud);
           
           try {
               controller.buscarBienes(filaSolicitud);
           } catch (Exception ex) {
               this.mensaje(ex.getMessage());
           }
        }
    }//GEN-LAST:event_solicitudesTableMouseClicked

    private void categoriaBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaBttnActionPerformed
       int fila = this.bienesTable.getSelectedRow();
        
        if(fila != -1){
           try {
               controller.asignarCategoria(fila, (Categoria) this.categoriaBox.getSelectedItem(), this.filaSolicitud);
           } catch (Exception ex) {
               this.mensaje(ex.getMessage());
           }
        }
    }//GEN-LAST:event_categoriaBttnActionPerformed

    private void aceptarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBttnActionPerformed
       int fila = this.solicitudesTable.getSelectedRow();
       String estado = "Por verificar";
       
       try{
           controller.changeEstado(fila, estado, "");
       }catch(Exception e){}
    }//GEN-LAST:event_aceptarBttnActionPerformed

    private void rechazarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechazarBttnActionPerformed
       filaSolicitud = this.solicitudesTable.getSelectedRow();
       this.controller.setModo(Application.EDITAR, filaSolicitud);
    }//GEN-LAST:event_rechazarBttnActionPerformed

    private void saveBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBttnActionPerformed

        if(validaRechazo()){
            String estado = "Rechazada";
            String rechazo = this.rechazoFld.getText();
            
            this.controller.setModo(Application.EDITAR, filaSolicitud);
            
            try{
                controller.changeEstado(filaSolicitud, estado, rechazo);
            }catch(Exception e){}
            
        }else{
            this.mensaje("Debe ingresar la razon del rechazo.");
        }
    }//GEN-LAST:event_saveBttnActionPerformed

    public boolean validaRechazo(){
        if(this.rechazoFld.getText().isEmpty()){
            this.rechazoLbl.setForeground(Color.red);
            return false;
        }
        else
            return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBttn;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel bienesLbl;
    private javax.swing.JTable bienesTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox categoriaBox;
    private javax.swing.JButton categoriaBttn;
    private javax.swing.JLabel categoriaLbl;
    private javax.swing.JButton incorporarBttn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton printButton;
    private javax.swing.JButton rechazarBttn;
    private javax.swing.JTextArea rechazoFld;
    private javax.swing.JLabel rechazoLbl;
    private javax.swing.JButton saveBttn;
    private javax.swing.JButton searchBttn;
    private javax.swing.JTextField searchFld;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JSeparator separator;
    private javax.swing.JTable solicitudesTable;
    // End of variables declaration//GEN-END:variables
}
