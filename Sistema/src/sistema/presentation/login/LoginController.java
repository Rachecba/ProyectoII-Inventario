/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.login;

import sistema.Application;
import sistema.Sesion;
import sistema.logic.Model;
import sistema.logic.Usuario;

/**
 *
 * @author Rachel
 */
public class LoginController {
    LoginModel model;
    LoginView view;
    Model mainModel;
    Sesion sesion;
    
    public LoginController(LoginModel model, LoginView view, Model mainModel, Sesion sesion){
        this.model = model;
        this.view = view;
        this.mainModel = mainModel;
        this.sesion = sesion;
        
        view.setController(this);
        view.setModel(model);
    }
    
    public void login(Usuario usuario) throws Exception{
        model.setUsuario(usuario);
        Usuario correcto = mainModel.getUsuario(usuario.getUsuarioUsername(), usuario.getUsuarioPassword());
        sesion.setAttibute("Usuario", correcto);
        view.setVisible(false);
        Application.PRINCIPAL_CONTROLLER.enter(); //setea todo e indica en que sesion se esta
    }
    
    public void logout(){
        sesion.removeAttribute("Usuario");
        model.setUsuario(new Usuario());
        view.setVisible(true);
    }
    
    public void exit(){ System.exit(0); }
}
