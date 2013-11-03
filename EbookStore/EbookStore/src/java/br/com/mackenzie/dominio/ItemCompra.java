///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.mackenzie.dominio;
//
//import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
///**
// *
// * @author 71306579
// */
//@Entity
//@Table(name="tb_compra")
//public class ItemCompra implements Serializable{
//
//    @Id
//    @JoinColumn(name="id")
//    @OneToOne
//    private Compra compra;
//
//    @Id
//    @JoinColumn(name="id")    
//    @OneToOne
//    private Livro livro;
//    
//    private int qtde;
//
//    public Compra getCompra() {
//        return compra;
//    }
//
//    public void setCompra(Compra compra) {
//        this.compra = compra;
//    }
//
//    public Livro getLivro() {
//        return livro;
//    }
//
//    public void setLivro(Livro livro) {
//        this.livro = livro;
//    }
//
//    public int getQtde() {
//        return qtde;
//    }
//
//    public void setQtde(int qtde) {
//        this.qtde = qtde;
//    }
//    
//    
//}
