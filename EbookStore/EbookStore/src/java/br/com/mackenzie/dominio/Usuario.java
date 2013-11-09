package br.com.mackenzie.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@TableGenerator(name="usuario_seq",table="sequences", 
        pkColumnName="seq_nome",pkColumnValue="seq_usuario", 
        valueColumnName="seq_valor")
@Entity
@Table(name="tb_usuario")
@PrimaryKeyJoinColumn(name="id")
public class Usuario extends Pessoa implements Serializable{
    
    private String login;
    
    private String senha;
    
    @OneToMany(mappedBy="usuario")
    private List<Compra> compras; 
        
    public enum Perfil {ADMINISTRADOR,CLIENTE};
    
    @Enumerated
    private Perfil perfil;

    public Usuario(String login, String senha, Perfil perfil) {
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Usuario(String login, String senha, Perfil perfil, String nomeCompleto, String cpf, String telefone, String email) {
        super(nomeCompleto, cpf, telefone, email);
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
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
    
    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
