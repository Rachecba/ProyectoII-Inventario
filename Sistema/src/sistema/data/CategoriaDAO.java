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
import sistema.logic.Categoria;
import sistema.logic.Categoria;

/**
 *
 * @author leaca
 */
public class CategoriaDAO extends AbstractFacade<Categoria> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public CategoriaDAO(EntityManagerFactory emf) {
        super(Categoria.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Categoria obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear la categoria.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Categoria obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando la categoria.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Categoria obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando la categoria.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Categoria> findAll(){
        try {
            Query q = em.createQuery("Select obj from Categoria obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando las categorias.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public List<Categoria> findCategorias(Categoria filtro){
        try{
            Query q = em.createQuery("Select f from Categoria f where f.categoriaNombre like concat ('%',:nombre,'%')").setParameter("nombre", filtro.getCategoriaNombre());
            return q.getResultList();
        }catch(Exception ex){
            System.out.print("Error al recuperar las categorias. \n\n Error:" + ex + "\n\n");
        }
        return null;
    }
    
    public Categoria findByNombre(String nombre){
        try{
            Query q = em.createQuery("Select f from Categoria f where f.categoriaNombre = :nombre").setParameter("nombre", nombre);
            return (Categoria) q.getSingleResult();
        }catch(Exception ex){
            System.out.print("Error al recuperar la categoria por nombre. \n\n Error:" + ex + "\n\n");
        }
        return null;
    }
}
