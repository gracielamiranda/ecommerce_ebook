package br.com.mackenzie.beans;

import br.com.mackenzie.dao.GeneroDAO;
import br.com.mackenzie.dao.LivroDAO;
import br.com.mackenzie.dominio.Genero;
import br.com.mackenzie.dominio.Livro;
import static com.google.common.io.ByteStreams.toByteArray;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.derby.iapi.services.io.FileUtil;

@ManagedBean
@SessionScoped
public class InicioManagedBean implements Serializable{

    @EJB
    private LivroDAO livroDAO;
    @EJB
    private GeneroDAO generoDAO;
    
    private String nomeAutor;
    
    public InicioManagedBean() {
        
    }
    
    public void inserir(){
        
        Genero genero = new Genero();
        genero.setNome("jhahuajajja");
        generoDAO.inserir(genero);

                
        Genero genero2 = new Genero();
        genero2.setNome("skjandhauhsdoai");
        generoDAO.inserir(genero2);
        
        Livro livro = new Livro("Chico bento", 100, "Ingles", "um livro muito legal do chico bento", 29.90, 30);
        livro.setGenero(genero);
        livro.setCapa("carrinho.png");
        try {
                FileInputStream fis = new FileInputStream("C:/teste.pdf");  
                        
                byte[] bytes = toByteArray(fis);  
                livro.setArquivo(bytes);
         } catch (Exception e) {
                 
         }
        
        Livro livro1 = new Livro("Turma da monica", 100, "Ingles", "um livro muito legal da turma da monica", 29.90, 2);
        livro1.setCapa("carrinho.png");
        livro1.setGenero(genero2);
        
        try {
                FileInputStream fis = new FileInputStream("C:/teste.pdf");  
                        
                byte[] bytes = toByteArray(fis);  
                livro1.setArquivo(bytes);
         } catch (Exception e) {
                 
         }

        Livro livro2 = new Livro("Os coisas", 100, "Ingles", "um livro muito legal dos coisas", 29.90, 100);
        livro2.setCapa("carrinho.png");
        livro2.setGenero(genero);
        try {
                FileInputStream fis = new FileInputStream("C:/teste.pdf");  
                        
                byte[] bytes = toByteArray(fis);  
                livro2.setArquivo(bytes);
         } catch (Exception e) {
                 
         }
        Livro livro3 = new Livro("Xando o Filme", 100, "Ingles", "um livro muito legal xando o filme", 29.90, 0);        
        livro3.setCapa("carrinho.png");
        livro3.setGenero(genero2);
        try {
                FileInputStream fis = new FileInputStream("C:/teste.pdf");  
                        
                byte[] bytes = toByteArray(fis);  
                livro3.setArquivo(bytes);
         } catch (Exception e) {
                 
         }
        Livro livro4 = new Livro("Vc eh doida demais", 100, "Ingles", "um livro muito legal vc é doida demais", 29.90, 0);
        livro4.setCapa("carrinho.png");
        livro4.setGenero(genero);
        try {
                FileInputStream fis = new FileInputStream("C:/teste.pdf");  
                        
                byte[] bytes = toByteArray(fis);  
                livro4.setArquivo(bytes);
         } catch (Exception e) {
                 
         }
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
