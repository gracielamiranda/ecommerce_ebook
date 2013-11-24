 /* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.dominio;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author 71306579
 */
@Entity
@Table(name="tb_item_compra")
public class ItemCompra implements Serializable{

    @Id
    @JoinColumn(name="id_compra",columnDefinition="id")
    @ManyToOne()
    private Compra compra;

    @Id
    @JoinColumn(name="id_livro",columnDefinition="id")
    @OneToOne
    private Livro livro;
    
    private int qtde;

    public ItemCompra(Livro livro, int qtde) {
        this.livro = livro;
        this.qtde = qtde;
    }

    public ItemCompra() {
    }
    
    

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    
}
