package br.uefs.ecomp.view;

import br.uefs.ecomp.model.Produto;
import br.uefs.ecomp.util.ManipularArquivo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class View {
    public static void main(String[] args) throws IOException {
        ManipularArquivo arq = new ManipularArquivo();
        
        System.out.println(arq.lerArquivo());
    }
}