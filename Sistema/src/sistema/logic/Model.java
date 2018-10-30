/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sistema.data.ActivoUniversitarioDAO;
import sistema.data.BienDAO;
import sistema.data.CategoriaDAO;
import sistema.data.ComprobanteDAO;
import sistema.data.DependenciaDAO;
import sistema.data.FuncionarioDAO;
import sistema.data.LaborDAO;
import sistema.data.PuestoDAO;
import sistema.data.SolicitudDAO;
import sistema.data.TipoDeAdquisicionDAO;
import sistema.data.UsuarioDAO;

/**
 *
 * @author Rachel
 */
public class Model {
    ActivoUniversitarioDAO activoDao;
    BienDAO bienDao;
    CategoriaDAO categoriaDao;
    ComprobanteDAO comprobanteDao;
    DependenciaDAO dependenciaDao;
    FuncionarioDAO funcionarioDao;
    LaborDAO laborDao;
    PuestoDAO puestoDao;
    SolicitudDAO solicitudDao;
    TipoDeAdquisicionDAO tipoAdquisicionDao;
    UsuarioDAO usuarioDao;
    
      private static Model uniqueInstance;
      
      public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }
      
     public Model(){
         EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "SistemaPU" );
         activoDao = new ActivoUniversitarioDAO(emfactory);
         bienDao = new BienDAO(emfactory);
         categoriaDao = new CategoriaDAO(emfactory);
         comprobanteDao = new ComprobanteDAO(emfactory);
         dependenciaDao = new DependenciaDAO(emfactory);
         funcionarioDao = new FuncionarioDAO(emfactory);
         laborDao = new LaborDAO(emfactory);
         puestoDao = new PuestoDAO(emfactory);
         solicitudDao = new SolicitudDAO(emfactory);
         tipoAdquisicionDao = new TipoDeAdquisicionDAO(emfactory);
         usuarioDao = new UsuarioDAO(emfactory);
     }
     
     public Usuario getUsuario(String userName, String pass) throws Exception{
         Usuario usuario = usuarioDao.obtenerUsuario(userName);
         
        if (usuario.getUsuarioPassword().equals(pass)){ //verifica si la clave del nuevo usuario y la del parametro, son iguales.
            return usuario;
        }
        else{
            throw new Exception ("Password incorrecta");
        }
     }
     
     public List<Funcionario> buscarFuncionarios(Funcionario filtro, Dependencia dependencia){
        
         if(filtro.getFuncionarioCedula() == null){
             return this.funcionarioDao.findAll(); //arreglar este findAll, es findAll por dependencia
         }
         else{
             return this.funcionarioDao.findFuncionario(filtro);
         }
         
     }
     
     public List<Dependencia> buscarDependencias(Dependencia filtro){
         
         if(filtro.getDependenciaNombre() == null){
             return this.dependenciaDao.findAll();
         }
         else{
             return this.dependenciaDao.findDependencias(filtro);
         }
     }
         
     public void agregarFuncionario(Funcionario funcionario){
         
         String cedula = funcionario.getFuncionarioCedula();
         Funcionario existe = this.funcionarioDao.findByCedula(cedula);
         
         if(existe != null){
             funcionario.setFuncionarioId(existe.getFuncionarioId());
             this.funcionarioDao.edit(funcionario);
         }
         else{
            this.funcionarioDao.create(funcionario);
         }
     }
     
     public void agregarDependencia(Dependencia dependencia){
         
         String nombre = dependencia.getDependenciaNombre();
         Dependencia existe = this.dependenciaDao.findByNombre(nombre);
         
         if(existe != null){
             dependencia.setDependenciaId(existe.getDependenciaId());
             this.dependenciaDao.edit(dependencia);
         }
         else{
            this.dependenciaDao.create(dependencia);
         }
     }
     
     public void eliminarFuncionario(Funcionario funcionario) throws Exception{
         this.funcionarioDao.delete(funcionario);
     }
     
     public void eliminarDependencia(Dependencia dependencia){
         this.dependenciaDao.delete(dependencia);
     }
     
     public List<Dependencia> getDependenciasBox(){
         return this.dependenciaDao.findAll();
     }
     
     public List<Funcionario> getFuncionariosBox(){
         return this.funcionarioDao.findAll();
     }
     
     public Dependencia buscarDependencia(String nombre){
         return this.dependenciaDao.buscarDependencia(nombre);
     }
     
     public Funcionario buscarFuncionario(Funcionario funcionario){
         return this.funcionarioDao.findByNombre(funcionario.getFuncionarioNombre());
     }
}
