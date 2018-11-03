/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitudes;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sistema.Application;
import sistema.logic.Bien;
import sistema.logic.Categoria;
import sistema.logic.Solicitud;

/**
 *
 * @author leaca
 */
public class SolicitudesModel extends java.util.Observable{
    Solicitud filtro;
    SolicitudesTableModel solicitudes;
    BienesTableModel bienes;
    ComboBoxModel<Categoria> categorias;
    int modo;

    public SolicitudesModel() {
        this.reset();
    }
    
        public void reset(){ 
        filtro = new Solicitud();
        List<Solicitud> rows = new ArrayList<>();  
        List<Bien> bienes = new ArrayList<>();
        this.setModo(Application.AGREGAR, filtro);
        this.setTable(rows);
        this.setBienes(bienes);
        this.notificar();
    }
    
    public void inicializaCategorias(List<Categoria> categorias){
        this.setCategorias(categorias);
    }
    
    public void setCategorias(List<Categoria> categorias){
        this.categorias = new DefaultComboBoxModel(categorias.toArray());
        this.notificar();
    }
    
    public ComboBoxModel<Categoria> getCategorias(){
        return categorias;
    }
    
    public Solicitud getFilter() {
        return filtro;
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
    
    public BienesTableModel getBienes(){
        return bienes;
    }

    public void setTable(List<Solicitud> estados) {
        int[] cols={SolicitudesTableModel.ID,SolicitudesTableModel.COMPROBANTE,SolicitudesTableModel.DEPENDENCIA,SolicitudesTableModel.REGISTRADOR,SolicitudesTableModel.ESTADO};
        this.solicitudes =new SolicitudesTableModel(cols,estados);  
    }    
    
    public void setBienes(List<Bien> bienes){
        int[] cols={BienesTableModel.SOLICITUD, BienesTableModel.MODELO, BienesTableModel.MARCA, BienesTableModel.PRECIO, BienesTableModel.CANTIDAD, BienesTableModel.DESCRIPCION};
        this.bienes = new BienesTableModel(bienes, cols);  
    }
    
   public int getModo() {
        return modo;
    }
   
   public void setModo(int modo, Solicitud actual) {
        this.modo = modo;
        this.setFiltro(actual);
        this.notificar();
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
