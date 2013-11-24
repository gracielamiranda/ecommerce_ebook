/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.UsuarioDAO;
import br.com.mackenzie.dominio.Usuario;
import br.com.mackenzie.dominio.enumeracoes.Perfil;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author luizoscar.lima
 */
@ManagedBean(name = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean {

    private Usuario usuarioFormulario;
    private Usuario usuarioLogado;
    @EJB
    private UsuarioDAO usuarioDAO;
    private boolean adm;

    public UsuarioManagedBean() {
        this.usuarioFormulario = new Usuario();
    }

    public Usuario getUsuarioFormulario() {
        return usuarioFormulario;
    }

    public void setUsuarioFormulario(Usuario usuario) {
        this.usuarioFormulario = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    public String entrar() {
        String url = "index?faces-redirect=true";
        this.usuarioLogado = this.usuarioDAO.obter(this.usuarioFormulario.getEmail(), this.usuarioFormulario.getSenha());
        if (this.usuarioLogado == null) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informe o usuário e senha corretamente" ,"Informe o usuário e senha corretamente" );
            FacesContext.getCurrentInstance().addMessage(null, m);
            url = "login";
        }
        
        this.limparObjetoUsuario();
        
        return url;
    }

    public void sair() {
    }

    public void criar() {
        usuarioFormulario.setPerfil(Perfil.Cliente);
        this.usuarioDAO.inserir(usuarioFormulario);
        this.limparObjetoUsuario();
    }
    
    public void limparObjetoUsuario(){
        this.setUsuarioFormulario(new Usuario());
    }
    
    public String getLoginUsuario(){
        String loginUsuario = "visitante";
        inserirUsuarioAdm();

        if (this.usuarioLogado != null) {
            loginUsuario = this.usuarioLogado.getEmail();
        }
        
        return loginUsuario;
    }
    
    public String urlAutenticado(){
        String url = "login?faces-redirect=true";
        if (usuarioLogado != null) {
                url = "minhapagina?faces-redirect=true";
        }
        
        return url;
    }
    
    public Boolean usuarioEhAdministrador(){
        return this.usuarioLogado.getPerfil().equals(Perfil.Administrador);
    }
    
    private void inserirUsuarioAdm() {
        if(!adm) {
            Usuario usuario = new Usuario("adm@adm.com", "adm", Perfil.Administrador);
            usuarioDAO.inserir(usuario);
            adm = true;
        }
    }
    
    public String logout(){
       this.usuarioLogado = null;
       
       return "index?faces-redirect=true";
    }
}
