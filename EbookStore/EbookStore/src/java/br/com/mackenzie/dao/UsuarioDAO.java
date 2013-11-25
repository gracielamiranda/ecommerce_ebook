package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario>{

    @PersistenceContext
    private EntityManager em;
    
    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Usuario obterPorEmail(String email){
        Query query = em.createQuery("SELECT u FROM Usuario u JOIN FETCH u.compras WHERE u.email = :email");
        query.setParameter("email",email);
        
        return (Usuario)query.getSingleResult();
    }
    
    public Usuario obter(String email,String senha){
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha");
        query.setParameter("email",email);
        query.setParameter("senha", senha);
        
        List<Usuario> resultados = query.getResultList();
        
        return resultados.size() > 0 ? resultados.get(0): null;
    }
}
