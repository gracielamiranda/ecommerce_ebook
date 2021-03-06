package br.com.mackenzie.dominio;

import br.com.mackenzie.dominio.enumeracoes.Perfil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
    
    private String email;
    
    private String senha;
    
    @OneToMany(mappedBy="usuario",fetch = FetchType.LAZY)
    private List<Compra> compras; 
    
    @Enumerated
    private Perfil perfil;

    public Usuario(){
        
    }

    public Usuario(String email, String senha, Perfil perfil) {
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Usuario(String email, String senha, Perfil perfil, String nomeCompleto, String cpf, String telefone) {
        super(nomeCompleto, cpf, telefone);
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
