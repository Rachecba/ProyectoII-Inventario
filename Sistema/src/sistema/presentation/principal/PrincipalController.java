/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.principal;

import java.awt.Point;
import java.util.Arrays;
import sistema.Application;
import sistema.Sesion;
import sistema.logic.Model;
import sistema.logic.Usuario;

/**
 *
 * @author Rachel
 */
public class PrincipalController {
    Model domainModel;
    Sesion sesion; 
    PrincipalView view;
    PrincipalModel model;
    
    public PrincipalController(PrincipalView view, PrincipalModel model, Model domainModel, Sesion sesion){
    
        this.domainModel = domainModel;
        this.model = model;
        this.sesion = sesion;
        this.view = view;
        
        view.setController(this);
        view.setModel(model);
    }

    public PrincipalView getView() {
        return view;
    }

    public PrincipalModel getModel() {
        return model;
    }

    public void setView(PrincipalView view) {
        this.view = view;
    }

    public void setModel(PrincipalModel model) {
        this.model = model;
    }
    
    //---------------------- permisos -------------------------------
    
    public boolean permisoJefeRRHH(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario");
        if ( !Arrays.asList(Application.JEFE_RRHH).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de jefeRRHH
            return false;
        }
        else
            return true;
    }
    
    public boolean permisoSecretaria(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario");
        if ( !Arrays.asList(Application.SECRETARIA).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de secretaria
            return false;
        }
        else
            return true;
    
    }
    
    public boolean permisoRegistradorBienes(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario");
        if ( !Arrays.asList(Application.REGISTRADOR_BIENES).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de registrador de bienes
            return false;
        }
        else
            return true;
    }
    
    public boolean permisoAdministrador(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario");
        if ( !Arrays.asList(Application.ADMINISTRADOR).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de admin
            return false;
        }
        else
            return true;
    }
   
    public boolean permisoJefeOCCB(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario");
        if ( !Arrays.asList(Application.JEFE_OCCB).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de jefeOCCB
            return false;
        }
        else
            return true;
    }
    
    // --------------------- ventanas -------------------------------
    
    public void showArticulos(){ 
         Application.ARTICULOS_CONTROLLER.mostrar(); 
    }
    
    public void showActivos(){
         Application.ACTIVOS_CONTROLLER.mostrar(); 
    }
    
    public void showSolicitudes(){
         Application.SOLICITUDES_CONTROLLER.mostrar();
    }
    
    public void showDependencias(){ 
        Application.DEPENDENCIAS_CONTROLLER.mostrar(); 
    }
    
    public void showFuncionarios(){
         Application.FUNCIONARIOS_CONTROLLER.mostrar();
    }
    
     public void show(Point position){
        view.setLocation(position);
        view.setVisible(true);
    }    
     
     public void exit(){
      //   Application.ACTIVOS_CONTROLLER.ocultar();
         Application.ARTICULOS_CONTROLLER.ocultar();
         Application.DEPENDENCIAS_CONTROLLER.ocultar();
         Application.FUNCIONARIOS_CONTROLLER.ocultar();
        // Application.SOLICITUDES_CONTROLLER.ocultar();
         
         view.setVisible(false);
         Application.LOGIN_CONTROLLER.logout();
     }
     
     public void reset(){
         //setear las tablas de las ventanas....
         Application.SOLICITUDES_CONTROLLER.reset();
//         Application.ACTIVOS_CONTROLLER.reset();
         Application.ARTICULOS_CONTROLLER.reset();
         Application.FUNCIONARIOS_CONTROLLER.reset();
         Application.DEPENDENCIAS_CONTROLLER.reset();
         
         model.reset((Usuario) sesion.getAttribute("Usuario"));
     }
     
     public void enter(){
         this.reset();
         view.setVisible(true);
     }
}
