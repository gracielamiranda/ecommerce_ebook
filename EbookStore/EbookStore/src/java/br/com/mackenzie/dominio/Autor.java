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
@TableGenerator(name="autor_seq",table="sequences", 
        pkColumnName="seq_nome",pkColumnValue="seq_autor", 
        valueColumnName="seq_valor")
@Entity
@Table(name="tb_autor")
public class Autor implements Serializable{
    
     @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="autor_seq")
    private int id;
    
    private String nome;
    
    @OneToMany(mappedBy="autor")
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
