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
    
    //Método que cria o registro do RMI;
    private void registrer(){
        try {
            //Verifica se já foi feita a leitura do arquivo que contém o ip do server RMI;
            //Caso contrário, é feita a leitura;
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
    
    //Método utilizado para buscar os produtos a venda pelo RMI e por outras lojas;
    public LinkedList<Produto> getItens(String nomeLoja){
        try {
            lista = ManipularArquivo.lerDic(); //Ler os produtos que não pertencem ao RMI;
            
            registrer(); //Efetua o registro do RMI para acessar os métodos remotos;
            addProdutos(obj.getItens(nomeLoja)); //Busca os itens no RMI e os envia para o método que adicionará os produtos a lista de produtos;
            
            //Escreve em arquivo txt os produtos a venda;
            ManipularArquivo.escreverArquivo(lista.iterator());
            
            return lista;
            
        } catch (Exception e) {
            return null;
        }
    }
     //Adiciona os produtos obtidos pelo RMI a lista de produtos a venda;
    private void addProdutos(LinkedList<Produto> produto){
        Iterator itr = produto.iterator();
        
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            this.lista.add(p);
        }
    }
    
    //Método responsável pela compra de um produto;
    //Recebe como parametros o nome do site, o número de serie do produto e loja que está vendendo o produto;
    public boolean comprarItem(String nomeSite, String serial, String loja){
        boolean sucesso = false;
        try{
            //Verifica se o produto selecionado para compra foi obtido pelo RMI;
            if (!loja.equals("Saldao dos Computadores")) {
                return true;
            }
            //Acessa o método remoto para a compra do produto enviando o nome do site e o número de série;
            sucesso = obj.comprarProduto(nomeSite, serial);
            
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return sucesso;
    }
}