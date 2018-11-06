
package sistema.presentation.activos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sistema.Application;
import sistema.logic.ActivoUniversitario;
import sistema.logic.Dependencia;
import sistema.logic.Funcionario;
import sistema.logic.Labor;

/**
 *
 * @author Rachel
 */
public class ActivosModel extends java.util.Observable{
    String filtro;
    ActivosTableModel activosTable;
    ComboBoxModel<Labor> labores;
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
     
     public ComboBoxModel<Labor> getLabores() {
         return labores;
     }
     
     public void inicializaLabores(List<Labor> labores){
        this.setLabores(labores);
    }
     
     public void setLabores(List<Labor> labores) {
        this.labores = new DefaultComboBoxModel(labores.toArray());
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

       @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.notificar();   
    }
}
