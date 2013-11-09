/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author 71306579
 */
@TableGenerator(name="genero_seq",table="sequences", 
        pkColumnName="seq_nome",pkColumnValue="seq_genero", 
        valueColumnName="seq_valor")
@Entity
@Table(name="tb_genero")
public class Genero implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="genero_seq")
    private int id;
    
    private String nome;
    
    @OneToMany(mappedBy="genero")
    private List<Livro> livros; 

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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
            
}
