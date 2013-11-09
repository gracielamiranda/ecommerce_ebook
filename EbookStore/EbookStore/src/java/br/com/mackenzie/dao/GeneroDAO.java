
package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Genero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GeneroDAO extends AbstractDAO<Genero>{
   @PersistenceContext(unitName = "EbookStorePU")
    private EntityManager em;

    public GeneroDAO() {
        super(Genero.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    public List<Genero> obterPorNome(String nome){
        Query query = em.createQuery("SELECT g FROM Genero g WHERE LOWER(g.nome) LIKE LOWER(:nome)");
        query.setParameter("nome","%" + nome + "%");
        
        return query.getResultList();
    }

    
 
}
