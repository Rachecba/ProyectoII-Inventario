/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.funcionarios;

import java.util.ArrayList;
import java.util.List;
import sistema.Application;
import sistema.Sesion;
import sistema.logic.Dependencia;
import sistema.logic.Funcionario;
import sistema.logic.Model;

/**
 *
 * @author Rachel
 */
public class FuncionariosController {
    Model mainModel;
    Sesion sesion;
    FuncionariosModel funcionariosModel;
    FuncionariosView funcionariosView;
    
    public FuncionariosController(FuncionariosModel fm, FuncionariosView fv, Model mm, Sesion s){
        funcionariosModel = fm;
        mainModel = mm;
        this.funcionariosModel.inicializaDependencias(mainModel.getDependenciasBox());
        funcionariosView = fv;
        sesion = s;
        
        funcionariosView.setController(this);
        funcionariosView.setModel(fm);
    }
    
     public void ocultar(){
        funcionariosView.setVisible(false);
    }
     
     public void mostrar(){
         funcionariosView.setVisible(true);
     }
     
     public void setModo(int modo, int fila){
         Funcionario seleccionado = funcionariosModel.getTable().getRowAt(fila);
         this.funcionariosModel.setModo(modo, seleccionado);
     }
     
     public void agregar(Funcionario funcionario, Dependencia dependencia) throws Exception{
         
         switch(this.funcionariosModel.getModo()){
             case Application.AGREGAR:
                 mainModel.agregarFuncionario(funcionario);
                 this.funcionariosModel.setFiltro(funcionario);
                 this.funcionariosModel.setModo(Application.AGREGAR, funcionario);
                 this.setTabla(dependencia);
                 
             case Application.EDITAR:
                 mainModel.agregarFuncionario(funcionario);
                 this.funcionariosModel.setModo(Application.AGREGAR, funcionario);
                 this.setTabla(dependencia);
         }
         
     }
     
     public void editar(int fila, Dependencia dependencia) throws Exception{
         Funcionario seleccionado = funcionariosModel.getTable().getRowAt(fila);
         this.funcionariosModel.setModo(Application.EDITAR, seleccionado);
         this.funcionariosModel.setFiltro(seleccionado);
         this.funcionariosModel.notificar();
         this.setTabla(dependencia);
     }
     
     public void borrar(int fila, Dependencia dependencia) throws Exception{
         Funcionario seleccionado = funcionariosModel.getTable().getRowAt(fila);
         
         try{
             mainModel.eliminarFuncionario(seleccionado, dependencia);
         }catch(Exception ex){ throw ex; }
         
         List<Funcionario> lista = mainModel.buscarFuncionarios(funcionariosModel.getFiltro(), dependencia);
         this.funcionariosModel.setTable(lista);
         this.funcionariosModel.notificar();
     }
     
     public void buscar(Funcionario funcionario, Dependencia dependencia) throws Exception{
         funcionariosModel.setFiltro(funcionario);
         this.funcionariosModel.setModo(Application.AGREGAR, funcionario);
         this.setTabla(dependencia);
     }
     
     public void buscarTodos(Dependencia dependencia) throws Exception{
         Funcionario funcionario = new Funcionario();
         funcionariosModel.setFiltro(funcionario);
         this.funcionariosModel.setModo(Application.AGREGAR, funcionario);
         this.setTabla(dependencia);
     }
     
     public void setTabla(Dependencia dependencia) throws Exception{
         List<Funcionario> funcionarios = mainModel.buscarFuncionarios(funcionariosModel.getFiltro(), dependencia);
         funcionariosModel.setTable(funcionarios);
         funcionariosModel.notificar();
         
         if(funcionarios.isEmpty())
             throw new Exception("Funcionario no encontrado");
     }
     
     public List<String> getDependencias(){
         List<String> nombres = new ArrayList<String>();
         
         for(Dependencia dependencia :mainModel.getDependenciasBox()){
             nombres.add(dependencia.getDependenciaNombre());
         }
         
         return nombres;
     }
     
     public Dependencia buscarDependencia(String dependencia){
         return mainModel.buscarDependencia(dependencia);
     }
     
     public void reset(){
         funcionariosModel.inicializa();
     }
}
