/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitud;

import java.util.Observer;
import javax.swing.JOptionPane;
import sistema.Application;
import sistema.logic.Bien;
import sistema.logic.Funcionario;

/**
 *
 * @author Rachel
 */
public class SolicitudView extends javax.swing.JInternalFrame implements Observer {

    SolicitudController controller;
    SolicitudModel model;

    public SolicitudController getController() {
        return controller;
    }

    public void setController(SolicitudController controller) {
        this.controller = controller;
    }

    public SolicitudModel getModel() {
        return model;
    }

    public void setModel(SolicitudModel model) {
        this.model = model;
    }
    
    @Override
    public void update(java.util.Observable updatedModel,Object parametros){
        this.limpiarErrores();
    }
    
    /**
     * Creates new form SolicitudesView
     */
    public SolicitudView() {
        super("Solicitudes",false,true);
        initComponents();
    }
    
    public void initSpecifics(){
        cantBienTxt.setEditable(false);
        totalTxt.setEditable(false);
        
        descTxt.setEditable(false);
        marcaTxt.setEditable(false);
        modeloTxt.setEditable(false);
        precioTxt.setEditable(false);
        
    }
    
    public void limpiarErrores(){
        this.numSolLabel.setForeground(Application.COLOR_OK);
        this.numCompLabel.setForeground(Application.COLOR_OK);
        this.estadoSolLabel.setForeground(Application.COLOR_OK);
        this.fechaLabel.setForeground(Application.COLOR_OK);
        this.tipoLabel.setForeground(Application.COLOR_OK);
        
        this.descLabel.setForeground(Application.COLOR_OK);
        this.marcaLabel.setForeground(Application.COLOR_OK);
        this.modeloLabel.setForeground(Application.COLOR_OK);
        this.precioLabel.setForeground(Application.COLOR_OK);
    }  
    
