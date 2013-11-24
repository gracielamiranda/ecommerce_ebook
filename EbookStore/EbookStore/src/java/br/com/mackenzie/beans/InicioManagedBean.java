package br.com.mackenzie.beans;

import br.com.mackenzie.dao.LivroDAO;
import br.com.mackenzie.dominio.Livro;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class InicioManagedBean {

    @EJB
    private LivroDAO livroDAO;
    private String nomeAutor;
    
    public InicioManagedBean() {
        
    }
    
    public void inserir(){
        Livro livro = new Livro("Chico bento", 100, "Ingles", "um livro muito legal do chico bento", 29.90, 30);
        livro.setCapa("carrinho.png");
        Livro livro1 = new Livro("Turma da monica", 100, "Ingles", "um livro muito legal da turma da monica", 29.90, 2);
        livro1.setCapa("carrinho.png");
        Livro livro2 = new Livro("Os coisas", 100, "Ingles", "um livro muito legal dos coisas", 29.90, 100);
        livro2.setCapa("carrinho.png");
        Livro livro3 = new Livro("Xando o Filme", 100, "Ingles", "um livro muito legal xando o filme", 29.90, 0);        
        livro3.setCapa("carrinho.png");
        Livro livro4 = new Livro("Vc eh doida demais", 100, "Ingles", "um livro muito legal vc é doida demais", 29.90, 0);
        livro4.setCapa("carrinho.png");
        
        livroDAO.inserir(livro);
        livroDAO.inserir(livro1);
        livroDAO.inserir(livro2);
        livroDAO.inserir(livro3);
        livroDAO.inserir(livro4);
        
        
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
