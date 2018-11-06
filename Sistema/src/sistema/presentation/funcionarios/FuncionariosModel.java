/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.funcionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sistema.Application;
import sistema.logic.Dependencia;
import sistema.logic.Funcionario;

/**
 *
 * @author Rachel
 */
public class FuncionariosModel extends Observable {
    Funcionario filtro;
    FuncionariosTableModel table;
    int modo;
    
    public FuncionariosModel(){
        this.inicializa();
    }
    
//     public void reset(){
//        this.inicializa();
//    }

   
    public void inicializa(){
        filtro = new Funcionario();
        List<Funcionario> funcionarios = new ArrayList<>();
        //seleccionado = null;
        this.setModo(Application.AGREGAR, filtro);
        this.setTable(funcionarios);
        this.notificar();
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo, Funcionario actual) {
        this.modo = modo;
        this.setFiltro(actual);
        this.notificar();
    }
    
    public FuncionariosTableModel getTable() {
        return table;
    }
   
    public void setTable(List<Funcionario> funcionarios){
        int[] columnas = {FuncionariosTableModel.CEDULA, FuncionariosTableModel.NOMBRE};
        table = new FuncionariosTableModel(funcionarios, columnas); //creo de nuevo la tabla.
    }

    public Funcionario getFiltro() {
        return filtro;
    }

    public void setFiltro(Funcionario filtro) {
        this.filtro = filtro;
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
