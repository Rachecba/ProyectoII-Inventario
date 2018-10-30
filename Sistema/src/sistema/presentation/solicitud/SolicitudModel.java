/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitud;

import sistema.presentation.solicitudes.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import sistema.logic.Solicitud;

/**
 *
 * @author leaca
 */
public class SolicitudModel extends java.util.Observable{
    Solicitud filter;
    SolicitudesTableModel solicitudes;

    public SolicitudModel() {
        this.reset();
    }
    
    public void reset(){ 
        filter = new Solicitud();
        List<Solicitud> rows = new ArrayList<>();   
        this.setSolicitudes(rows);
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

    public void setSolicitudes(List<Solicitud> estados) {
        int[] cols={SolicitudesTableModel.ID,SolicitudesTableModel.COMPROBANTE,SolicitudesTableModel.DEPENDENCIA,SolicitudesTableModel.REGISTRADOR,SolicitudesTableModel.ESTADO};
        this.solicitudes =new SolicitudesTableModel(cols,estados);  
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
