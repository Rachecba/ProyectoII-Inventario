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
import sistema.logic.Comprobante;
import sistema.logic.Dependencia;
import sistema.logic.Solicitud;
import sistema.logic.TipoDeAdquisicion;

/**
 *
 * @author Rachel
 */
public final class SolicitudView extends javax.swing.JInternalFrame implements Observer {

    SolicitudController controller;
    SolicitudModel model;
    Integer cantBienes;
    Double totalDeBienes;

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
        this.inicializaPantalla();
    }
    
    /**
     * Creates new form SolicitudesView
     */
    public SolicitudView() {
        super("Solicitudes",false,true);
        initComponents();
        
        cantBienTxt.setText("0");
        totalTxt.setText("0");
        
    }
    
    public void inicializaPantalla(){
        cantBienTxt.setEditable(false);
        totalTxt.setEditable(false);
        
        descTxt.setEditable(false);
        marcaTxt.setEditable(false);
        modeloTxt.setEditable(false);
        precioTxt.setEnabled(false);
        cantidadSpinner.setEnabled(false);
        
        crearBien.setEnabled(false);
        cancelBien.setEnabled(false);
        
        this.tipoDropDown.setModel(model.getTiposDeActivo());
        this.dependenciaDropDwn.setModel(model.getDependencias());
        
    }
    
    public void updateTablaBienes(){
        try {
            this.controller.setTablaBienes();
            this.bienesTable.setModel(model.getBienTableModel());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    public void limpiarSolicitud(){
        this.numSolicitudTxt.setText("");
        this.comprobanteTxt.setText("");
        this.estSolcTxt.setText("");
        this.fechaTxt.setCalendar(null);
        this.tipoDropDown.setSelectedIndex(0);
        this.dependenciaDropDwn.setSelectedIndex(0);
        
        this.cantBienTxt.setText("");
        this.totalTxt.setText("");
    }
    
    public void limpiarBien(){
        this.descTxt.setText("");
        this.marcaTxt.setText("");
        this.modeloTxt.setText("");
        this.precioTxt.setValue(0);
        this.cantidadSpinner.setValue(0);
    }
    
    boolean validar(){
        boolean error=false;
        
        this.limpiarErrores();
        
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
        
        this.limpiarErrores();
        
        if(this.descTxt.getText().isEmpty()){
            this.descLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.marcaTxt.getText().isEmpty()){
            this.marcaLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(this.modeloTxt.getText().isEmpty()){
            this.modeloLabel.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        if(Integer.valueOf(this.cantidadSpinner.getValue().toString()) == 0){
            this.cantidadLbl.setForeground(Application.COLOR_ERROR);
            error = true;
        }
        
        return !error;
    }
    
    public void mensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensajeAgregado(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Bien bien(){
        Bien nuevo = new Bien();
        
        nuevo.setBienDescripcion(this.descTxt.getText());
        nuevo.setBienMarca(this.marcaTxt.getText());
        nuevo.setBienModelo(this.modeloTxt.getText());
        nuevo.setBienPrecio(Double.valueOf(precioTxt.getValue().toString()));
        nuevo.setBienCantidad(this.cantidadSpinner.getComponentCount());
        
        return nuevo;
    }
    
    public Solicitud solicitud(){
        Solicitud nuevo = new Solicitud();
        
        Comprobante comprobante = this.crearComprobante(new Comprobante(comprobanteTxt.getText(), fechaTxt.getDate(), Integer.valueOf(this.cantBienTxt.getText())
                , Double.valueOf(this.totalTxt.getText()), (TipoDeAdquisicion) this.tipoDropDown.getSelectedItem()));
        
        nuevo.setSolicitudComprobante(comprobante);
        nuevo.setSolicitudDependencia((Dependencia) dependenciaDropDwn.getSelectedItem());
        
        return nuevo;
    }
    
    public Comprobante crearComprobante(Comprobante comprobante){
        return controller.crearComprobante(comprobante);
    }
    
    public void calcularTotales(Integer i, Double d){
        this.cantBienTxt.setText(String.valueOf(Integer.valueOf(this.cantBienTxt.getText()) + i));
        this.totalTxt.setText(String.valueOf(Double.valueOf(this.totalTxt.getText()) + d));
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
        crearBien = new javax.swing.JButton();
        cancelBien = new javax.swing.JButton();
        crearSolicitud = new javax.swing.JButton();
        cancelarSolicitud = new javax.swing.JButton();
        cantidadLbl = new javax.swing.JLabel();
        cantidadSpinner = new javax.swing.JSpinner();
        precioTxt = new javax.swing.JSpinner();
        fechaTxt = new com.toedter.calendar.JDateChooser();
        dependenciaLabel = new javax.swing.JLabel();
        dependenciaDropDwn = new javax.swing.JComboBox<>();

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

        cantBienTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantBienTxtActionPerformed(evt);
            }
        });

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
        cancelarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarSolicitudActionPerformed(evt);
            }
        });

        cantidadLbl.setText("Cantidad:");

        fechaTxt.setDateFormatString("d, MMM yyyy");

        dependenciaLabel.setText("Dependencia:");

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
                                        .addComponent(jSeparator3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(modeloLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(modeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(descLabel)
                                                            .addComponent(marcaLabel))
                                                        .addGap(51, 51, 51)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(marcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(precioLabel)
                                                            .addComponent(cantidadLbl))
                                                        .addGap(30, 30, 30)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(cantidadSpinner)
                                                            .addComponent(precioTxt))))
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(crearBien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cancelBien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50))))))
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
                                    .addComponent(fechaLabel)
                                    .addComponent(dependenciaLabel))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fechaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dependenciaDropDwn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comprobanteTxt))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(crearSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cancelarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(crearSolicitud)
                                .addGap(122, 122, 122))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comprobanteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(generalInfoLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numSolicitudTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numSolLabel)
                            .addComponent(numCompLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(estadoSolLabel)
                                    .addComponent(estSolcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cancelarSolicitud)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dependenciaLabel)
                                        .addComponent(tipoDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tipoLabel)
                                        .addComponent(dependenciaDropDwn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(54, 54, 54)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(modeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(modeloLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(precioLabel)
                                            .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(cancelBien))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cantidadLbl)))))
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
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
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
        precioTxt.setEnabled(true);
        cantidadSpinner.setEnabled(true);
        crearBien.setEnabled(true);
        cancelBien.setEnabled(true);
        
        numSolicitudTxt.setEditable(false);
        estSolcTxt.setEditable(false);
        tipoDropDown.setEditable(false);
        comprobanteTxt.setEditable(false);
        fechaTxt.setEnabled(false);
        addButton.setEnabled(false);
        deleteButton.setEnabled(false);
        crearSolicitud.setEnabled(false);
        cancelarSolicitud.setEnabled(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBienActionPerformed
        descTxt.setEditable(false);
        marcaTxt.setEditable(false);
        modeloTxt.setEditable(false);
        precioTxt.setEnabled(false);
        cantidadSpinner.setEnabled(false);
        crearBien.setEnabled(false);
        cancelBien.setEnabled(false);
        
        descTxt.setText("");
        marcaTxt.setText("");
        modeloTxt.setText("");
        precioTxt.setValue(0);
        cantidadSpinner.setValue(0);
        
        numSolicitudTxt.setEditable(true);
        estSolcTxt.setEditable(true);
        tipoDropDown.setEditable(true);
        comprobanteTxt.setEditable(true);
        fechaTxt.setEnabled(true);
        addButton.setEnabled(true);
        deleteButton.setEnabled(true);
        crearSolicitud.setEnabled(true);
        cancelarSolicitud.setEnabled(true);
    }//GEN-LAST:event_cancelBienActionPerformed

    private void crearBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBienActionPerformed
        if(validarBien()){
            try{
                Bien bien = bien();
                if(controller.agregarBien(bien))
                    calcularTotales(bien.getBienCantidad(), bien.getBienPrecio());
                limpiarBien();
                updateTablaBienes();
            }catch(Exception ex){
                ex.printStackTrace();
                this.mensaje(ex.getMessage());
            }
        }else{
            this.mensaje("Debe ingresar todos los datos que le solicitan");
        }
    }//GEN-LAST:event_crearBienActionPerformed

    private void crearSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearSolicitudActionPerformed
        if(validar()){
            try{
                Solicitud solicitud = solicitud();
                controller.crearSolicitud(solicitud);
                controller.asignarBienes(solicitud);
                limpiarSolicitud();
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

    private void cantBienTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantBienTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantBienTxtActionPerformed

    private void cancelarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarSolicitudActionPerformed
        this.numSolicitudTxt.setText("");
        this.estSolcTxt.setText("");
        this.comprobanteTxt.setText("");
        this.fechaTxt.setCalendar(null);
        this.tipoDropDown.setSelectedIndex(0);
        this.dependenciaDropDwn.setSelectedIndex(0);
        this.controller.cancelarSolicitud();
    }//GEN-LAST:event_cancelarSolicitudActionPerformed

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
    private javax.swing.JComboBox<Dependencia> dependenciaDropDwn;
    private javax.swing.JLabel dependenciaLabel;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextField descTxt;
    private javax.swing.JTextField estSolcTxt;
    private javax.swing.JLabel estadoSolLabel;
    private javax.swing.JLabel fechaLabel;
    private com.toedter.calendar.JDateChooser fechaTxt;
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
    private javax.swing.JSpinner precioTxt;
    private javax.swing.JComboBox<TipoDeAdquisicion> tipoDropDown;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables
}
