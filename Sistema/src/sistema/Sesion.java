/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.HashMap;

/**
 *
 * @author Rachel
 */
public class Sesion {
 
    HashMap<String,Object> attributes; //esta clase indica en que sesion se esta. El login.

    public Sesion() {
        attributes = new HashMap();
    }
    
    public Object getAttribute(String attribute){
        return attributes.get(attribute);
    }
    
    public void setAttibute(String attribute, Object value){
        attributes.put(attribute, value);
    }
    
    public void removeAttribute(String attribute){
        attributes.remove(attribute);
    } 
}
