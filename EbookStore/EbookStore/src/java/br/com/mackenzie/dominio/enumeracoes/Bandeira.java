package br.com.mackenzie.dominio.enumeracoes;

public enum Bandeira {
    Visa(1), 
    Master(2);

    private final int valor;
    
    private Bandeira(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
    
}
