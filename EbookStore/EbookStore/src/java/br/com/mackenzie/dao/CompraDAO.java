package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Compra;
import br.com.mackenzie.dominio.ItemCompra;
import br.com.mackenzie.dominio.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CompraDAO extends AbstractDAO<Compra> {

    @PersistenceContext
    private EntityManager em;

    public CompraDAO() {
        super(Compra.class);
    }
    
    public List<Compra> obterComprasPorUsuario(Usuario usuario){
        Query query = em.createQuery("SELECT c FROM Compra c WHERE c.usuario.id = :usuarioId ");
        query.setParameter("usuarioId",usuario.getId());
        
        return query.getResultList();
    }
    
    public List<ItemCompra> obterItensCompras(Compra compra){
        Query query = em.createQuery("SELECT ic FROM ItemCompra ic WHERE ic.compra.id = :compraId ");
        query.setParameter("compraId",compra.getId());
        
        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
