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
        funcionariosView = fv;
        mainModel = mm;
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
     
     public void agregar(Funcionario funcionario) throws Exception{
       mainModel.agregarFuncionario(funcionario);
       this.setTabla();
     }
     
     public void buscar(Funcionario funcionario) throws Exception{
         funcionariosModel.setFiltro(funcionario);
         this.setTabla();
     }
     
     public void buscarTodos() throws Exception{
         Funcionario funcionario = new Funcionario();
         funcionariosModel.setFiltro(funcionario);
         this.setTabla();
     }
     
     public void setTabla() throws Exception{
         List<Funcionario> funcionarios = mainModel.buscarFuncionarios(funcionariosModel.getFiltro());
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
