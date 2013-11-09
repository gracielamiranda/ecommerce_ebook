/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Graciela Miranda
 */
@Stateless
public class AutorDAO extends AbstractDAO<Autor>{
    
    @PersistenceContext
    private EntityManager em;

    public AutorDAO() {
        super(Autor.class);
    }
    
    
    public List<Autor> obterPorNome(String nome){
        Query query = em.createQuery("SELECT a FROM Autor a WHERE LOWER(a.nome) LIKE LOWER(:nome)");
        query.setParameter("nome","%" + nome + "%");
        
        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
}
