/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitudes;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import sistema.logic.Solicitud;

/**
 *
 * @author leaca
 */
public class SolicitudesModel extends java.util.Observable{
    Solicitud filtro;
    SolicitudesTableModel solicitudes;

    public SolicitudesModel() {
        this.reset();
    }
    
    public void reset(){ 
        filtro = new Solicitud();
        List<Solicitud> rows = new ArrayList<>();   
        this.setTable(rows);
        this.notificar();
    }

    public Solicitud getFiltro() {
        return filtro;
    }

    public void setFiltro(Solicitud filtro) {
        this.filtro = filtro;
    }

    public SolicitudesTableModel getSolicitudes() {
        return solicitudes;
    }

    public void setTable(List<Solicitud> estados) {
        int[] cols={SolicitudesTableModel.ID,SolicitudesTableModel.COMPROBANTE,SolicitudesTableModel.DEPENDENCIA,SolicitudesTableModel.REGISTRADOR,SolicitudesTableModel.ESTADO};
        this.solicitudes =new SolicitudesTableModel(cols,estados);  
    }    
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.notificar();
    }

    public void notificar(){
        setChanged();
        notifyObservers();       
    }      
}
