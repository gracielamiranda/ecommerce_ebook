/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.GeneroDAO;
import br.com.mackenzie.dominio.Genero;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author luizoscar.lima
 */
@ManagedBean
@RequestScoped
public class GeneroManagedBean {
    
    private Genero genero;
    @EJB
    private GeneroDAO generoDAO;
    
    public GeneroManagedBean() {
        genero = new Genero();
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public List<Genero> getListaGeneros(){
        return this.generoDAO.obterTodos();
    }
    
    public void salvarGenero(){
        this.generoDAO.inserir(genero);
        this.limparCamposGenero();
    }
    
    public void limparCamposGenero(){
        this.genero.setId(0);
        this.genero.setNome("");
    }
}
