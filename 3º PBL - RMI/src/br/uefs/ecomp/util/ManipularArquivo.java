package br.uefs.ecomp.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class ManipularArquivo {
    
    //Classe utilizada para ler o arquivo de texto contendo o ip do servidor.
    public String lerArquivo(){
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
}