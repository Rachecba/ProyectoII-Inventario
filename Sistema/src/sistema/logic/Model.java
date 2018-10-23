/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

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
      
     public Model(){}
     
     public Usuario getUsuario(String user, String pass) throws Exception{
         Usuario usuario = usuarioDao.getUsuario(user);
         
        if (usuario.getClave().equals(pass)){ //verifica si la clave del nuevo usuario y la del parametro, son iguales.
            return usuario;
        }
        else{
            throw new Exception ("Password incorrecta");
        }
     }
     
    
}
