/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.articulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import sistema.Application;
import sistema.logic.Categoria;

/**
 *
 * @author Rachel
 */
public class ArticulosModel extends Observable{
    
    ArticulosTableModel articulosTable;
    int modo;
    Categoria filtro;
    
    public ArticulosModel(){
        this.inicializa();
    }
    
    public void inicializa(){
        filtro = new Categoria();
        List<Categoria> categorias = new ArrayList<>();
        this.setModo(Application.AGREGAR, filtro);
        this.setTable(categorias);
        this.notificar();
    }
    
    public void notificar(){
         setChanged();
         notifyObservers();
     }
    
    public void setModo(int modo, Categoria actual) {
        this.modo = modo;
        this.setFiltro(actual);
        this.notificar();
    }
    
    public int getModo(){
        return this.modo;
    }

    public void setTable(List<Categoria> categorias) {
        int[] columnas = {ArticulosTableModel.NOMBRE, ArticulosTableModel.DESCRIPCION};
        articulosTable = new ArticulosTableModel(categorias, columnas); 
    }
    
    public ArticulosTableModel getTable(){
        return articulosTable;
    }
    
    public void setFiltro(Categoria categoria){
        this.filtro = categoria;
    }
    
    public Categoria getFiltro(){
        return this.filtro; 
    }
    
    
}
