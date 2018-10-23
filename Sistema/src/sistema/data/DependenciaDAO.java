/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sistema.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import sistema.logic.Dependencia;
import sistema.logic.Dependencia;

/**
 *
 * @author leaca
 */
public class DependenciaDAO extends AbstractFacade<Dependencia> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public DependenciaDAO(EntityManagerFactory emf) {
        super(Dependencia.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Dependencia obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear la dependencia.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Dependencia obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando la dependencia.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Dependencia obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando la dependencia.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Dependencia> findAll(){
        try {
            Query q = em.createQuery("Select obj from Dependencia obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando las dependencias.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
}
