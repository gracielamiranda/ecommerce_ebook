package br.com.mackenzie.dao;

import br.com.mackenzie.dominio.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
