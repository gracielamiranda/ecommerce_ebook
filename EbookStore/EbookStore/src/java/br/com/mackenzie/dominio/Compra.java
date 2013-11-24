package br.com.mackenzie.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_compra")
public class Compra implements Serializable{
    @Id
    private int id;
    
    @ManyToOne
    private Usuario usuario;
    
    @Column(name="data_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCompra;
    
    @OneToMany(mappedBy = "compra")
    private List<ItemCompra> itemCompras;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }   

    public List<ItemCompra> getItemCompras() {
        return itemCompras;
    }

    public void setItemCompras(List<ItemCompra> itemCompras) {
        this.itemCompras = itemCompras;
    }
    
    
}
