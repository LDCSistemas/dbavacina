/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import java.io.Serializable;
import java.util.List;
import javassist.SerialVersionUID;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Cristiano Seixas
 */
public class HibernateDao<T> implements InterfaceDao<T>, Serializable {

    private static final long SerialVersionUID = 1L;
    private Class<T> classe;
    private Session Session;

    public HibernateDao(Class<T> classe, Session Session) {
        super();
        this.classe = classe;
        this.Session = Session;
    }

    @Override
    public void save(T entity) {
        Session.save(entity);
    }

    @Override
    public void update(T entity) {
        Session.update(entity);
    }

    @Override
    public void remove(T entity) {
        Session.delete(entity);
    }

    @Override
    public void merge(T entity) {
        Session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T) Session.get(classe, id);
        return entity;
    }

    @Override
    public T getEntityByDetacheCriteria(DetachedCriteria criteria) {
        T entity = (T) criteria.getExecutableCriteria(Session).uniqueResult();
        return entity;
    }

    @Override
    public List<T> getEntityListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(Session).list();
    }

    @Override
    public List<T> getEntities() {
        List<T> entities = (List<T>) Session.createCriteria(classe).list();
        return entities;
    }

}
