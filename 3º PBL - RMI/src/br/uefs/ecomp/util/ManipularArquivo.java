package br.uefs.ecomp.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManipularArquivo {
    
    //Classe utilizada para ler o arquivo de texto contendo os produtos a venda.
    public String[] lerArquivo() throws FileNotFoundException, IOException{
        BufferedReader read = new BufferedReader(new FileReader("A_DEFINIR.txt"));
        
        String l;
        String[] config = new String[2];
        
        for (int i = 0; i < 2; i++) {
            l = read.readLine();
            config[i] = l;
        }
        return config;
    }
}