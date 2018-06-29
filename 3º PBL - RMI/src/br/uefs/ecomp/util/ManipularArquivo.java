package br.uefs.ecomp.util;

import br.uefs.ecomp.model.Produto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class ManipularArquivo {
    
    //Método utilizada para ler o arquivo de texto contendo o ip do servidor.
    public static String lerArquivo(){
        BufferedReader read = null;
        String l = null;
        try {
            read = new BufferedReader(new FileReader("config.txt"));
            l = read.readLine();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return l;
    }
    
    //Método utilizado para a escrita dos dados recebidos da loja pelo RMI.
    public static void escreverArquivo(Iterator itr){
        FileWriter file = null;
        try {
            file = new FileWriter("produtos.txt");
            PrintWriter escrever = new PrintWriter(file);
            
            escrever.println("Produtos da Loja Saldão dos Computadores");
            escrever.println("");
            while (itr.hasNext()) {
                Produto p = (Produto) itr.next();
                escrever.println(p.infoArquivo());
            }
            
            escrever.close(); //Fecha o arquivo depois que foi realizado a escrita.
        } catch (Exception e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
    
    //Classe utilizada para ler o arquivo de texto contendo os produtos a venda.
    public static LinkedList<Produto> lerDic() throws IOException{
        BufferedReader read = null;
        
        try {
            read = new BufferedReader(new FileReader("itens.txt"));
            String l;
            LinkedList<Produto> lista = new LinkedList<>();
            
            while ((l = read.readLine()) != null) {
                Produto p = trataString(l);
                lista.add(p);
            }
            read.close();
            
            return lista;
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo txt não encontrado!");
            return null;
        }
    }
    
    //Método responsável por tratar as strings obitidas pelo arquivo e instanciar um produto;
    private static Produto trataString(String linha){
        String[] texto = linha.split(";");
        Produto p = new Produto(texto[0], Float.parseFloat(texto[1]), texto[2], texto[3]);
        return p;
    }
}