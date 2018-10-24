/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.principal;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JInternalFrame;

/**
 *
 * @author Rachel
 */
public class PrincipalView extends javax.swing.JFrame implements Observer {
    
    PrincipalController controller;
    PrincipalModel model;

    public PrincipalController getController() {
        return controller;
    }

    public PrincipalModel getModel() {
        return model;
    }

    public void setController(PrincipalController controller) {
        this.controller = controller;
    }

    public void setModel(PrincipalModel model) {
        this.model = model;
        model.addObserver(this);
    }
    
    
   public void addInternalFrame(JInternalFrame f){
       this.desktopPane.add(f);
   }
      
    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        initComponents();
        this.setSize(this.getMaximumSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        salir = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        solicitudes = new javax.swing.JMenu();
        activos = new javax.swing.JMenu();
        articulos = new javax.swing.JMenu();
        funcionarios = new javax.swing.JMenu();
        dependencias = new javax.swing.JMenu();
        ayuda = new javax.swing.JMenu();

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        salir.setText("Salir");

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        salir.add(logout);

        jMenuBar1.add(salir);

        solicitudes.setText("Solicitudes");
        jMenuBar1.add(solicitudes);

        activos.setText("Activos");
        jMenuBar1.add(activos);

        articulos.setText("Articulos");
        jMenuBar1.add(articulos);

        funcionarios.setText("Funcionarios");
        jMenuBar1.add(funcionarios);

        dependencias.setText("Dependencias");
        jMenuBar1.add(dependencias);

        ayuda.setText("Ayuda");
        jMenuBar1.add(ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.controller.exit();
    }//GEN-LAST:event_logoutActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        if (model.getUsuario() != null){
           this.setTitle("Username: "+model.getUsuario().getUsuarioUsername());
       }
       else{
           this.setTitle("Sistema");
       }       
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu activos;
    private javax.swing.JMenu articulos;
    private javax.swing.JMenu ayuda;
    private javax.swing.JMenu dependencias;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu funcionarios;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu salir;
    private javax.swing.JMenu solicitudes;
    // End of variables declaration//GEN-END:variables
}
