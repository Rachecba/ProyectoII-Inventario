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
import sistema.logic.Bien;
import sistema.logic.Categoria;
import sistema.logic.Comprobante;
import sistema.logic.Funcionario;
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
        this.solicitudesModel.inicializaCategorias(mainModel.getCategoriasBox());
        
        this.solicitudesView.setController(this);
        this.solicitudesView.setModel(solicitudesModel);
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
        
        if(!this.permisoRegistrador()){ //si es registrador
            Usuario usuario = (Usuario) sesion.getAttribute("Usuario");
            Funcionario funcionario = usuario.getUsuarioFuncionario();
            
            List<Solicitud> solicitudes = mainModel.buscarSolicitudRegistrador(solicitudesModel.getFiltro(), funcionario);
            solicitudesModel.setTable(solicitudes);
            solicitudesModel.notificar();
            
            if(solicitudes.isEmpty())
                throw new Exception("Solicitud no encontrada");
        }
        else{
            if(this.permisoSecretario()){ //es un secretario
                
                List<Solicitud> solicitudes = mainModel.buscarSolicitudesSecretario(solicitudesModel.getFiltro());
                solicitudesModel.setTable(solicitudes);
                solicitudesModel.notificar();
                
                if(solicitudes.isEmpty())
                    throw new Exception("Solicitud no encontrada");
            }
            else{ //es un administrador
                
                List<Solicitud> solicitudes = mainModel.buscarSolicitudes(solicitudesModel.getFiltro());
                solicitudesModel.setTable(solicitudes);
                solicitudesModel.notificar();
                
                if(solicitudes.isEmpty())
                    throw new Exception("Solicitud no encontrada");
            }
        }
        
//        if(solicitudes.isEmpty())
//             throw new Exception("No existen solicitudes.");      
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
    
    public void buscarBienes(int fila) throws Exception{
         Solicitud solicitud = solicitudesModel.getSolicitudes().getRowAt(fila);
         Comprobante comprobante = solicitud.getSolicitudComprobante();
         this.setTablaBienes(comprobante);
        
    }
    
    public void setTablaBienes(Comprobante comprobante) throws Exception{
         List<Bien> bienes = mainModel.buscarBienes(comprobante);
         this.solicitudesModel.setBienes(bienes);
         this.solicitudesModel.notificar();
         
         
         if(this.solicitudesModel.getModo() == Application.EDITAR && bienes.isEmpty())
             throw new Exception("Bienes no encontrados");
     }
     
    public void changeEstado(int fila, String estado, String rechazo) throws Exception{
        Solicitud solicitud = this.solicitudesModel.getSolicitudes().getRowAt(fila);
        solicitud.setSolicitudEstado(estado);
        solicitud.setSolicitudDescripcionDeRechazo(rechazo);
        
        try{
            mainModel.cambiarEstadoSolicitud(solicitud);
        }catch(Exception e){}
        
        this.setTablaSolicitudes();
    }
    
    public Solicitud getSolicitud(int fila){
        return this.solicitudesModel.getSolicitudes().getRowAt(fila);
    }
    
    public void setTablaSolicitudes(/*Dependencia dependencia*/) throws Exception{
//         List<Labor> labores = mainModel.buscarLabores(dependencia);
//         mainModel.setFuncionariosTable(labores);
//         mainModel.notificar();
//         
//         
//         if(mainModel.getModo() == Application.EDITAR && labores.isEmpty())
//             throw new Exception("Funcionarios no encontrados");
     }

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
        Usuario principal = (Usuario) sesion.getAttribute("Usuario"); //si es true, no es registrador, si es false si es registrador
       
        if (!Arrays.asList(Application.REGISTRADOR_BIENES).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de registrador de bienes
            return true;
        }
        else
            return false;
    } 
    
    public boolean permisoSecretario(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario"); //si es secretaria es true, si no es, es false
       
        if (Arrays.asList(Application.SECRETARIA).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es secretaria
            return true;
        }
        else
            return false;
    }
    
    public boolean getSession(){
        if(sesion.getAttribute("Usuario") == null)
            return false;
        else
            return true;
    }
    
    public void setModo(int modo, int fila){
         Solicitud seleccionada = solicitudesModel.getSolicitudes().getRowAt(fila);
         this.solicitudesModel.setModo(modo, seleccionada);
     }
    
    public void asignarCategoria(int fila, Categoria categoria, int filaSolicitud) throws Exception{
        Bien bien = this.solicitudesModel.getBienes().getRowAt(fila);
        Solicitud solicitud = solicitudesModel.getSolicitudes().getRowAt(filaSolicitud);
        Comprobante comprobante = solicitud.getSolicitudComprobante();
        
        try{
            mainModel.asignarCategoria(bien, categoria);
        }catch(Exception e){}
        
        this.setTablaBienes(comprobante);
    }
    
    public void incorporarBienes(int fila){
        Solicitud solicitud = this.solicitudesModel.getSolicitudes().getRowAt(fila);
        this.mainModel.incorporarBienes(solicitud);
        
    }
}
