/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitud;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import sistema.logic.Bien;

/**
 *
 * @author leaca
 */
public class SolicitudModel extends java.util.Observable{
    BienTableModel bienTableModel;
    

    public SolicitudModel() {
        inicializa();
    }
    
    public void inicializa(){
        //Bien
        List<Bien> bienes = new ArrayList<>();
        this.setBienTableModel(bienes);
        this.notificar();
    }
    
    //BIEN
    
    public BienTableModel getBienTableModel() {
        return bienTableModel;
    }

    public void setBienTableModel(List<Bien> bienes) {
        int[] columnas = {BienTableModel.DESCRIPCION,BienTableModel.MARCA,BienTableModel.MODELO,BienTableModel.CANTIDAD,BienTableModel.PRECIO};
        bienTableModel = new BienTableModel(columnas,bienes);
    }
    
    //SOLICITUD
    
    
    
    //GENERAL
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public void commit(){
        setChanged();
        notifyObservers();       
    }     
    
    public void notificar(){
        setChanged();
        notifyObservers();
    }
}
