package br.uefs.ecomp.model;

import java.io.Serializable;

public class Produto implements Serializable{
    private String nome;
    private float valor;
    private String serial;
    private String loja;

    public Produto(String nome, float valor, String serial, String loja) {
        this.nome = nome;
        this.valor = valor;
        this.serial = serial;
        this.loja = loja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }
    
    @Override
    public String toString() {
        return "Produto: " + " Nome: " + nome + ", Valor: " + valor + ", Serial: " + serial;
    }
    
    public String[] info(){
        String[] s = {nome,""+valor, ""+serial};
        return s;
    }
    
    public String infoArquivo(){
        String s = "Nome: " + nome + " | Preço: " + valor + " | Serial: " + serial;
        return s;
    }
}