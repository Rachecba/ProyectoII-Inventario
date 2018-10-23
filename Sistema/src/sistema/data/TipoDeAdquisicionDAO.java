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
import sistema.logic.TipoDeAdquisicion;
import sistema.logic.TipoDeAdquisicion;

/**
 *
 * @author leaca
 */
public class TipoDeAdquisicionDAO extends AbstractFacade<TipoDeAdquisicion> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public TipoDeAdquisicionDAO(EntityManagerFactory emf) {
        super(TipoDeAdquisicion.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(TipoDeAdquisicion obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear el tipo de adquisicion.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(TipoDeAdquisicion obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando el tipo de adquisicion.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(TipoDeAdquisicion obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando el tipo de adquisicion.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<TipoDeAdquisicion> findAll(){
        try {
            Query q = em.createQuery("Select obj from TipoDeAdquisicion obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando los tipos de adquisicion.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
}
