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
import sistema.logic.Comprobante;
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
    
    public SolicitudController(SolicitudModel solicitudModel, SolicitudView solicitudView, Model mainModel,Sesion sesion) {
        this.mainModel= mainModel;
        this.sesion=sesion;
        
        this.solicitudView = solicitudView;
        this.solicitudModel = solicitudModel;
        
        this.solicitudModel.inicializarTiposDeAdquisicion(this.mainModel.getTipoDeAdquisicionBox());
        this.solicitudModel.inicializarDependencias(this.mainModel.getDependenciasBox());
        
        this.solicitudView.setController(this);
        this.solicitudView.setModel(solicitudModel);
//        this.solicitudModel.inicializarBienes(new ArrayList<>());
    }
    
    //BIEN
    
    public void setTablaBienes() throws Exception{
        List<Bien> bienes = mainModel.buscarNuevosBienes();
        solicitudModel.setBienTableModel(bienes);
        solicitudModel.notificar();
    }

    public boolean agregarBien(Bien bien) throws Exception{
        return mainModel.agregarBien(bien);
    }

    public void borrarBien(int row){
        Bien seleccionado = solicitudModel.getBienTableModel().getRowAt(row);
        
        try{
            mainModel.borrarBien(seleccionado);
        }catch(Exception ex){ throw ex; }
        
        List<Bien> lista = mainModel.buscarNuevosBienes();
        this.solicitudModel.setBienTableModel(lista);
        this.solicitudModel.notificar();
    }
    
    public void asignarBienes(Solicitud solicitud){
        for(Bien b : mainModel.buscarNuevosBienes()){
            b.setBienComprobante(solicitud.getSolicitudComprobante());
            mainModel.agregarBien(b);
        }
    }
    
    public void borrarBienesNoAsignados(){
        for(Bien b : mainModel.buscarNuevosBienes()){
            mainModel.borrarBien(b);
        }
    }
    
    //SOLICITUD
    
    public void cancelarSolicitud(){
        solicitudView.setVisible(false);
    } 
    
    public void crearSolicitud(Solicitud solicitud){
        mainModel.agregarSolicitud(solicitud);
    }
    
    //COMPROBANTE
    
    public Comprobante crearComprobante(Comprobante comprobante){
        return mainModel.agregarComprobante(comprobante);
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
    
    public void refrescarPantalla(){
        solicitudView.inicializaPantalla();
    }

}
