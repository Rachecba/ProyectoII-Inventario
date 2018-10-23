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
import sistema.logic.Usuario;
import sistema.logic.Usuario;

/**
 *
 * @author leaca
 */
public class UsuarioDAO extends AbstractFacade<Usuario> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public UsuarioDAO(EntityManagerFactory emf) {
        super(Usuario.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Usuario obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear el usuario.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Usuario obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando el usuario.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Usuario obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando el usuario.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Usuario> findAll(){
        try {
            Query q = em.createQuery("Select obj from Usuario obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando los usuarios.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public Usuario obtenerUsuario(String userName){
        try {
            Query q = em.createQuery("Select u from Usuario u where u.usuarioUsername = :userName")
                    .setParameter("userName", userName);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            System.out.print("Error recuperando usuario" + e);
        }
        return null;
    }
}
 