    boolean validar(){
        boolean error=false;
        
        this.numSolLabel.setForeground(Application.COLOR_OK);
        this.numCompLabel.setForeground(Application.COLOR_OK);
        this.estadoSolLabel.setForeground(Application.COLOR_OK);
        this.fechaLabel.setForeground(Application.COLOR_OK);
        this.tipoLabel.setForeground(Application.COLOR_OK);
        
        if(this.numSolLabel.getText().isEmpty()){
            this.numSolLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.numCompLabel.getText().isEmpty()){
            this.numCompLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.estadoSolLabel.getText().isEmpty()){
            this.estadoSolLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.fechaLabel.getText().isEmpty()){
            this.fechaLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.tipoLabel.getText().isEmpty()){
            this.tipoLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        return !error;
    }
    
    boolean validarBien(){
        boolean error=false;
        
        this.descLabel.setForeground(Application.COLOR_OK);
        this.marcaLabel.setForeground(Application.COLOR_OK);
        this.modeloLabel.setForeground(Application.COLOR_OK);
        this.precioLabel.setForeground(Application.COLOR_OK);
        
        if(this.descLabel.getText().isEmpty()){
            this.descLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.marcaLabel.getText().isEmpty()){
            this.marcaLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.modeloLabel.getText().isEmpty()){
            this.modeloLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.precioLabel.getText().isEmpty()){
            this.precioLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        return !error;
    }
    
    void mensaje(String error){
        JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE); 
    }
    
    public Bien bien(){
        Bien nuevo = new Bien();
        
        nuevo.setBienDescripcion(this.descTxt.getText());
        nuevo.setBienMarca(this.marcaTxt.getText());
        nuevo.setBienModelo(this.modeloTxt.getText());
        nuevo.setBienPrecio(Double.valueOf(precioTxt.getText()));
        nuevo.setBienCantidad(this.cantidadSpinner.getComponentCount());
        
        return nuevo;
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
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        generalInfoLabel = new javax.swing.JLabel();
        numCompLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        tipoLabel = new javax.swing.JLabel();
        numSolicitudTxt = new javax.swing.JTextField();
        tipoDropDown = new javax.swing.JComboBox<>();
        fechaTxt = new javax.swing.JTextField();
        infoBienLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bienesTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cantBienLabel = new javax.swing.JLabel();
        cantBienTxt = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        numSolLabel = new javax.swing.JLabel();
        comprobanteTxt = new javax.swing.JTextField();
        estadoSolLabel = new javax.swing.JLabel();
        estSolcTxt = new javax.swing.JTextField();
        agregarBienLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        descLabel = new javax.swing.JLabel();
        marcaLabel = new javax.swing.JLabel();
        modeloLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        descTxt = new javax.swing.JTextField();
        marcaTxt = new javax.swing.JTextField();
        modeloTxt = new javax.swing.JTextField();
        precioTxt = new javax.swing.JTextField();
        crearBien = new javax.swing.JButton();
        cancelBien = new javax.swing.JButton();
        crearSolicitud = new javax.swing.JButton();
        cancelarSolicitud = new javax.swing.JButton();
        cantidadLbl = new javax.swing.JLabel();
        cantidadSpinner = new javax.swing.JSpinner();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        generalInfoLabel.setText("Información general:");

        numCompLabel.setText("Número de comprobante:");

        fechaLabel.setText("Fecha de adquisición:");

        tipoLabel.setText("Tipo de adqusicion:");

        numSolicitudTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numSolicitudTxtActionPerformed(evt);
            }
        });

        tipoDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        infoBienLabel.setText("Bienes:");

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
        bienesTable.setRowHeight(25);
        jScrollPane2.setViewportView(bienesTable);

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/add.png"))); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/trash.png"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        cantBienLabel.setText("Cantidad de bienes:");

        totalLabel.setText("Total:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        numSolLabel.setText("Número de solicitud:");

        estadoSolLabel.setText("Estado de solicitud:");

        agregarBienLabel.setText("Agregar/Modificar Bien");

        descLabel.setText("Descripción:");

        marcaLabel.setText("Marca:");

        modeloLabel.setText("Modelo:");

        precioLabel.setText("Precio unitario:");

        descTxt.setToolTipText("");

        crearBien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/save.png"))); // NOI18N
        crearBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBienActionPerformed(evt);
            }
        });

        cancelBien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/close.png"))); // NOI18N
        cancelBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBienActionPerformed(evt);
            }
        });

        crearSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/save.png"))); // NOI18N
        crearSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearSolicitudActionPerformed(evt);
            }
        });

        cancelarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/general/close.png"))); // NOI18N

        cantidadLbl.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGap(27, 27, 27))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(infoBienLabel)
                                        .addGap(41, 41, 41)
                                        .addComponent(cantBienLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cantBienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totalLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(agregarBienLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(descLabel)
                                                    .addGap(26, 26, 26)
                                                    .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(precioLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cantidadSpinner)
                                                        .addComponent(precioTxt))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(marcaLabel)
                                                        .addGap(66, 66, 66))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(modeloLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(marcaTxt)
                                                    .addComponent(modeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(crearBien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cancelBien, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGap(22, 86, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cantidadLbl)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(generalInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numSolLabel)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tipoLabel)
                                            .addComponent(estadoSolLabel))))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numSolicitudTxt)
                                    .addComponent(tipoDropDown, 0, 113, Short.MAX_VALUE)
                                    .addComponent(estSolcTxt))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numCompLabel)
                                    .addComponent(fechaLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comprobanteTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(fechaTxt))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cancelarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(crearSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(46, 46, 46))))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(generalInfoLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numSolicitudTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numSolLabel)
                            .addComponent(numCompLabel)
                            .addComponent(comprobanteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(crearSolicitud)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fechaLabel)
                            .addComponent(estadoSolLabel)
                            .addComponent(estSolcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoLabel)
                            .addComponent(tipoDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cancelarSolicitud)))
                .addGap(43, 43, 43)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(infoBienLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cantBienLabel)
                                .addComponent(cantBienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(totalLabel)
                                .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(addButton)
                                .addGap(26, 26, 26)
                                .addComponent(deleteButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarBienLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(descLabel)
                                            .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(marcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(marcaLabel)))
                                    .addComponent(crearBien))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(modeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(modeloLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(precioLabel)
                                            .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cancelBien)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadLbl)
                                    .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numSolicitudTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numSolicitudTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numSolicitudTxtActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        descTxt.setEditable(true);
        marcaTxt.setEditable(true);
        modeloTxt.setEditable(true);
        precioTxt.setEditable(true);
        cantidadSpinner.setEnabled(true);
        
        numSolicitudTxt.setEditable(false);
        estSolcTxt.setEditable(false);
        tipoDropDown.setEditable(false);
        comprobanteTxt.setEditable(false);
        fechaTxt.setEditable(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBienActionPerformed
        descTxt.setEditable(false);
        marcaTxt.setEditable(false);
        modeloTxt.setEditable(false);
        precioTxt.setEditable(false);
        cantidadSpinner.setEnabled(false);
        
        numSolicitudTxt.setEditable(true);
        estSolcTxt.setEditable(true);
        tipoDropDown.setEditable(true);
        comprobanteTxt.setEditable(true);
        fechaTxt.setEditable(true);
    }//GEN-LAST:event_cancelBienActionPerformed

    private void crearBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBienActionPerformed
        if(validarBien()){
            try{
                controller.agregarBien(bien());
            }catch(Exception ex){
                ex.printStackTrace();
                this.mensaje(ex.getMessage());
            }
        }else{
            this.mensaje("Debe ingresar todos los datos");
        }
    }//GEN-LAST:event_crearBienActionPerformed

    private void crearSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearSolicitudActionPerformed
        if(validar()){
            try{
//                controller.agregarSolicitud(funcionario());
            }catch(Exception ex){
                ex.printStackTrace();
                this.mensaje(ex.getMessage());
            }
        }else{
            this.mensaje("Debe ingresar todos los datos");
        }
    }//GEN-LAST:event_crearSolicitudActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = this.bienesTable.getSelectedRow();
        if (row!=-1){
            controller.borrarBien(row);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel agregarBienLabel;
    private javax.swing.JTable bienesTable;
    private javax.swing.JButton cancelBien;
    private javax.swing.JButton cancelarSolicitud;
    private javax.swing.JLabel cantBienLabel;
    private javax.swing.JTextField cantBienTxt;
    private javax.swing.JLabel cantidadLbl;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JTextField comprobanteTxt;
    private javax.swing.JButton crearBien;
    private javax.swing.JButton crearSolicitud;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextField descTxt;
    private javax.swing.JTextField estSolcTxt;
    private javax.swing.JLabel estadoSolLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JLabel generalInfoLabel;
    private javax.swing.JLabel infoBienLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel marcaLabel;
    private javax.swing.JTextField marcaTxt;
    private javax.swing.JLabel modeloLabel;
    private javax.swing.JTextField modeloTxt;
    private javax.swing.JLabel numCompLabel;
    private javax.swing.JLabel numSolLabel;
    private javax.swing.JTextField numSolicitudTxt;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JTextField precioTxt;
    private javax.swing.JComboBox<String> tipoDropDown;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables
}
