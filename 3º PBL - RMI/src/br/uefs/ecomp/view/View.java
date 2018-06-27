package br.uefs.ecomp.view;

import br.uefs.ecomp.model.Produto;
import br.uefs.ecomp.util.ManipularArquivo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class View {
    public static void main(String[] args) throws IOException {
        ManipularArquivo arq = new ManipularArquivo();
        
        LinkedList<Produto> lista = arq.lerDic();
        
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            System.out.println(p.toString());
        }
    }
}