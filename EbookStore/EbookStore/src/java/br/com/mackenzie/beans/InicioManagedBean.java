/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.beans;

import br.com.mackenzie.dao.GeneroDAO;
import br.com.mackenzie.dao.UsuarioDAO;
import br.com.mackenzie.dominio.Autor;
import br.com.mackenzie.dominio.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Graciela Miranda
 */
@ManagedBean
public class InicioManagedBean {

    @EJB
    private UsuarioDAO usuarioDAO;
    private String nomeAutor;
    
    public InicioManagedBean() {
    }
    
    public void inserir(){
        Usuario usuario = new Usuario("luizoscar.lima@gmail.com", "123456", Usuario.Perfil.CLIENTE, "luiz oscar lemos de lima", "05388077411", "954310462");
        usuarioDAO.inserir(usuario);
        
        Usuario usuarioAutenticado = usuarioDAO.obter("luizoscar.lima@gmail.com", "123456");
        
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
