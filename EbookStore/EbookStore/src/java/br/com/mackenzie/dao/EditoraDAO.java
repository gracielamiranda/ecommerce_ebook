/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Editora;
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
public class EditoraDAO extends AbstractDAO<Editora>{
    
    @PersistenceContext
    private EntityManager em;

    public EditoraDAO() {
        super(Editora.class);
    }
    
    
    public List<Editora> obterPorNome(String nome){
        Query query = em.createQuery("SELECT e FROM Editora e WHERE LOWER(e.nome) LIKE LOWER(:nome)");
        query.setParameter("nome","%" + nome + "%");
        
        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
}
