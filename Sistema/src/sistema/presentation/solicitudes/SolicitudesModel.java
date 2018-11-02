/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitudes;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import sistema.Application;
import sistema.logic.Bien;
import sistema.logic.Solicitud;

/**
 *
 * @author leaca
 */
public class SolicitudesModel extends java.util.Observable{
    Solicitud filter;
    SolicitudesTableModel solicitudes;
    BienesTableModel bienes;
    int modo;

    public SolicitudesModel() {
        this.reset();
    }
    
    public void reset(){ 
        filter = new Solicitud();
        List<Solicitud> rows = new ArrayList<>();  
        List<Bien> bienes = new ArrayList<>();
        this.setModo(Application.AGREGAR, filter);
        this.setSolicitudes(rows);
        this.setBienes(bienes);
        this.commit();
    }

    public void setModo(int modo, Solicitud actual) {
        this.modo = modo;
        this.setFilter(actual);
        this.commit();
    }
    
    public Solicitud getFilter() {
        return filter;
    }

    public void setFilter(Solicitud filter) {
        this.filter = filter;
    }

    public SolicitudesTableModel getSolicitudes() {
        return solicitudes;
    }
    public BienesTableModel getBienes(){
        return bienes;
    }

    public void setSolicitudes(List<Solicitud> estados) {
        int[] cols={SolicitudesTableModel.ID,SolicitudesTableModel.COMPROBANTE,SolicitudesTableModel.DEPENDENCIA,SolicitudesTableModel.REGISTRADOR,SolicitudesTableModel.ESTADO};
        this.solicitudes =new SolicitudesTableModel(cols,estados);  
        this.commit();
    }    
    
    public void setBienes(List<Bien> bienes){
        int[] cols={BienesTableModel.SOLICITUD, BienesTableModel.MODELO, BienesTableModel.MARCA, BienesTableModel.PRECIO, BienesTableModel.CANTIDAD, BienesTableModel.DESCRIPCION};
        this.bienes = new BienesTableModel(bienes, cols);  
        this.commit();
    }
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public void commit(){
        setChanged();
        notifyObservers();       
    }      
}
