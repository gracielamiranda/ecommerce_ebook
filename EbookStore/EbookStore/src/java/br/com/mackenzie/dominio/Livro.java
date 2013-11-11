/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author 71306579
 */
@TableGenerator(name="livro_seq",table="sequences", 
        pkColumnName="seq_nome",pkColumnValue="seq_livro", 
        valueColumnName="seq_valor")
@Entity
@Table(name="tb_livro")
public class Livro implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="livro_seq")
    private int id;
  
    private String titulo;
    @Lob
    @Basic(fetch= FetchType.LAZY)
    private byte[] capa;
    
    @Column(name="qtde_pagina")
    private int qtdePagina;
    private String idioma;
    private String descricao;
    private double preco;
    @Column(name="qtde_vendida")
    private int qtdeVendida;
    
    @Lob
    @Basic(fetch= FetchType.LAZY)
    private byte[] arquivo;
    
    @ManyToOne
    private Editora editora;
    @ManyToOne
    private Genero genero;
    @ManyToOne
    private Autor autor;
    
    @OneToOne
    private EstoqueLivro estoqueLivro;

    public Livro() {
    }

    
    public Livro(String titulo, int qtdePagina, String idioma, String descricao, double preco, int qtdeVendida) {
        this.titulo = titulo;
        this.qtdePagina = qtdePagina;
        this.idioma = idioma;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdeVendida = qtdeVendida;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getCapa() {
        return capa;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public int getQtdePagina() {
        return qtdePagina;
    }

    public void setQtdePagina(int qtdePagina) {
        this.qtdePagina = qtdePagina;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public EstoqueLivro getEstoqueLivro() {
        return estoqueLivro;
    }

    public void setEstoqueLivro(EstoqueLivro estoqueLivro) {
        this.estoqueLivro = estoqueLivro;
    }
}
