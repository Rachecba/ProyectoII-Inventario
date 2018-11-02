/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitud;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import sistema.Sesion;
import sistema.logic.Bien;
import sistema.logic.Model;
import sistema.logic.Solicitud;

/**
 *
 * @author Rachel
 */
public class SolicitudController {
    
    Model mainModel;
    Sesion sesion;   
    SolicitudView solicitudView;
    SolicitudModel solicitudModel;
    
    public SolicitudController(SolicitudView solicitudView, SolicitudModel solicitudModel, Model mainModel,Sesion sesion) {
        this.mainModel= mainModel;
        this.sesion=sesion;
        
        this.solicitudView = solicitudView;
        this.solicitudModel = solicitudModel;
        solicitudView.setController(this);
        solicitudView.setModel(solicitudModel);
    }
    
    public void buscar(Solicitud filter) throws Exception{
        solicitudModel.setFilter(filter);
        this.buscar();        
    }
    
    public void buscar() throws Exception{        
        List<Solicitud> rows = new ArrayList(mainModel.searchSolicitud(solicitudModel.getFilter()));
        solicitudModel.setSolicitudes(rows);
        solicitudModel.commit();
        if (rows.isEmpty()) throw new Exception("Ningún dato coincide");        
    }

//    public void agregarSolicitud(Solicitud solicitud) throws Exception{
//        mainModel.agregarSolicitud(solicitud);
//        //this.setTabla();
//    }
//    
    public void agregarBien(Bien bien) throws Exception{
        //mainModel.agregarBien(bien);
        this.setTablaBienes();
    }
    
    public void setTablaBienes() throws Exception{
//        List<Bien> bienes = mainModel.buscarBienes();
//        solicitudModel.setTable(bienes);
//        solicitudModel.notificar();
        
//        if(bienes.isEmpty())
//            throw new Exception("Bien no encontrado");
    }
    
    public void editar(int row, Point at){
//        EstadoCivil seleccionada = solicitudModel.getEstados().getRowAt(row); 
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
//        Persona seleccionada = solicitudModel.getPersonas().getRowAt(row); 
//        try {
//            mainModel.deletePersona(seleccionada);
//        } catch (Exception ex) { }
//        List<Persona> rowsMod = mainModel.searchPersonas(solicitudModel.getFilter());
//        solicitudModel.setPersonas(rowsMod);
//        solicitudModel.commit();
    }
    
    public void cancelarSolicitud(int row){
    
    }

    public void reset(){
        solicitudModel.reset();
    }
    
    public void show(){
        solicitudView.setVisible(true);
    }

    public void show(Point position){
        solicitudView.setLocation(position);
        this.show();
    }   
    
    public void ocultar(){
        solicitudView.setVisible(false);
    }  
    
    public void borrarBien(int row){
    
    }
}
