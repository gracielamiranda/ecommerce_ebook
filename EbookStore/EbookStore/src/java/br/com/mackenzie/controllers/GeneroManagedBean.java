/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.GeneroDAO;
import br.com.mackenzie.dao.LivroDAO;
import br.com.mackenzie.dominio.Genero;
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
public class GeneroManagedBean implements Serializable{
    
    private Genero genero;
    @EJB
    private GeneroDAO generoDAO;
    @EJB
    private LivroDAO livroDAO;
    
    
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
        try{
            this.generoDAO.inserir(genero);
            this.limparCamposGenero();
            MensagemUtil.mensagemAviso("Cadastro incluido com sucesso");
         }catch(Exception e){
            MensagemUtil.mensagemErro("Não foi possível concluir o cadastro. ");
        }
    }
    
    public void limparCamposGenero(){
        this.genero.setId(0);
        this.genero.setNome("");
    }
    
     public void removerGenero(Genero g){
        try{
             if(livroDAO.obterPorGenero(g.getNome()).isEmpty()){
                generoDAO.remover(g);
                MensagemUtil.mensagemAviso("Genero removido com sucesso. ");
            }else{
                MensagemUtil.mensagemErro("Esse Genero não pode ser removido pois há livro(s) relacionadas a este item. ");
            }
            
            
        }catch(Exception ex){
                        MensagemUtil.mensagemErro("Não foi possível remover o item. ");

        }
    }
}
