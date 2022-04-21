/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alain_Arseneault_test4_practical;

import Alain_Arseneault_test4_practical.entities.Shape_Arseneault;
import Alain_Arseneault_test4_practical.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author alars
 */
public class Shape_ArseneaultJpaController implements Serializable {

    public Shape_ArseneaultJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Shape_Arseneault shape_Arseneault) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(shape_Arseneault);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Shape_Arseneault shape_Arseneault) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            shape_Arseneault = em.merge(shape_Arseneault);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = shape_Arseneault.getId();
                if (findShape_Arseneault(id) == null) {
                    throw new NonexistentEntityException("The shape_Arseneault with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Shape_Arseneault shape_Arseneault;
            try {
                shape_Arseneault = em.getReference(Shape_Arseneault.class, id);
                shape_Arseneault.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The shape_Arseneault with id " + id + " no longer exists.", enfe);
            }
            em.remove(shape_Arseneault);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Shape_Arseneault> findShape_ArseneaultEntities() {
        return findShape_ArseneaultEntities(true, -1, -1);
    }

    public List<Shape_Arseneault> findShape_ArseneaultEntities(int maxResults, int firstResult) {
        return findShape_ArseneaultEntities(false, maxResults, firstResult);
    }

    private List<Shape_Arseneault> findShape_ArseneaultEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Shape_Arseneault.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Shape_Arseneault findShape_Arseneault(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Shape_Arseneault.class, id);
        } finally {
            em.close();
        }
    }

    public int getShape_ArseneaultCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Shape_Arseneault> rt = cq.from(Shape_Arseneault.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
