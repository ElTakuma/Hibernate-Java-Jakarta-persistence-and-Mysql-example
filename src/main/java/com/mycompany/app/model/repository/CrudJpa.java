package com.mycompany.app.model.repository;

import com.mycompany.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Generic crud entity class
 * @author  Roméo Tatchemo
 * @version 1.0
 * @param <Entity>
 */
public class CrudJpa<Entity> {

    private final Entity entity;

    CrudJpa(Entity entity) {
        this.entity = entity;
    }

    /**
     * Save entity instance
     * @param entity
     */
    public void save(Entity entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.persist(entity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * update entity instance
     * @param entity
     */
    public void update(Entity entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.merge(entity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get list of all entity instance
     */
    public List<Entity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String q = String.format("FROM %s", this.entity.getClass().getSimpleName());
            return (List<Entity>) session.createQuery(q, this.entity.getClass()).list();
        }
    }

    /**
     * Get one of all entity instance by id
     * @param id
     */
    public Entity findOne(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String q = String.format("FROM %s WHERE id = %d", this.entity.getClass().getSimpleName(), id);
            try {
                return (Entity) session.createQuery(q, this.entity.getClass()).list().get(0);
            } catch (Exception e) {
                return null;
            }
        }
    }

}
