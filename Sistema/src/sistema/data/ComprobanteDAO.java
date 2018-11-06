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
import sistema.logic.Comprobante;
import sistema.logic.Comprobante;

/**
 *
 * @author leaca
 */
public class ComprobanteDAO extends AbstractFacade<Comprobante> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public ComprobanteDAO(EntityManagerFactory emf) {
        super(Comprobante.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Comprobante obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear el combrobante.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Comprobante obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando el combrobante.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Comprobante obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando el combrobante.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Comprobante> findAll(){
        try {
            Query q = em.createQuery("Select obj from Comprobante obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando los combrobantes.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public Comprobante buscarComprobante(Comprobante comprobante){
        try {
            Query q = em.createQuery("SELECT c FROM Comprobante c where c.comprobanteNumero = :comprobanteNum")
                    .setParameter("comprobanteNum", comprobante.getComprobanteNumero());
            return (Comprobante) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error buscando por numero: " + ex);
        }
        return null;
    }
}
