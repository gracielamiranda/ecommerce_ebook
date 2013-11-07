/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.beans;

import br.com.mackenzie.dao.GeneroDAO;
import br.com.mackenzie.dominio.Autor;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Graciela Miranda
 */
@ManagedBean
public class InicioManagedBean {

    @EJB
    private GeneroDAO generoDAO;
    private String nomeAutor;
    
    /**
     * Creates a new instance of InicioManagedBean
     */
    public InicioManagedBean() {
    }
    
    public void inserir(){
        
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
