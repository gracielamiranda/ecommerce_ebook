package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.ItemCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ItemCompraDAO extends AbstractDAO<ItemCompra> {

    @PersistenceContext
    private EntityManager em;

    public ItemCompraDAO() {
        super(ItemCompra.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
