/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import sistema.logic.Dependencia;
import sistema.logic.Funcionario;

/**
 *
 * @author leaca
 */
public class FuncionarioDAO extends AbstractFacade<Funcionario> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public FuncionarioDAO(EntityManagerFactory emf) {
        super(Funcionario.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Funcionario obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear el funcionario.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Funcionario obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editar el funcionario.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Funcionario obj) {//throws Exception{
        try{
            super.remove(obj);
        } catch (Exception e) {
            
            System.out.print("Error al borrar la dependencia.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Funcionario> findAll(){
        try {
            Query q = em.createQuery("Select obj from Funcionario obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperar los funcionarios.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public List<Funcionario> findFuncionario(Funcionario funcionario){
        try{
            Query q = em.createQuery("Select f from Funcionario f where f.funcionarioNombre LIKE CONCAT('%',:filtro,'%')").setParameter("filtro", funcionario.getFuncionarioNombre());
            return q.getResultList();
        }catch(Exception ex){
            System.out.print("Error al recuperar los funcionarios. \n\n Error:" + ex + "\n\n");
        }
        return null;
    }
    
    public Funcionario findByCedula(String cedula){
        try {
            Query q = em.createQuery("SELECT f FROM Funcionario f WHERE f.funcionarioCedula = :ced").setParameter("ced", cedula);
            return (Funcionario) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error buscando por cedula: " + ex);
        }
        return null;
    }
    
    public Funcionario findByNombre(String nombre){
        try {
            Query q = em.createQuery("SELECT f FROM Funcionario f WHERE f.funcionarioNombre = :nombre").setParameter("nombre", nombre);
            return (Funcionario) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error buscando por nombre: " + ex);
        }
        return null;
    }
    
    public List<Funcionario> findFuncionariosPorDependencia(Dependencia dependencia){
        try {
            Query q = em.createQuery("Select f from Funcionario f right join f.dependenciaCollection dep where dep.dependenciaNombre = :dependencia").setParameter("dependencia", dependencia.getDependenciaNombre());
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperar los funcionarios. \n\n Error:" + e + "\n\n");
            return null;
        }
    }
}
