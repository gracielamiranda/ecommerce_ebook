/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.GeneroDAO;
import br.com.mackenzie.dominio.Genero;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Graciela Miranda
 */
@ManagedBean
@SessionScoped
public class HomeManagedBean {

    private List<Genero> listaGenero =  new ArrayList<Genero>();
    private String usuario;
    private String textoBusca;
    @EJB
    private GeneroDAO generoDAO;
    /**
     * Creates a new instance of HomeManagedBean
     */
    public HomeManagedBean() {
        usuario = "Visitante";
    }

    public List<Genero> getListaGenero() {
        if(listaGenero.isEmpty()){
            listaGenero = generoDAO.obterTodos();
        }
        return listaGenero;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
   
    
    public String buscar(){
        return "index";
        
    }
    
    
    
}
