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
import sistema.logic.Puesto;

/**
 *
 * @author leaca
 */
public class PuestoDAO extends AbstractFacade<Puesto> implements Serializable{

    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public PuestoDAO(EntityManagerFactory emf) {
        super(Puesto.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Puesto obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear el puesto.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Puesto obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando el puesto.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Puesto obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando el puesto.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Puesto> findAll(){
        try {
            Query q = em.createQuery("Select obj from Puesto obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando los puestos.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public Puesto findPuesto(String nombre){
        try {
            Query q = em.createQuery("Select obj from Puesto obj where obj.puestoNombre = :nombre").setParameter("nombre", nombre);
            return (Puesto) q.getSingleResult();
        } catch (Exception e) {
            System.out.print("Error al recuperar el puesto.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
}
