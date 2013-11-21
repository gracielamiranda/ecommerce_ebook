/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.AutorDAO;
import br.com.mackenzie.dominio.Autor;
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
public class AutorManagedBean {
    
    private Autor autor;
    @EJB
    private AutorDAO autorDAO;
    
    public AutorManagedBean() {
        autor = new Autor();
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public List<Autor> getListaAutores(){
        return this.autorDAO.obterTodos();
    }
    
    public void salvarAutor(){
        this.autorDAO.inserir(autor);
    }
    
    public void limparAutor(){
        this.autor.setId(0);
        this.autor.setNome("");
    }
}
