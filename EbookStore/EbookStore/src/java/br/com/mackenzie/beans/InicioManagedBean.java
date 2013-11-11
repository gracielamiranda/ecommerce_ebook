/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.beans;

import br.com.mackenzie.dao.UsuarioDAO;
import br.com.mackenzie.dominio.Usuario;
import br.com.mackenzie.dominio.enumeracoes.Perfil;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Graciela Miranda
 */
@ManagedBean
@SessionScoped
public class InicioManagedBean {

    @EJB
    private UsuarioDAO usuarioDAO;
    private String nomeAutor;
    
    public InicioManagedBean() {
    }
    
    public void inserir(){
        
        Usuario usuario = new Usuario("luizoscar.lima@gmail.com", "123456", Perfil.Cliente, "luiz oscar lemos de lima", "05388077411", "954310462");
        usuarioDAO.inserir(usuario);
        
        Usuario usuarioAutenticado = usuarioDAO.obter("luizoscar.lima@gmail.com", "123456");
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest(); 
        HttpSession session = request.getSession();
        
        
    }
    public void  listarTodos(){
        
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
    
    
}
