/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.AutorDAO;
import br.com.mackenzie.dao.EditoraDAO;
import br.com.mackenzie.dao.GeneroDAO;
import br.com.mackenzie.dao.LivroDAO;
import br.com.mackenzie.dominio.Genero;
import br.com.mackenzie.dominio.Livro;
import static com.google.common.io.ByteStreams.toByteArray;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Graciela Miranda
 */
@ManagedBean
@SessionScoped
public class LivroManagedBean {

    private final String PATH_IMAGES =  FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "/resources/images/";  
    private String editoraSelecionadaId;
    private String generoSelecionadoId;
    private String autorSelecionadoId;
    private List<Livro> listaLivros = new ArrayList<Livro>();
    private String textoBusca;
    private Livro livro;
    private int primeiroResultado;
    private int resultadoMaximo = 10 ;
    private Part arquivoLivro;
    private Part capaLivro;

    @EJB
    private LivroDAO livroDAO;
    @EJB
    private EditoraDAO editoraDAO;
    @EJB
    private GeneroDAO generoDAO;
    @EJB
    private AutorDAO autorDAO;
   
    public LivroManagedBean() {
        this.livro = new Livro();
    }

    public List<Livro> getListaLivros() {      
      return this.listaLivros;      
    }

    public String getEditoraSelecionadaId() {
        return editoraSelecionadaId;
    }

    public void setEditoraSelecionadaId(String editoraSelecionadaId) {
        this.editoraSelecionadaId = editoraSelecionadaId;
    }

    public String getGeneroSelecionadoId() {
        return generoSelecionadoId;
    }

    public void setGeneroSelecionadoId(String generoSelecionadoId) {
        this.generoSelecionadoId = generoSelecionadoId;
    }

    public String getAutorSelecionadoId() {
        return autorSelecionadoId;
    }

    public void setAutorSelecionadoId(String autorSelecionadoId) {
        this.autorSelecionadoId = autorSelecionadoId;
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

    public Part getArquivoLivro() {
        return arquivoLivro;
    }

    public void setArquivoLivro(Part arquivoLivro) {
        this.arquivoLivro = arquivoLivro;
    }

    public Part getCapaLivro() {
        return capaLivro;
    }

    public void setCapaLivro(Part capaLivro) {
        this.capaLivro = capaLivro;
    }
       
    public void salvarLivro() throws IOException{
        this.livro.setGenero(generoDAO.obter(Integer.parseInt(this.generoSelecionadoId)));
        this.livro.setAutor(autorDAO.obter(Integer.parseInt(this.autorSelecionadoId)));
        this.livro.setEditora(editoraDAO.obter(Integer.parseInt(this.editoraSelecionadaId)));
        salvarCapa(capaLivro);
        this.livro.setCapa(capaLivro.getSubmittedFileName());
        this.livro.setArquivo(toByteArray(this.arquivoLivro.getInputStream()));
        this.livroDAO.inserir(livro);
        
        this.limparLivro();
    }
   
    public void buscar(){
        this.listaLivros = livroDAO.obterPorTitulo(textoBusca);   
        this.textoBusca = "";

    }   
    
    public void limparLivro(){
        this.setLivro(new Livro());
    }
    
    public String transformarObjetoEmJson(Livro livro){
        return new Gson().toJson(livro);
    }    

    private void salvarCapa(Part capa) {
        try{
            File file = new File(PATH_IMAGES, capa.getSubmittedFileName());
            FileOutputStream os = new FileOutputStream(file);
            os.write(toByteArray(capa.getInputStream()));
            os.flush();
            os.close();
        }catch(IOException io){
          FacesContext context = FacesContext.getCurrentInstance(); 
          context.addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Não foi possível incluir o livro "));     
        }
    }
    
    
    public String index(){
        this.listaLivros = livroDAO.obterLivrosOrdenados(primeiroResultado, resultadoMaximo, "qtdeVendida", "DESC");
        return "index?faces-redirect=true";
    }
    
    public void buscarPorGenero(Genero genero){
        this.listaLivros = livroDAO.obterPorGenero(genero.getNome());
    }
    
    public void buscarMaisComprados(){
        this.listaLivros = livroDAO.obterLivrosOrdenados(primeiroResultado, resultadoMaximo, "qtdeVendida", "DESC");
    }
}
