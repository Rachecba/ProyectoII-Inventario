    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitudes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.Application;
import sistema.logic.Model;
import sistema.logic.Solicitud;
import sistema.Sesion;
import sistema.logic.Usuario;

/**
 *
 * @author Rachel
 */
public class SolicitudesController {
    
    Model mainModel;
    Sesion sesion;   
    SolicitudesView solicitudesView;
    SolicitudesModel solicitudesModel;
    
    public SolicitudesController(SolicitudesModel solicitudesModel, SolicitudesView solicitudesView, Model mainModel,Sesion sesion) {
        this.mainModel= mainModel;
        this.sesion=sesion;
        
        this.solicitudesView = solicitudesView;
        this.solicitudesModel = solicitudesModel;
        solicitudesView.setController(this);
        solicitudesView.setModel(solicitudesModel);
    }
    
    public void buscar(Solicitud filter) throws Exception{
        solicitudesModel.setFiltro(filter);
        this.buscar();        
    }
    
    public void buscarTodos() throws Exception{
         Solicitud solicitud = new Solicitud();
         solicitudesModel.setFiltro(solicitud);
         this.buscar();
     }
    
    public void buscar() throws Exception{        
        List<Solicitud> solicitudes = mainModel.buscarSolicitudes(solicitudesModel.getFiltro());
         solicitudesModel.setTable(solicitudes);
         solicitudesModel.notificar();
        
        if(solicitudes.isEmpty())
             throw new Exception("Funcionario no encontrado");      
    }

    public void preAgregar(Point at) throws Exception{
//        Usuario principal = (Usuario) sesion.getAttribute(Application.USER_ATTRIBUTE);
//        if ( !Arrays.asList(Application.ROL_MANAGER).contains(principal.getRol())){
//           throw new Exception(Application.ROL_NOTAUTHORIZED);
//        }
//        Application.PERSONA_CONTROLLER.reset(Application.MODO_AGREGAR, new Persona());
//        Application.PERSONA_CONTROLLER.show(at);
    }
    
    public void editar(int row, Point at){
//        EstadoCivil seleccionada = solicitudesModel.getEstados().getRowAt(row); 
//        Usuario principal = (Usuario) sesion.getAttribute(Application.USER_ATTRIBUTE);
//        int modo;
//        if ( Arrays.asList(Application.ROL_MANAGER, Application.ROL_SUPERVISOR).contains(principal.getRol())){
//            modo=Application.MODO_EDITAR;
//        }
//        else{
//            modo=Application.MODO_CONSULTAR;            
//        }
//        Application.PERSONA_CONTROLLER.reset(modo, principal);
//        Application.PERSONA_CONTROLLER.show(at);
     }

    public void borrar(int row){
//        Persona seleccionada = solicitudesModel.getPersonas().getRowAt(row); 
//        try {
//            mainModel.deletePersona(seleccionada);
//        } catch (Exception ex) { }
//        List<Persona> rowsMod = mainModel.searchPersonas(solicitudesModel.getFilter());
//        solicitudesModel.setPersonas(rowsMod);
//        solicitudesModel.commit();
    }
    
    public void cancelarSolicitud(int row){
    
    }
    
//    public void setTablaSolicitudes(Dependencia dependencia) throws Exception{
//         List<Labor> labores = mainModel.buscarLabores(dependencia);
//         mainModel.setFuncionariosTable(labores);
//         mainModel.notificar();
//         
//         
//         if(mainModel.getModo() == Application.EDITAR && labores.isEmpty())
//             throw new Exception("Funcionarios no encontrados");
//     }

    public void reset(){
        solicitudesModel.reset();
    }

    public void show(Point position){
        solicitudesView.setLocation(position);
        this.mostrar();
    }   
    
    public void ocultar(){
        solicitudesView.setVisible(false);
    } 
    
    public void mostrar(){
        solicitudesView.setVisible(true);
     }
    
    public boolean permisoRegistrador(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario");
        if ( !Arrays.asList(Application.REGISTRADOR_BIENES).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de registrador de bienes
            return false;
        }
        else
            return true;
    } 
    
    public boolean getSession(){
        if(sesion.getAttribute("Usuario") == null)
            return false;
        else
            return true;
    }
    
    public void setModo(int modo, int fila){
         Solicitud seleccionada = solicitudesModel.getSolicitudes().getRowAt(modo);
         this.solicitudesModel.setModo(modo, seleccionada);
     }
    
}
