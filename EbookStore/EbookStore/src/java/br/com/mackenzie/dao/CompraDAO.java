package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Compra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CompraDAO extends AbstractDAO<Compra> {

    @PersistenceContext
    private EntityManager em;

    public CompraDAO() {
        super(Compra.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
