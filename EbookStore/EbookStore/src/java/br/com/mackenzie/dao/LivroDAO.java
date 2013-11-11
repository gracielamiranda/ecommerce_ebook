/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Livro;
import br.com.mackenzie.dominio.Livro_;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Graciela Miranda
 */
@Stateless
public class LivroDAO extends AbstractDAO<Livro>{
    
    @PersistenceContext
    private EntityManager em;

    public LivroDAO() {
        super(Livro.class);
    }
    
    
    public List<Livro> obterPorTitulo(String titulo){
        Query query = em.createQuery("SELECT l FROM Livro l WHERE LOWER(l.titulo) LIKE LOWER(:titulo)");
        query.setParameter("titulo","%" + titulo + "%");
        
        return query.getResultList();
    }

    public List<Livro> obterPorCategoria(String nomeCategoria){
        Query query = em.createQuery("SELECT l FROM Livro l WHERE LOWER(l.genero.nome) LIKE LOWER(:nome)");
        query.setParameter("nome","%" + nomeCategoria + "%");
        
        return query.getResultList();
    }

    
    public List<Livro> obterPorAutor(String nomeAutor){
        Query query = em.createQuery("SELECT l FROM Livro l WHERE LOWER(l.autor.nome) LIKE LOWER(:nome)");
        query.setParameter("nome","%" + nomeAutor + "%");
        
        return query.getResultList();
    }
    
    public List<Livro> obterPorEditora(String nomeEditora){
        Query query = em.createQuery("SELECT l FROM Livro l WHERE LOWER(l.editora.nome) LIKE LOWER(:nome)");
        query.setParameter("nome","%" + nomeEditora + "%");
        
        return query.getResultList();
    }
    
    public List<Livro> obterLivrosOrdenados(int primeiroResultado,int resultadoMaximo,String campoOrdenacao,String criterioOrdenacao){
        Query query = em.createQuery("SELECT l FROM Livro l ORDER BY l." + campoOrdenacao + " " + criterioOrdenacao);
        query.setFirstResult(primeiroResultado);
        query.setMaxResults(resultadoMaximo);
        
        return query.getResultList();
    }
    
    public List<Livro> obterPorFiltro(Livro livro) throws ClassNotFoundException{
        CriteriaBuilder criBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Livro> query = criBuilder.createQuery(Livro.class);
        Root<Livro> l = query.from(Livro.class);
        List<Predicate> conditions =  new ArrayList<Predicate>();
        
        if(livro.getTitulo() != null && livro.getTitulo().isEmpty()) {
            conditions.add(criBuilder.like(l.get(Livro_.titulo),livro.getTitulo()));
        }
        
        return null;
        //ParameterExpression<Object> param = 
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
}
