/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.principal;

import java.util.Observable;
import java.util.Observer;
import sistema.logic.Usuario;

/**
 *
 * @author Rachel
 */
public class PrincipalModel extends Observable {
    Usuario actual;

    public PrincipalModel(){
        reset(new Usuario());
    }
    
    public Usuario getUsuario() {
        return actual;
    }

    public void setUsuario(Usuario usuario) {
        this.actual = usuario;
        setChanged();
        notifyObservers();
    }
    
    public void reset(Usuario usuario){ 
       // clearErrors();
        this.setUsuario(usuario);
    }   
    
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
}
