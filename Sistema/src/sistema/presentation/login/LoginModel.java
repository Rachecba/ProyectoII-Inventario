/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.login;

import java.util.Observable;
import sistema.logic.Usuario;

/**
 *
 * @author Rachel
 */
public class LoginModel extends Observable{
    Usuario usuario;
    
    public LoginModel(){
         this.reset();
    }
    
    public void reset(){
        this.setUsuario(new Usuario());
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        setChanged();
        notifyObservers();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
    
    
}
