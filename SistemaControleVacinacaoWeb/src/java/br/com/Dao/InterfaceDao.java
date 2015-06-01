/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Cristiano Seixas
 */
public interface InterfaceDao<T> {

    void save(T entity);

    void update(T entity);

    void remove(T entity);

    void merge(T entity);

    T getEntity(Serializable id);

    T getEntityByDetacheCriteria(DetachedCriteria criteria);

    List<T> getEntities();

    List<T> getEntityListByDetachedCriteria(DetachedCriteria criteria);

}
