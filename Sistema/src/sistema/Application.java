package sistema;

import javax.persistence.EntityManagerFactory;
import sistema.data.PuestoDAO;
import sistema.logic.Puesto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rachel
 */
public class Application {

    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Puesto p = new Puesto();
        PuestoDAO pDao = new PuestoDAO(factory);
        p.setPuestoNombre("Puesto1");
        
        pDao.create(p);
    }
    
}
