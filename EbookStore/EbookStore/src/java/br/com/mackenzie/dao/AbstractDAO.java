/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Graciela Miranda
 */
public abstract class AbstractDAO<T> {
    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void inserir(T entity) {
        getEntityManager().persist(entity);
    }

    public void alterar(T entity) {
        getEntityManager().merge(entity);
    }

    public void remover(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T obter(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> obterTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
