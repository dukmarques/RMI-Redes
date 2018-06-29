package br.uefs.ecomp.controller;

// @author Eduardo

import br.uefs.ecomp.model.Produto;
import br.uefs.ecomp.util.IEcommerce;
import br.uefs.ecomp.util.ManipularArquivo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerController extends UnicastRemoteObject implements IEcommerce{
    private LinkedList<Produto> listaItens = null; //Lista de produtos disponiceis para serem vendidos;
    private LinkedList<Produto> listaVendidos = new LinkedList<>(); //Lista de produtos que já foram vendidos;
    
    public ServerController() throws RemoteException {
        super();
    }
    
    //Método responsável por registrar os métodos remotos na rede;
    public void registrarMetodos(){
        try {
            ServerController obj = new ServerController();
            //Registra o server RMI em rede;
            System.setProperty("java.rmi.server.hostname", InetAddress.getLocalHost().getHostAddress());
            Registry registry = LocateRegistry.createRegistry(1010);
            
            //Realiza o registro dos métodos remotos;
            registry.bind("Server", obj);
            System.out.println("Registrado lista de itens na rede!");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método remoto que retorna a lista de produtos disponíveis a venda;
    @Override
    synchronized public LinkedList<Produto> getItens(String nomeLoja) throws RemoteException {
        try{
            System.out.println("Invocação do método da lista de itens pela loja: " + nomeLoja);
            
            //Ler o arquivo de texto que contém os produtos a venda;
            listaItens = ManipularArquivo.lerDic();
            //Retorna a lista de produtos após remover os produtos que já foram vendidos através do método removeVendidos;
            return listaItens = removeVendidos();
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    //Método remoto utilizado para compra de produto;
    @Override
    synchronized public boolean comprarProduto(String nomeLoja, String serial) throws RemoteException {
        try{
            System.out.println("Invocação do método de compra pela loja: " + nomeLoja);
            Produto item = getItem(serial); //Obtem o produto através do número de série;
            
            if (item != null) {
                listaVendidos.add(item); //Add o produto na lista de vendidos;
                listaItens.remove(item); //Remove o produto da lista de itens disponiveis;
                return true; //Retorna a confirmção de compra;
            }else{
                return false; //Caso o item já esteja vendido, retorna uma negação da compra;
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return true;
    }
    
    //Obtem o produto pelo número de série;
    private Produto getItem(String serial){
        Iterator itr = listaItens.iterator();
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            if (p.getSerial().equals(serial)) {
                return p;
            }
        }
        return null;
    }
    
    //Método que remove os itens que já foram vendidos da lista de itens disponiveis toda vez que é feita uma leitura
    //do arquivo de texto que contém os produtos a venda;
    private LinkedList<Produto> removeVendidos(){
        LinkedList<Produto> disponiveis = new LinkedList<>(); //cria uma lista temporária para guardar os produtos disponiveis a venda;
        Iterator itr = listaItens.iterator();
        
        //Percore a lista de produtos que foi lido do arquivo txt e verica se cada produto está disponível;
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            if (!verificaVendido(p.getSerial())) { //se o produto estiver disponível é inserido na lista;
                disponiveis.add(p);
            }
        }
        
        return disponiveis;
    }
    
    //Método que busca verifica se o produto está presente na lita de produto já vendidos;
    private boolean verificaVendido(String serial){
        Iterator itr = listaVendidos.iterator();
        
        if (!listaVendidos.isEmpty()) {
            while (itr.hasNext()) {
                Produto p = (Produto) itr.next();
                if (p.getSerial().equals(serial)) {
                    return true;
                }
            }
        }
        return false;
    }
}