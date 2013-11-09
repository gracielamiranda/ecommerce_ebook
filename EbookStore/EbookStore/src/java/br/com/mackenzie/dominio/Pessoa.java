package br.com.mackenzie.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@TableGenerator(name="pessoa_seq",table="sequences", 
        pkColumnName="seq_nome",pkColumnValue="seq_pessoa", 
        valueColumnName="seq_valor")
@Entity
@Table(name="tb_pessoa")
@Inheritance(strategy= InheritanceType.JOINED)
public class Pessoa implements Serializable{
  
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "pessoa_seq")
    private int id;
    private String nomeCompleto;
    private String cpf;
    private String telefone;
    
    public Pessoa() {
    }

    public Pessoa(String nomeCompleto, String cpf, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
