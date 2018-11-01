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
import sistema.logic.Labor;
import sistema.logic.Labor;

/**
 *
 * @author leaca
 */
public class LaborDAO extends AbstractFacade<Labor> implements Serializable{
private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public LaborDAO(EntityManagerFactory emf) {
        super(Labor.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Labor obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear la labor.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Labor obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando la labor.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Labor obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando la labor.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Labor> findAll(){
        try {
            Query q = em.createQuery("Select obj from Labor obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando las labores.\n\n Error:" + e + "\n\n");
        }
        return null;
    }   
    
    public List<Labor> findLabores(Dependencia dependencia){
        try {
            Query q = em.createQuery("Select obj from Labor obj where obj.laborDependencia = :dependencia").setParameter("dependencia", dependencia);
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperar las labores.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public Labor findAdmin(Dependencia dependencia){
         try {
            Query q = em.createQuery("Select obj from Labor obj where obj.laborDependencia = :dependencia and obj.laborPuesto.puestoNombre = :admin").setParameter("dependencia", dependencia).setParameter("admin", "Administrador");
            return (Labor) q.getSingleResult();
        } catch (Exception e) {
            System.out.print("Error al recuperar labor por admin.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
}
