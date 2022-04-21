/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alain_Arseneault_test4_practical;

import Alain_Arseneault_test4_practical.entities.Triangle_Arseneault;
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
public class Triangle_ArseneaultJpaController implements Serializable {

    public Triangle_ArseneaultJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Triangle_Arseneault triangle_Arseneault) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(triangle_Arseneault);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Triangle_Arseneault triangle_Arseneault) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            triangle_Arseneault = em.merge(triangle_Arseneault);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = triangle_Arseneault.getId();
                if (findTriangle_Arseneault(id) == null) {
                    throw new NonexistentEntityException("The triangle_Arseneault with id " + id + " no longer exists.");
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
            Triangle_Arseneault triangle_Arseneault;
            try {
                triangle_Arseneault = em.getReference(Triangle_Arseneault.class, id);
                triangle_Arseneault.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The triangle_Arseneault with id " + id + " no longer exists.", enfe);
            }
            em.remove(triangle_Arseneault);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Triangle_Arseneault> findTriangle_ArseneaultEntities() {
        return findTriangle_ArseneaultEntities(true, -1, -1);
    }

    public List<Triangle_Arseneault> findTriangle_ArseneaultEntities(int maxResults, int firstResult) {
        return findTriangle_ArseneaultEntities(false, maxResults, firstResult);
    }

    private List<Triangle_Arseneault> findTriangle_ArseneaultEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Triangle_Arseneault.class));
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

    public Triangle_Arseneault findTriangle_Arseneault(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Triangle_Arseneault.class, id);
        } finally {
            em.close();
        }
    }

    public int getTriangle_ArseneaultCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Triangle_Arseneault> rt = cq.from(Triangle_Arseneault.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
