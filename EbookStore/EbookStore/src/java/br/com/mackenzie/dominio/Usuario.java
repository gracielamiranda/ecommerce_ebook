/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author 71306579
 */
@TableGenerator(name="usuario_seq",table="sequences", 
        pkColumnName="seq_nome",pkColumnValue="seq_usuario", 
        valueColumnName="seq_valor")
@Entity
@Table(name="tb_usuario")
@Inheritance(strategy= InheritanceType.JOINED)
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="usuario_seq")
    private int id;
    private String nome;
    private String login;
    private String senha;
    
    public enum Perfil {ADMINISTRADOR,CLIENTE};
    
    @Enumerated
    private Perfil perfil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    
    
}
