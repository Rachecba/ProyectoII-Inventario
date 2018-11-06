package sistema.presentation.principal;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;

/**
 *
 * @author Rachel
 */
public class PrincipalView extends JFrame implements Observer {
    
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
      
    public PrincipalView() {
        initComponents();
        this.setSize(this.getMaximumSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        salir = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        solicitudes = new javax.swing.JMenu();
        verSolicitudes = new javax.swing.JMenuItem();
        activos = new javax.swing.JMenu();
        verActivos = new javax.swing.JMenuItem();
        articulos = new javax.swing.JMenu();
        verArticulos = new javax.swing.JMenuItem();
        funcionarios = new javax.swing.JMenu();
        verFuncionarios = new javax.swing.JMenuItem();
        dependencias = new javax.swing.JMenu();
        verDependencias = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
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

        verSolicitudes.setText("Ver Solicitudes");
        verSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verSolicitudesActionPerformed(evt);
            }
        });
        solicitudes.add(verSolicitudes);

        jMenuBar1.add(solicitudes);

        activos.setText("Activos");

        verActivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/generales/diamond(1).png"))); // NOI18N
        verActivos.setText("Ver Activos");
        verActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActivosActionPerformed(evt);
            }
        });
        activos.add(verActivos);

        jMenuBar1.add(activos);

        articulos.setText("Articulos");

        verArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/generales/category.png"))); // NOI18N
        verArticulos.setText("Ver Articulos");
        verArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verArticulosActionPerformed(evt);
            }
        });
        articulos.add(verArticulos);

        jMenuBar1.add(articulos);

        funcionarios.setText("Funcionarios");

        verFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/generales/people.png"))); // NOI18N
        verFuncionarios.setText("Ver Funcionarios");
        verFuncionarios.setEnabled(false);
        verFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFuncionariosActionPerformed(evt);
            }
        });
        funcionarios.add(verFuncionarios);

        jMenuBar1.add(funcionarios);

        dependencias.setText("Dependencias");

        verDependencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/generales/university.png"))); // NOI18N
        verDependencias.setText("Ver Dependencias");
        verDependencias.setEnabled(false);
        verDependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDependenciasActionPerformed(evt);
            }
        });
        dependencias.add(verDependencias);

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

    private void verFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFuncionariosActionPerformed
        controller.showFuncionarios();
    }//GEN-LAST:event_verFuncionariosActionPerformed

    private void verDependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDependenciasActionPerformed
        controller.showDependencias();
    }//GEN-LAST:event_verDependenciasActionPerformed
    private void VerSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerSolicitudesActionPerformed
        controller.showSolicitudes();
    }//GEN-LAST:event_VerSolicitudesActionPerformed

    private void verArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verArticulosActionPerformed
        controller.showArticulos();
    }//GEN-LAST:event_verArticulosActionPerformed

    private void verSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verSolicitudesActionPerformed
        controller.showSolicitudes();
    }//GEN-LAST:event_verSolicitudesActionPerformed

    private void verActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActivosActionPerformed
        controller.showActivos();
    }//GEN-LAST:event_verActivosActionPerformed

    public void inicializaPermisos() throws Exception{
        
        if(controller.permisoJefeRRHH()){
            this.verDependencias.setEnabled(true);
            this.verFuncionarios.setEnabled(true);
        }else{
            if(controller.permisoAdministrador()){
                this.verSolicitudes.setEnabled(true);
                this.verActivos.setEnabled(true);
            }else{
                if(controller.permisoSecretaria()){
                    this.verSolicitudes.setEnabled(true);
                }else{
                    if(controller.permisoJefeOCCB()){
                        this.verSolicitudes.setEnabled(true);
                        this.verActivos.setEnabled(true);
                    }else{
                        if(controller.permisoRegistradorBienes()){
                            this.verArticulos.setEnabled(true);
                            this.verSolicitudes.setEnabled(true);
                            this.verActivos.setEnabled(true);
                        }
                    }
                }
            }
        }
        
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (model.getUsuario().getUsuarioUsername() != null){
           this.setTitle("Username: "+model.getUsuario().getUsuarioUsername());
            try {
                this.inicializaPermisos();
            } catch (Exception ex) {
                Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    private javax.swing.JMenuItem verActivos;
    private javax.swing.JMenuItem verArticulos;
    private javax.swing.JMenuItem verDependencias;
    private javax.swing.JMenuItem verFuncionarios;
    private javax.swing.JMenuItem verSolicitudes;
    // End of variables declaration//GEN-END:variables
}
