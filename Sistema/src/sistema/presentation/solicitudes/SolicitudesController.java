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
//import org.eclipse.persistence.sessions.Session; //esto?
import sistema.logic.Model;
import sistema.logic.Solicitud;
import sistema.Sesion;
import sistema.logic.Usuario;

/**
 *
 * @author Rachel
 */
public class SolicitudesController {
    
    Model domainModel;
    Sesion session;   
    SolicitudesView view;
    SolicitudesModel model;
    
    public SolicitudesController(SolicitudesView view, SolicitudesModel model, Model domainModel,Sesion session) {
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(Solicitud filter) throws Exception{
        model.setFilter(filter);
        model.setModo(Application.AGREGAR, filter);
    //    this.setTablaSolicitudes(new Solicitud());
 //       this.setTablaBienes();
//        this.buscar();        
    }
    
    public void buscar() throws Exception{        
//        List<Solicitud> rows = new ArrayList(domainModel.searchSolicitud(model.getFilter()));
//        model.setSolicitudes(rows);
//        model.commit();
//        if (rows.isEmpty()) throw new Exception("Ningún dato coincide");    

    }

    public void preAgregar(Point at) throws Exception{
//        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
//        if ( !Arrays.asList(Application.ROL_MANAGER).contains(principal.getRol())){
//           throw new Exception(Application.ROL_NOTAUTHORIZED);
//        }
//        Application.PERSONA_CONTROLLER.reset(Application.MODO_AGREGAR, new Persona());
//        Application.PERSONA_CONTROLLER.show(at);
    }
    
    public void editar(int row, Point at){
//        EstadoCivil seleccionada = model.getEstados().getRowAt(row); 
//        Usuario principal = (Usuario) session.getAttribute(Application.USER_ATTRIBUTE);
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
//        Persona seleccionada = model.getPersonas().getRowAt(row); 
//        try {
//            domainModel.deletePersona(seleccionada);
//        } catch (Exception ex) { }
//        List<Persona> rowsMod = domainModel.searchPersonas(model.getFilter());
//        model.setPersonas(rowsMod);
//        model.commit();
    }
    
    public void cancelarSolicitud(int row){
    
    }
    
//    public void setTablaSolicitudes(Dependencia dependencia) throws Exception{
//         List<Labor> labores = mainModel.buscarLabores(dependencia);
//         model.setFuncionariosTable(labores);
//         model.notificar();
//         
//         
//         if(model.getModo() == Application.EDITAR && labores.isEmpty())
//             throw new Exception("Funcionarios no encontrados");
//     }

    public void reset(){
        model.reset();
    }
    
    public void show(){
        view.setVisible(true);
    }

    public void show(Point position){
        view.setLocation(position);
        this.show();
    }   
    
    public void ocultar(){
        view.setVisible(false);
    }  
    
    public boolean permisoRegistrador(){
        Usuario principal = (Usuario) session.getAttribute("Usuario");
        if ( !Arrays.asList(Application.REGISTRADOR_BIENES).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de registrador de bienes
            return false;
        }
        else
            return true;
    } 
    
    public boolean getSession(){
        if(session.getAttribute("Usuario") == null)
            return false;
        else
            return true;
    }
    
    public void setModo(int modo, int fila){
         Solicitud seleccionada = model.getSolicitudes().getRowAt(modo);
         this.model.setModo(modo, seleccionada);
     }
    
}
