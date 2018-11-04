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
import sistema.logic.Bien;
import sistema.logic.Bien;
import sistema.logic.Comprobante;
import sistema.logic.Solicitud;

/**
 *
 * @author leaca
 */
public class BienDAO extends AbstractFacade<Bien> implements Serializable{
    
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public BienDAO(EntityManagerFactory emf) {
        super(Bien.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Bien obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear el bien.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Bien obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando el bien.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Bien obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando el bien.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Bien> findAll(){
        try {
            Query q = em.createQuery("Select obj from Bien obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando los bienes.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
   public List<Bien> buscarBienes(Comprobante comprobante){
        try {
            Query q = em.createQuery("Select obj from Bien obj where obj.bienComprobante.comprobanteId = :id").setParameter("id", comprobante.getComprobanteId());
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperar los bienes.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
}
