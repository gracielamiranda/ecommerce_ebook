/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.AutorDAO;
import br.com.mackenzie.dao.LivroDAO;
import br.com.mackenzie.dominio.Autor;
import br.com.mackenzie.util.MensagemUtil;
import java.io.Serializable;
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
public class AutorManagedBean implements Serializable{
    
    private Autor autor;
    @EJB
    private AutorDAO autorDAO;
    
    @EJB 
    private LivroDAO livroDAO;
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
         try{
             this.autorDAO.inserir(autor);
             limparAutor();
             MensagemUtil.mensagemAviso("Cadastro incluido com sucesso");
         }catch(Exception e){
            MensagemUtil.mensagemErro("Não foi possível concluir o cadastro. ");
        }
    }
    
    public void limparAutor(){
        this.autor.setId(0);
        this.autor.setNome("");
    }
     public void removerAutor(Autor a){
        try{
            if(livroDAO.obterPorAutor(a.getNome()).isEmpty()){
                autorDAO.remover(a);
                MensagemUtil.mensagemAviso("Autor removido com sucesso. ");
            }else{
                MensagemUtil.mensagemErro("Esse Autor não pode ser removido pois há livro(s) relacionadas a este item. ");
            }
            
        }catch(Exception ex){
                        MensagemUtil.mensagemErro("Não foi possível remover o item. ");

        }
    }
}
