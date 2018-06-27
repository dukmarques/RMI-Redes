package br.uefs.ecomp.model;

public class Produto {
    private String nome;
    private float valor;
    private String serial;
    private int quantidade;

    public Produto(String nome, float valor, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + " Nome: " + nome + ", Valor: " + valor + ", Quantidade: " + quantidade;
    }
    
    public String[] info(){
        String[] s = {nome,""+valor, ""+quantidade};
        return s;
    }
    
    public String[] infoCarrinho(){
        String[] s = {nome, ""+valor};
        return s;
    }
}