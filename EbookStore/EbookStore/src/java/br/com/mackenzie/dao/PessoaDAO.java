package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa> {

    @PersistenceContext
    private EntityManager em;

    public PessoaDAO() {
        super(Pessoa.class);
    }
   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Pessoa> obterPorNome(String nome){
        Query query = em.createQuery("SELECT p FROM Pessoa p WHERE LOWER(p.nomeCompleto) LIKE LOWER(:nomecompleto)");
        query.setParameter("nomecompleto","%" + nome + "%");
        
        return query.getResultList();
    }
}
