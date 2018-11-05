
package sistema.presentation.dependencias;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sistema.Application;
import sistema.logic.Dependencia;
import sistema.logic.Funcionario;
import sistema.logic.Labor;
import sistema.logic.Puesto;

/**
 *
 * @author Rachel
 */
public class DependenciasModel extends Observable{
    DependenciasTableModel dependenciasTable;
    FuncionariosTableModel funcionariosTable;
    ComboBoxModel<Funcionario> funcionarios;
    ComboBoxModel<Puesto> puestos;
    int modo;
    Dependencia filtro;
    
    public DependenciasModel(){
        this.inicializa();
    }
    
     public void inicializa(){
        filtro = new Dependencia();
        List<Dependencia> dependencias = new ArrayList<>();
        List<Labor> labores = new ArrayList<>();
        //seleccionado = null;
        this.setModo(Application.AGREGAR, filtro);
        this.setFuncionariosTable(labores);
        this.setDependenciasTable(dependencias);
        this.notificar();
    }
     
     public void notificar(){
         setChanged();
         notifyObservers();
     }
     
     public void inicializaFuncionarios(List<Funcionario> funcionarios){
        this.setFuncionarios(funcionarios);
        this.setFiltro(new Dependencia());
    }
     
     public void inicializaPuestos(List<Puesto> puestos){
         this.setPuestos(puestos);
     }
     
     public void setModo(int modo, Dependencia actual) {
        this.modo = modo;
        this.setFiltro(actual);
        this.notificar();
    }

    public DependenciasTableModel getDependenciasTable() {
        return dependenciasTable;
    }

    public FuncionariosTableModel getFuncionariosTable() {
        return funcionariosTable;
    }

    public ComboBoxModel<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public ComboBoxModel<Puesto> getPuestos(){
        return puestos;
    }

    public int getModo() {
        return modo;
    }

    public Dependencia getFiltro() {
        return filtro;
    }

    public void setDependenciasTable(List<Dependencia> dependencias) {
        int[] columnas = {DependenciasTableModel.NOMBRE, DependenciasTableModel.ADMINISTRADOR};
        dependenciasTable = new DependenciasTableModel(dependencias, columnas); 
    }

    public void setFuncionariosTable(List<Labor> labores) {
        int[] columnas = {FuncionariosTableModel.PUESTO, FuncionariosTableModel.FUNCIONARIO};
        funcionariosTable = new FuncionariosTableModel(labores, columnas); 
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = new DefaultComboBoxModel(funcionarios.toArray());
        this.notificar();
    }
    
    public void setPuestos(List<Puesto> puestos){
        this.puestos = new DefaultComboBoxModel(puestos.toArray());
        this.notificar();
    }

    public void setFiltro(Dependencia filtro) {
        this.filtro = filtro;
    }
     
      @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.notificar();   
    }
}
