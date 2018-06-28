package br.uefs.ecomp.util;

import br.uefs.ecomp.model.Produto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ManipularArquivo {
    
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
    
    private static Produto trataString(String linha){
        String[] texto = linha.split(";");
        Produto p = new Produto(texto[0], Float.parseFloat(texto[1]), texto[2]);
        return p;
    }
}