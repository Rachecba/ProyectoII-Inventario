/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.data;

import java.io.Serializable;
import javax.persistence.EntityNotFoundException;
import sistema.logic.Labor;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import sistema.exceptions.NonexistentEntityException;
import sistema.logic.Puesto;

/**
 *
 * @author leaca
 */
public class PuestoDAO implements Serializable {

    public PuestoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puesto puesto) {
        if (puesto.getLaborCollection() == null) {
            puesto.setLaborCollection(new ArrayList<Labor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Labor> attachedLaborCollection = new ArrayList<Labor>();
            for (Labor laborCollectionLaborToAttach : puesto.getLaborCollection()) {
                laborCollectionLaborToAttach = em.getReference(laborCollectionLaborToAttach.getClass(), laborCollectionLaborToAttach.getLaborId());
                attachedLaborCollection.add(laborCollectionLaborToAttach);
            }
            puesto.setLaborCollection(attachedLaborCollection);
            em.persist(puesto);
            for (Labor laborCollectionLabor : puesto.getLaborCollection()) {
                Puesto oldLaborPuestoOfLaborCollectionLabor = laborCollectionLabor.getLaborPuesto();
                laborCollectionLabor.setLaborPuesto(puesto);
                laborCollectionLabor = em.merge(laborCollectionLabor);
                if (oldLaborPuestoOfLaborCollectionLabor != null) {
                    oldLaborPuestoOfLaborCollectionLabor.getLaborCollection().remove(laborCollectionLabor);
                    oldLaborPuestoOfLaborCollectionLabor = em.merge(oldLaborPuestoOfLaborCollectionLabor);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puesto puesto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puesto persistentPuesto = em.find(Puesto.class, puesto.getPuestoId());
            Collection<Labor> laborCollectionOld = persistentPuesto.getLaborCollection();
            Collection<Labor> laborCollectionNew = puesto.getLaborCollection();
            Collection<Labor> attachedLaborCollectionNew = new ArrayList<Labor>();
            for (Labor laborCollectionNewLaborToAttach : laborCollectionNew) {
                laborCollectionNewLaborToAttach = em.getReference(laborCollectionNewLaborToAttach.getClass(), laborCollectionNewLaborToAttach.getLaborId());
                attachedLaborCollectionNew.add(laborCollectionNewLaborToAttach);
            }
            laborCollectionNew = attachedLaborCollectionNew;
            puesto.setLaborCollection(laborCollectionNew);
            puesto = em.merge(puesto);
            for (Labor laborCollectionOldLabor : laborCollectionOld) {
                if (!laborCollectionNew.contains(laborCollectionOldLabor)) {
                    laborCollectionOldLabor.setLaborPuesto(null);
                    laborCollectionOldLabor = em.merge(laborCollectionOldLabor);
                }
            }
            for (Labor laborCollectionNewLabor : laborCollectionNew) {
                if (!laborCollectionOld.contains(laborCollectionNewLabor)) {
                    Puesto oldLaborPuestoOfLaborCollectionNewLabor = laborCollectionNewLabor.getLaborPuesto();
                    laborCollectionNewLabor.setLaborPuesto(puesto);
                    laborCollectionNewLabor = em.merge(laborCollectionNewLabor);
                    if (oldLaborPuestoOfLaborCollectionNewLabor != null && !oldLaborPuestoOfLaborCollectionNewLabor.equals(puesto)) {
                        oldLaborPuestoOfLaborCollectionNewLabor.getLaborCollection().remove(laborCollectionNewLabor);
                        oldLaborPuestoOfLaborCollectionNewLabor = em.merge(oldLaborPuestoOfLaborCollectionNewLabor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = puesto.getPuestoId();
                if (findPuesto(id) == null) {
                    throw new NonexistentEntityException("The puesto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puesto puesto;
            try {
                puesto = em.getReference(Puesto.class, id);
                puesto.getPuestoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puesto with id " + id + " no longer exists.", enfe);
            }
            Collection<Labor> laborCollection = puesto.getLaborCollection();
            for (Labor laborCollectionLabor : laborCollection) {
                laborCollectionLabor.setLaborPuesto(null);
                laborCollectionLabor = em.merge(laborCollectionLabor);
            }
            em.remove(puesto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Puesto findPuesto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puesto.class, id);
        } finally {
            em.close();
        }
    }
    
}
