
package sistema.presentation.activos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sistema.Application;
import sistema.logic.ActivoUniversitario;
import sistema.logic.Dependencia;
import sistema.logic.Funcionario;

/**
 *
 * @author Rachel
 */
public class ActivosModel extends java.util.Observable{
    String filtro;
    ActivosTableModel activosTable;
    ComboBoxModel<Funcionario> funcionarios;
    ComboBoxModel<Dependencia> dependencias;
    int modo;
    
     public ActivosModel(){
        this.inicializa();
    }
    
     public void inicializa(){
        filtro = "";
        List<ActivoUniversitario> activos = new ArrayList<>();
        //seleccionado = null;
        this.setModo(Application.AGREGAR, filtro);
        this.setTable(activos);
        this.notificar();
    }
     
    public ComboBoxModel<Funcionario> getFuncionarios() {
        return funcionarios;
    }
     
     public void inicializaFuncionarios(List<Funcionario> funcionarios){
        this.setFuncionarios(funcionarios);
    }
     
     public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = new DefaultComboBoxModel(funcionarios.toArray());
        this.notificar();
    }
     
    public ComboBoxModel<Dependencia> getDependencias() {
        return dependencias;
    }
     
     public void inicializaDependencias(List<Dependencia> dependencias){
        this.setDependencias(dependencias);
    }
     
     public void setDependencias(List<Dependencia> dependencias) {
        this.dependencias = new DefaultComboBoxModel(dependencias.toArray());
        this.notificar();
    }
     
     public void notificar(){
         setChanged();
         notifyObservers();
     }
     
     public void setModo(int modo, String actual) {
        this.modo = modo;
        this.setFiltro(actual);
        this.notificar();
    }
     
     public int getModo() {
        return modo;
    }
     
     public String getFiltro() {
        return filtro;
    }
     
     public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
     
      public ActivosTableModel getActivos() {
        return activosTable;
    }
     
     public void setTable(List<ActivoUniversitario> activos) {
        int[] columnas = {ActivosTableModel.CODIGO, ActivosTableModel.CATEGORIA, ActivosTableModel.DESCRIPCION, ActivosTableModel.DEPENDENCIA, ActivosTableModel.RESPONSABLE};
        activosTable = new ActivosTableModel(activos, columnas); 
    }

}
