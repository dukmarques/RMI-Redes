package br.uefs.ecomp.model;

public class Produto {
    private String nome;
    private float valor;
    private String serial;

    public Produto(String nome, float valor, String serial) {
        this.nome = nome;
        this.valor = valor;
        this.serial = serial;
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
}