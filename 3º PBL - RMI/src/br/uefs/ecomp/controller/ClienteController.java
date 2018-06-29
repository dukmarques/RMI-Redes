package br.uefs.ecomp.controller;

// @author Eduardo

import br.uefs.ecomp.model.Produto;
import br.uefs.ecomp.util.IEcommerce;
import br.uefs.ecomp.util.ManipularArquivo;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Iterator;
import java.util.LinkedList;

public class ClienteController {
    LinkedList<Produto> lista = new LinkedList<>(); //Lista de produtos;
    static IEcommerce obj = null; //Objeto do RMI;
    private String config; //String com o ip do Server RMI;
    Registry registry; //Registro do RMI;
    
    private void registrer(){
        try {
            if (config == null) {
                ManipularArquivo arq = new ManipularArquivo(); //Instancia da classe para manipular arquivos;
                config = arq.lerArquivo();
            }
            registry = LocateRegistry.getRegistry(config,1010);
            obj = (IEcommerce) registry.lookup("Server");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public LinkedList<Produto> getItens(String nomeLoja){
        try {
            lista = ManipularArquivo.lerDic();
            
            registrer();
            addProdutos(obj.getItens(nomeLoja));
            //lista = obj.getItens(nomeLoja);
            
            ManipularArquivo.escreverArquivo(lista.iterator());
            
            return lista;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    private void addProdutos(LinkedList<Produto> produto){
        Iterator itr = produto.iterator();
        
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            this.lista.add(p);
        }
    }
    
    public boolean comprarItem(String nomeLoja, String serial, String loja){
        boolean sucesso = false;
        try{
            if (!loja.equals("Saldao dos Computadores")) {
                return true;
            }
            
            sucesso = obj.comprarProduto(nomeLoja, serial);
            
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return sucesso;
    }
}