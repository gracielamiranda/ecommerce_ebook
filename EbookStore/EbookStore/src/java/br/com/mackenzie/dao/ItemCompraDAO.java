package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.ItemCompra;
import br.com.mackenzie.dominio.Livro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


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
    
    public List<ItemCompra> obterPorLivro(Livro l){
        Query query = em.createQuery("SELECT i FROM ItemCompra i WHERE i.livro.id =  :livroId");
        query.setParameter("livroId",l.getId());
        
        return query.getResultList();
    }
    
}
