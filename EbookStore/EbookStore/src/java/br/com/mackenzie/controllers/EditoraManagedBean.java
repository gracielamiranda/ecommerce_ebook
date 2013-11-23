package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.EditoraDAO;
import br.com.mackenzie.dominio.Editora;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EditoraManagedBean {

    private Editora editora;
    @EJB
    private EditoraDAO editoraDAO;
    
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
        this.editoraDAO.inserir(editora);
        this.limparEditora();
    }
    
    public void limparEditora(){
        this.editora.setId(0);
        this.editora.setNome("");
    }
}
