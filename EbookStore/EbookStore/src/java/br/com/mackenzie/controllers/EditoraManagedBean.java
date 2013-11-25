package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.EditoraDAO;
import br.com.mackenzie.dao.LivroDAO;
import br.com.mackenzie.dominio.Editora;
import br.com.mackenzie.util.MensagemUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EditoraManagedBean implements Serializable{

    private Editora editora;
    @EJB
    private EditoraDAO editoraDAO;
    
    @EJB 
    private LivroDAO livroDAO;
    
    public EditoraManagedBean() {
        this.editora = new Editora();
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    public List<Editora> getListaEditoras(){
        return this.editoraDAO.obterTodos();
    }
    
    public void salvarEditora(){
       try{
           this.editoraDAO.inserir(editora);
           this.limparEditora();
           MensagemUtil.mensagemAviso("Cadastro incluido com sucesso.");
         }catch(Exception e){
            MensagemUtil.mensagemErro("Não foi possível concluir o cadastro. ");
        }
    }
    
    public void limparEditora(){
        this.editora.setId(0);
        this.editora.setNome("");
    }
    
    public void removerEditora(Editora e){
        try{
            if(livroDAO.obterPorEditora(e.getNome()).isEmpty()){
                editoraDAO.remover(e);
                MensagemUtil.mensagemAviso("Editora removida com sucesso. ");
            }else{
                MensagemUtil.mensagemErro("Essa editora não pode ser removida pois há livro(s) relacionadas a este item. ");
            }
        }catch(Exception ex){
                        MensagemUtil.mensagemErro("Não foi possível remover o item. ");

        }
    }
}
