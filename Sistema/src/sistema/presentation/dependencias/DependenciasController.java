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
import sistema.logic.Labor;
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
        this.model.inicializaPuestos(mainModel.getPuestosBox());
        
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
         List<Labor> labores = mainModel.buscarLabores(dependencia);
         model.setFuncionariosTable(labores);
         model.notificar();
         
         if(labores.isEmpty())
             throw new Exception("Funcionarios no encontrados");
     }
     
     public List<String> getFuncionarios(){
         List<String> nombres = new ArrayList<String>();
         
         for(Funcionario funcionario :mainModel.getFuncionariosBox()){
             nombres.add(funcionario.getFuncionarioNombre());
         }
         
         return nombres;
     }
     
     public Dependencia getDependencia(int fila){
         return model.getDependenciasTable().getRowAt(fila);
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
         Labor seleccionado = model.getFuncionariosTable().getRowAt(fila);
         
         try{
             mainModel.eliminarLabor(seleccionado);
         }catch(Exception ex){}
         
         List<Labor> lista =  mainModel.buscarLabores(dependencia);
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
     
     public void agregarLabor(Labor nuevo, int fila) throws Exception{
         Dependencia dependencia = model.getDependenciasTable().getRowAt(fila);
         mainModel.agregarLabor(nuevo);
         this.setTablaFuncionarios(dependencia);
     }
     
     public void reset(){
         model.inicializa();
     }
    
}
