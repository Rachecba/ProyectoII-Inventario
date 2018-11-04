/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitud;

import java.awt.Point;
import java.util.List;
import sistema.Sesion;
import sistema.logic.Bien;
import sistema.logic.Model;

/**
 *
 * @author Rachel
 */
public class SolicitudController {
    
    Model mainModel;
    Sesion sesion;   
    SolicitudView solicitudView;
    SolicitudModel solicitudModel;
    
    public SolicitudController(SolicitudModel solicitudModel, SolicitudView solicitudView, Model mainModel,Sesion sesion) {
        this.mainModel= mainModel;
        this.sesion=sesion;
        
        this.solicitudView = solicitudView;
        this.solicitudModel = solicitudModel;
        solicitudView.setController(this);
        solicitudView.setModel(solicitudModel);
    }
    
    //BIEN
    
    public void setTablaBienes() throws Exception{
        List<Bien> bienes = mainModel.buscarNuevosBienes();
        solicitudModel.setBienTableModel(bienes);
        solicitudModel.notificar();
    }

    public void agregarBien(Bien bien) throws Exception{
        mainModel.agregarBien(bien);
        this.setTablaBienes();
    }
    
    public void editarBien(int row, Point at){
    
    }

    public void borrarBien(int row){
    
    }
    
    //SOLICITUD
    
    public void cancelarSolicitud(int row){
    
    } 
    
    public void crearSolicitud(int row){
    
    } 
    
    public void editarSolicitud(int row){
    
    } 
    
    //GENERAL
    
    public void mostrar(){
        solicitudView.setVisible(true);
    }

    public void show(Point position){
        solicitudView.setLocation(position);
        this.mostrar();
    }   
    
    public void ocultar(){
        solicitudView.setVisible(false);
    } 

}
