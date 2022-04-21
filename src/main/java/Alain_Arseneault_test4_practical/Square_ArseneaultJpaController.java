/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alain_Arseneault_test4_practical;

import Alain_Arseneault_test4_practical.entities.Square_Arseneault;
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
public class Square_ArseneaultJpaController implements Serializable {

    public Square_ArseneaultJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Square_Arseneault square_Arseneault) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(square_Arseneault);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Square_Arseneault square_Arseneault) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            square_Arseneault = em.merge(square_Arseneault);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = square_Arseneault.getId();
                if (findSquare_Arseneault(id) == null) {
                    throw new NonexistentEntityException("The square_Arseneault with id " + id + " no longer exists.");
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
            Square_Arseneault square_Arseneault;
            try {
                square_Arseneault = em.getReference(Square_Arseneault.class, id);
                square_Arseneault.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The square_Arseneault with id " + id + " no longer exists.", enfe);
            }
            em.remove(square_Arseneault);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Square_Arseneault> findSquare_ArseneaultEntities() {
        return findSquare_ArseneaultEntities(true, -1, -1);
    }

    public List<Square_Arseneault> findSquare_ArseneaultEntities(int maxResults, int firstResult) {
        return findSquare_ArseneaultEntities(false, maxResults, firstResult);
    }

    private List<Square_Arseneault> findSquare_ArseneaultEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Square_Arseneault.class));
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

    public Square_Arseneault findSquare_Arseneault(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Square_Arseneault.class, id);
        } finally {
            em.close();
        }
    }

    public int getSquare_ArseneaultCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Square_Arseneault> rt = cq.from(Square_Arseneault.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
