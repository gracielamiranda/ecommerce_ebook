package br.com.mackenzie.controllers;

import br.com.mackenzie.dao.CompraDAO;
import br.com.mackenzie.dao.ItemCompraDAO;
import br.com.mackenzie.dominio.Compra;
import br.com.mackenzie.dominio.ItemCompra;
import br.com.mackenzie.dominio.Livro;
import br.com.mackenzie.dominio.enumeracoes.Bandeira;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CompraManagedBean {

    private Compra compra;
    
    private List<ItemCompra> itensCompra;
    
    private int idBandeiraSelecionada;
    
    @EJB
    private CompraDAO compraDAO;
    
    @EJB
    private ItemCompraDAO itemCompraDAO;
    
    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
    
    public CompraManagedBean() {
        compra = new Compra();
        itensCompra = new ArrayList<ItemCompra>();
    }

    public Compra getCompra() {
        if(compra == null){
            compra = new Compra();
            compra.setItemCompras(new ArrayList<ItemCompra>());
        }
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public int getIdBandeiraSelecionada() {
        return idBandeiraSelecionada;
    }

    public void setIdBandeiraSelecionada(int idBandeiraSelecionada) {
        this.idBandeiraSelecionada = idBandeiraSelecionada;
    }

    public UsuarioManagedBean getUsuarioManagedBean() {
        return usuarioManagedBean;
    }

    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
        this.usuarioManagedBean = usuarioManagedBean;
    }

    public List<ItemCompra> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItemCompra> itensCompra) {
        this.itensCompra = itensCompra;
    }
    
    public String comprar(Livro livro){
        ItemCompra item = new ItemCompra(livro, 1);
        this.itensCompra.add(item);
        return "carrinho?faces-redirect=true";
    }
    
    public String finalizarCompra(){
        String url = "minhapagina?faces-redirect=true";
        if (compra != null) {
            Bandeira bandeira = Bandeira.Visa;
            switch(this.idBandeiraSelecionada){
                case 1:
                    bandeira = Bandeira.Visa;
                    break;
                case 2:
                    bandeira = Bandeira.Master;
                    break;
            }
            this.compra.getCartao().setBandeira(bandeira);
            this.compra.setUsuario(usuarioManagedBean.getUsuarioLogado());
            this.compra.setDataCompra(Calendar.getInstance());
            this.compraDAO.inserir(compra);
            
            for (ItemCompra itemCompra : this.itensCompra) {
                itemCompra.setCompra(compra);
                this.itemCompraDAO.inserir(itemCompra);
            }
        }
        
        return url;
    }
       
    public String removerItemCarrinho(ItemCompra itemCompra){
        this.itensCompra.remove(itemCompra);
        
        return "carrinho?faces-redirect=true";
    }
    
    public String valorTotalCompra(){
        double soma = 0;
        
        for (ItemCompra item : this.itensCompra) {
            soma += item.getLivro().getPreco();
        }
        
        return String.format("%.2f",soma);
    }
    
}
