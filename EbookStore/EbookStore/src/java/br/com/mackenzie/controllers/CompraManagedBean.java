/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.controllers;

import br.com.mackenzie.dominio.Compra;
import br.com.mackenzie.dominio.ItemCompra;
import br.com.mackenzie.dominio.Livro;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author luizoscar.lima
 */
@ManagedBean
@SessionScoped
public class CompraManagedBean {

    private Compra compra;
    
    /**
     * Creates a new instance of CompraManagedBean
     */
    public CompraManagedBean() {
        compra = new Compra();
        compra.setItemCompras(new ArrayList<ItemCompra>());
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
    
    public String comprar(Livro livro){
        ItemCompra item = new ItemCompra(livro,1);
        if(compra == null){
            compra = new Compra();
            compra.setItemCompras(new ArrayList<ItemCompra>());
        }
        compra.getItemCompras().add(item);
        return "carrinho?faces-redirect=true";
    }
       
    
}
