/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import sistema.logic.ActivoUniversitario;
import sistema.logic.ActivoUniversitario;
import sistema.logic.Bien;

/**
 *
 * @author leaca
 */
public class ActivoUniversitarioDAO extends AbstractFacade<ActivoUniversitario> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public ActivoUniversitarioDAO(EntityManagerFactory emf) {
        super(ActivoUniversitario.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(ActivoUniversitario obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear el activo universitario.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(ActivoUniversitario obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando el activo universitario.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(ActivoUniversitario obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando el activo universitario.\n\n Error:" + e + "\n\n");
        }
    }
    
    public List<ActivoUniversitario> buscar(ActivoUniversitario obj){
        try {
            Query q = em.createQuery("Select obj from ActivoUniversitario obj where obj.activoUniversitarioCodigo = :activoId").setParameter("activoId", obj.getActivoUniversitarioCodigo());
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al buscando los activos universitario.\n\n Error:" + e + "\n\n");
            return null;
        }
    }
    
    @Override
    public List<ActivoUniversitario> findAll(){
        try {
            Query q = em.createQuery("Select obj from ActivoUniversitario obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando los activo universitarios.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public List<ActivoUniversitario> getCodigo(Bien bien){
    
        try {
            Query q = em.createQuery("Select obj from ActivoUniversitario obj  where obj.activoUniversitarioCategoria = :categoria order by obj.activoUniversitarioCodigo desc").setParameter("categoria", bien.getBienCategoria());
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando los activo universitarios.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
}
