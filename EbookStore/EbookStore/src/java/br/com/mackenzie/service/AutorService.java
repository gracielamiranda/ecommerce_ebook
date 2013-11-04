package br.com.mackenzie.service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.mackenzie.dominio.Autor;
import br.com.mackenzie.dominio.Genero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class AutorService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void inserir(Autor autor){
        entityManager.persist(autor);
    }
    public List<Autor> listarAutores(){
        
        CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
        query.select(query.from(Autor.class));
        List<Autor> resultado = entityManager.createQuery(query).getResultList();
        
        for (Autor autor : resultado) {
            System.out.println(autor.getNome());
        }
        
        return resultado;
    }
}
