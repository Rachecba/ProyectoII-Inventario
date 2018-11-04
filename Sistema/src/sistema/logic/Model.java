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
    
    public List<Funcionario> buscarFuncionariosCedula(Funcionario filtro){
        
        if(filtro.getFuncionarioCedula() == null){
            return this.funcionarioDao.findAll();
        }
        else{
            return this.funcionarioDao.findFuncionario(filtro);
        }
        
    }
    
    public List<Labor> buscarLabores(Dependencia dependencia){
        
        return this.laborDao.findLabores(dependencia);
    }
    
    public List<Dependencia> buscarDependencias(Dependencia filtro){
        
        if(filtro.getDependenciaNombre() == null){
            return this.dependenciaDao.findAll();
        }
        else{
            return this.dependenciaDao.findDependencias(filtro);
        }
    }
     
     public List<Funcionario> buscarFuncionarios(Funcionario filtro){
         
         if(filtro.getFuncionarioNombre() == null){
             return this.funcionarioDao.findAll();
         }
         else{
             return this.funcionarioDao.findFuncionario(filtro);
         }
     }
     
     public List<Solicitud> buscarSolicitudes(Solicitud filtro){
         if(filtro.getSolicitudId()== null){
             return this.solicitudDao.findAll();
         }
         else{
             return this.solicitudDao.findSolicitudes(filtro);
         }
     }
     
     public List<Solicitud> buscarSolicitudesSecretario(Solicitud filtro){
         
         if(filtro.getSolicitudId()== null){
             return this.solicitudDao.findRecibidasAll();
         }
         else{
             return this.solicitudDao.findRecibidas(filtro);
         }
     }
    
    public List<Categoria> buscarCategorias(Categoria filtro){
        
        if(filtro.getCategoriaNombre() == null){
            return this.categoriaDao.findAll();
        }
        else{
            return this.categoriaDao.findCategorias(filtro);
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
    
    public void agregarDependencia(Dependencia dependencia, Labor labor){
        
        String nombre = dependencia.getDependenciaNombre();
        Dependencia existe = this.dependenciaDao.findByNombre(nombre);
        
        if(existe != null){
            dependencia.setDependenciaId(existe.getDependenciaId());
            this.dependenciaDao.edit(dependencia);
            this.laborDao.edit(this.laborDao.findAdmin(dependencia));
        }
        else{
            this.dependenciaDao.create(dependencia);
            this.laborDao.create(labor);
         }
     }
    
    public void agregarLabor(Labor labor, Dependencia dependencia){
       //Labor existe = this.laborDao.
        
        this.laborDao.create(labor);
        labor.getLaborFuncionario().getDependenciaCollection().add(dependencia); //agrego el funcionario a la dependencia
    }
    
    public void agregarCategoria(Categoria categoria){
        
        String nombre = categoria.getCategoriaNombre();
        Categoria existe = this.categoriaDao.findByNombre(nombre);
        
        if(existe != null){
            categoria.setCategoriaId(existe.getCategoriaId());
            this.categoriaDao.edit(categoria);
        }
        else{
            this.categoriaDao.create(categoria);
        }
    }
     
     public void eliminarFuncionario(Funcionario funcionario) throws Exception{
         
         if(funcionario.getDependenciaCollection().isEmpty())
             this.funcionarioDao.delete(funcionario);
         else{
             for(Dependencia dependencia : funcionario.getDependenciaCollection()){
                 if(dependencia.getDependenciaAdministrador().getFuncionarioNombre().equals(funcionario.getFuncionarioNombre())){
                     throw new Exception("No se puede eliminar al administrador de una dependencia.");
                 }
             }
             this.funcionarioDao.delete(funcionario);
         }
     }
     
     public void eliminarDependencia(Dependencia dependencia){
         List<Labor> labores = this.buscarLabores(dependencia);
         
         for(Labor labor : labores){
             this.eliminarLabor(labor);
         }
         
         this.dependenciaDao.delete(dependencia);
     }
     
     public void eliminarCategoria(Categoria categoria){
         this.categoriaDao.delete(categoria);
     }
     
     public void eliminarLabor(Labor labor){
         this.laborDao.delete(labor);
     }
     
     public List<Funcionario> getFuncionariosBox(){
         return this.funcionarioDao.findAll();
     }
     
     public List<Puesto> getPuestosBox(){
         return this.puestoDao.findAll();
     }
     
     public List<Categoria> getCategoriasBox(){
         return this.categoriaDao.findAll();
     }
             
     public Dependencia buscarDependencia(String nombre){
         return this.dependenciaDao.buscarDependencia(nombre);
     }
     
     public Funcionario buscarFuncionario(Funcionario funcionario){
         return this.funcionarioDao.findByNombre(funcionario.getFuncionarioNombre());
     }
     
     public Puesto buscarPuesto(String nombre){
         return this.puestoDao.findPuesto(nombre);
     }
    
    public List<Solicitud> searchSolicitud(Solicitud filtro){
        return solicitudDao.findSolicitudes(filtro);
    }
    
    public List<Solicitud> buscarSolicitudRegistrador(Solicitud filtro, Funcionario registrador){
        
        if(filtro.getSolicitudId() == null)
            return this.solicitudDao.findPorRegistradorAll(registrador);
        else
            return this.solicitudDao.findPorRegistrador(filtro, registrador);
    }
    
    public void cambiarEstadoSolicitud(Solicitud solicitud){
        this.solicitudDao.edit(solicitud);
    }
    
    public List<Bien> buscarBienes(Comprobante comprobante){
        return this.bienDao.buscarBienes(comprobante);
    }
    
    public void agregarBien(Bien bien){
//        Bien existe = this.bienDao.buscarBien(bien);
// 
//        if(existe != null){          
//            bien.setBienId(existe.getBienId());
//            this.bienDao.edit(bien);
//        }
//        else{
//            this.bienDao.create(bien);
//        }
    }
    
    public List<Bien> buscarNuevosBienes(){
      return null;//  return this.bienDao.buscarNuevosBienes();
    }
    
}
