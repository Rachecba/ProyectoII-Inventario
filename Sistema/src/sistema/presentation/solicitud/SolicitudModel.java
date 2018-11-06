/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitud;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sistema.logic.Bien;
import sistema.logic.Dependencia;
import sistema.logic.TipoDeAdquisicion;

/**
 *
 * @author leaca
 */
public class SolicitudModel extends java.util.Observable{
    BienTableModel bienTableModel;
    ComboBoxModel<TipoDeAdquisicion> tiposDeAdquisicion;
    ComboBoxModel<Dependencia> dependencias;

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
    
    public void inicializarBienes(List<Bien> bienes){
        this.setBienTableModel(bienes);
    }
    
    //SOLICITUD
    
    
    
    //TIPO DE ADQUISICION
    
    public void inicializarTiposDeAdquisicion(List<TipoDeAdquisicion> tiposDeAdquisicion){
        this.setTiposDeAdquisicion(tiposDeAdquisicion);
    }
    
    public ComboBoxModel<TipoDeAdquisicion> getTiposDeActivo(){
        return tiposDeAdquisicion;
    }

    public void setTiposDeAdquisicion(List<TipoDeAdquisicion> tiposDeAdquisicion) {
        this.tiposDeAdquisicion = new DefaultComboBoxModel(tiposDeAdquisicion.toArray());
        this.notificar();
    }
    
    //DEPENDENCIA
    
    public void inicializarDependencias(List<Dependencia> dependencias){
        this.setDependencias(dependencias);
    }
    
    public ComboBoxModel<Dependencia> getDependencias(){
        return dependencias;
    }

    public void setDependencias(List<Dependencia> dependencias) {
        this.dependencias = new DefaultComboBoxModel(dependencias.toArray());
        this.notificar();
    }
    
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
