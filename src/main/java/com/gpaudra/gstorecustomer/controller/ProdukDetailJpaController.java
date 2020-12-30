/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpaudra.gstorecustomer.controller;

import com.gpaudra.gstorecustomer.controller.exceptions.NonexistentEntityException;
import com.gpaudra.gstorecustomer.controller.exceptions.PreexistingEntityException;
import com.gpaudra.gstorecustomer.model.ProdukDetail;
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
 * @author Gesang Paudra Jaya
 */
public class ProdukDetailJpaController implements Serializable {

    public ProdukDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProdukDetail produkDetail) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(produkDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdukDetail(produkDetail.getIdDetailproduk()) != null) {
                throw new PreexistingEntityException("ProdukDetail " + produkDetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProdukDetail produkDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            produkDetail = em.merge(produkDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produkDetail.getIdDetailproduk();
                if (findProdukDetail(id) == null) {
                    throw new NonexistentEntityException("The produkDetail with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProdukDetail produkDetail;
            try {
                produkDetail = em.getReference(ProdukDetail.class, id);
                produkDetail.getIdDetailproduk();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produkDetail with id " + id + " no longer exists.", enfe);
            }
            em.remove(produkDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProdukDetail> findProdukDetailEntities() {
        return findProdukDetailEntities(true, -1, -1);
    }

    public List<ProdukDetail> findProdukDetailEntities(int maxResults, int firstResult) {
        return findProdukDetailEntities(false, maxResults, firstResult);
    }

    private List<ProdukDetail> findProdukDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProdukDetail.class));
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

    public ProdukDetail findProdukDetail(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProdukDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdukDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProdukDetail> rt = cq.from(ProdukDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
