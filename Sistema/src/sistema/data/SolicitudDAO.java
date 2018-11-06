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
import sistema.logic.Funcionario;
import sistema.logic.Solicitud;

/**
 *
 * @author leaca
 */
public class SolicitudDAO extends AbstractFacade<Solicitud> implements Serializable{
        private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public SolicitudDAO(EntityManagerFactory emf) {
        super(Solicitud.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Solicitud obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear la solicitud.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void edit(Solicitud obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando la solicitud.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void delete(Solicitud obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando la solicitud.\n\n Error:" + e + "\n\n");
        }
    }
    
    @Override
    public List<Solicitud> findAll(){
        try {
            Query q = em.createQuery("Select obj from Solicitud obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando las solicitudes.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public List<Solicitud> findSolicitudes(Solicitud solicitud){
        try {
            Query q = em.createQuery("Select obj from Solicitud obj where obj.solicitudId LIKE CONCAT('%',:solicitudId,'%') or obj.solicitudComprobante.comprobanteNumero LIKE CONCAT('%',:solicitudComp,'%') or obj.solicitudRegistradorDeBienes.funcionarioNombre LIKE CONCAT('%',:solicitudFunc,'%')")
                    .setParameter("solicitudId", solicitud.getSolicitudId())
                    .setParameter("solicitudComp", solicitud.getSolicitudComprobante().getComprobanteNumero())
                    .setParameter("solicitudFunc", solicitud.getSolicitudRegistradorDeBienes().getFuncionarioNombre());
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando las solicitudes.\n\n Error:" + e + "\n\n");
        }
        return null;
        
    }
    
    public List<Solicitud> findPorRegistrador(Solicitud filtro, Funcionario registrador){
        try {
            Query q = em.createQuery("Select obj from Solicitud obj where obj.solicitudId LIKE CONCAT('%',:solicitudId,'%') and obj.solicitudRegistradorDeBienes = :registrador").setParameter("solicitudId", filtro.getSolicitudId()).setParameter("registrador", registrador.getFuncionarioNombre());
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando las solicitudes.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
    
    public Solicitud buscarSolicitud(Solicitud solicitud){
        try {
            Query q = em.createQuery("SELECT s FROM Solicitud s where s.solicitudComprobante.comprobanteId = :comprobanteNum")
                    .setParameter("comprobanteNum", solicitud.getSolicitudComprobante().getComprobanteId());
            return (Solicitud) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error buscando por numero: " + ex);
        }
        return null;
    }
}
