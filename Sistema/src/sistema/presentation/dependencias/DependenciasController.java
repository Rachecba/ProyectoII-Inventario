/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.dependencias;

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
public class DependenciasController {
    Model mainModel;
    Sesion sesion;
    DependenciasModel model;
    DependenciasView view;
    
    public DependenciasController(DependenciasModel model, DependenciasView view, Model main, Sesion sesion){
        this.model = model;
        this.mainModel = main;
        this.view = view;
        this.sesion = sesion;
        this.model.inicializaFuncionarios(mainModel.getFuncionariosBox());
        
        view.setController(this);
        view.setModel(model);
    }
    
     public void ocultar(){
        view.setVisible(false);
    }
     
     public void mostrar(){
         view.setVisible(true);
     }
     
     public void setModo(int modo, int fila){
         Dependencia seleccionada = model.getDependenciasTable().getRowAt(fila);
         this.model.setModo(modo, seleccionada);
     }
     
     public void setTablaDependencia() throws Exception{
         List<Dependencia> dependencias = mainModel.buscarDependencias(model.getFiltro());
         model.setDependenciasTable(dependencias);
         model.notificar();
         
         if(dependencias.isEmpty())
             throw new Exception("Dependencia no encontrada");
     }
       
     public void setTablaFuncionarios(Dependencia dependencia) throws Exception{
         List<Funcionario> funcionarios = mainModel.buscarFuncionarios(new Funcionario(), dependencia);
         model.setFuncionariosTable(funcionarios);
         model.notificar();
         
         if(funcionarios.isEmpty())
             throw new Exception("Funcionarios no encontrados");
     }
     
     public List<String> getFuncionarios(){
         List<String> nombres = new ArrayList<String>();
         
         for(Funcionario funcionario :mainModel.getFuncionariosBox()){
             nombres.add(funcionario.getFuncionarioNombre());
         }
         
         return nombres;
     }
     
     public void buscarTodos() throws Exception{
         Dependencia dependencia = new Dependencia();
         model.setFiltro(dependencia);
         this.model.setModo(Application.AGREGAR, dependencia);
         this.setTablaDependencia();
     }
     
     public void buscarFuncionarios(int fila) throws Exception{
         Dependencia dependencia = model.getDependenciasTable().getRowAt(fila);
         this.setTablaFuncionarios(dependencia);
     }
     
     public void buscar(Dependencia filtro) throws Exception{
         model.setFiltro(filtro);
         model.setModo(Application.AGREGAR, filtro);
         this.setTablaDependencia();
     }
     
     public void borrarDependencia(int fila) throws Exception{
         Dependencia seleccionada = model.getDependenciasTable().getRowAt(fila);
         
         try{
             mainModel.eliminarDependencia(seleccionada);
         }catch(Exception ex){}
         
         List<Dependencia> lista = mainModel.buscarDependencias(model.getFiltro());
         this.model.setDependenciasTable(lista);
         this.model.notificar();
     
     }
     
     public void borrarFuncionario(int fila, int filaD) throws Exception{
         Dependencia dependencia = model.getDependenciasTable().getRowAt(filaD);
         Funcionario seleccionado = model.getFuncionariosTable().getRowAt(fila);
         
         try{
             mainModel.eliminarFuncionario(seleccionado);
         }catch(Exception ex){}
         
         List<Funcionario> lista = mainModel.buscarFuncionarios(new Funcionario(), dependencia);
         this.model.setFuncionariosTable(lista);
         this.model.notificar();
     }
     
     public Funcionario buscarFuncionario(Funcionario funcionario){
         return mainModel.buscarFuncionario(funcionario);
     }
     
     public void agregarDependencia(Dependencia nueva) throws Exception{
         
         switch(this.model.getModo()){
             case Application.AGREGAR:
                 mainModel.agregarDependencia(nueva);
                 this.model.setFiltro(nueva);
                 this.model.setModo(Application.AGREGAR, nueva);
                 this.setTablaDependencia();
                 
             case Application.EDITAR:
                 mainModel.agregarDependencia(nueva);
                 this.model.setModo(Application.AGREGAR, nueva);
                 this.setTablaDependencia();
         }
     }
     
     public void agregarFuncionario(Funcionario nuevo, int fila) throws Exception{
         Dependencia dependencia = model.getDependenciasTable().getRowAt(fila);
         mainModel.agregarFuncionario(nuevo);
         this.setTablaFuncionarios(dependencia);
     }
     
     public void reset(){
         model.inicializa();
     }
    
}
