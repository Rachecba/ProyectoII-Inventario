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
        
        this.solicitudesView.inicializaPantalla();
        this.solicitudesModel.inicializarFuncionarios(this.mainModel.getFuncionariosBox());
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
            throw new Exception("No existen solicitudes.");
    }
    
    public void cancelarSolicitud(int row){
        Solicitud seleccionado = solicitudesModel.getSolicitudes().getRowAt(row);
        
        try{
            mainModel.cancelarSolicitud(seleccionado);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public Solicitud Solicitud(int row){
        return solicitudesModel.getSolicitudes().getRowAt(row);
    }
    
    public void editarSolicitud(Solicitud solicitud){
        mainModel.agregarSolicitud(solicitud);
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
