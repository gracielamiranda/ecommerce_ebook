/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.LivroDAO;
import br.com.mackenzie.dominio.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import com.google.gson.Gson;

/**
 *
 * @author Graciela Miranda
 */
@ManagedBean
@SessionScoped
public class LivroManagedBean {

    private List<Livro> listaLivros = new ArrayList<Livro>();
    private String textoBusca;
    private Livro livro;
    private int primeiroResultado;
    private int resultadoMaximo =10 ;
    @EJB
    private LivroDAO livroDAO;
    /**
     * Creates a new instance of livroManagedBean
     */
    public LivroManagedBean() {
        this.livro = new Livro();
    }

    public List<Livro> getListaLivros() {
      if(listaLivros.isEmpty()){
          listaLivros = livroDAO.obterLivrosOrdenados(primeiroResultado, resultadoMaximo, "qtdeVendida","DESC");
        
      }
      return listaLivros;
      
    }

    public int getPrimeiroResultado() {
        return primeiroResultado;
    }

    public void setPrimeiroResultado(int primeiroResultado) {
        this.primeiroResultado = primeiroResultado;
    }

    public int getResultadoMaximo() {
        return resultadoMaximo;
    }

    public void setResultadoMaximo(int resultadoMaximo) {
        this.resultadoMaximo = resultadoMaximo;
    }    
    
    public String getTextoBusca() {
        return textoBusca;
    }

    public void setTextoBusca(String textoBusca) {
        this.textoBusca = textoBusca;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro= livro;
    }
    
    public void salvarLivro(){
        this.livroDAO.inserir(livro);
    }
   
    public void buscar(){
        listaLivros = livroDAO.obterPorTitulo(textoBusca);   
    }   
    
    public void limparLivro(){
        
    }
    
    public String transformarObjetoEmJson(Livro livro){
        return new Gson().toJson(livro);
    }
    
}
