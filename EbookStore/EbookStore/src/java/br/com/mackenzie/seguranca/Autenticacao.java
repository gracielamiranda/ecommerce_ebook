package br.com.mackenzie.seguranca;

import br.com.mackenzie.dao.UsuarioDAO;
import br.com.mackenzie.dominio.Usuario;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

public class Autenticacao {
    
    @EJB
    private UsuarioDAO usuarioDAO;
    
    public String login(String email,String senha,HttpSession session){
        Usuario usuario = usuarioDAO.obter(email, senha);
        
        if (usuario != null) {
            session.setAttribute(usuario.getEmail(), usuario);
        }
        
        return null;
    }
    
    public String logout(HttpSession session){
        session.invalidate();
        
        return null;
    }
}
