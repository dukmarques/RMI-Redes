package br.uefs.ecomp.controller;

// @author Eduardo

import br.uefs.ecomp.model.Produto;
import br.uefs.ecomp.util.IEcommerce;
import br.uefs.ecomp.util.ManipularArquivo;
import java.io.IOException;
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
    private LinkedList<Produto> listaItens = null;
    
    public ServerController() throws RemoteException {
        super();
    }
    
    public void registrarMetodos(){
        try {
            ServerController obj = new ServerController();
            System.setProperty("java.rmi.server.hostname", "192.168.25.190");
            Registry registry = LocateRegistry.createRegistry(1010);
            
            registry.bind("Server", obj);
            System.out.println("Registrado lista de itens na rede!");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public LinkedList<Produto> getItens(String nomeLoja) throws RemoteException {
        try{
            System.out.println("Invocação do método da lista de itens pela loja: " + nomeLoja);
            if (listaItens == null) {
                return listaItens = ManipularArquivo.lerDic();
            }else{
                return listaItens;
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    @Override
    public boolean comprarProduto(String nomeLoja, String serial) throws RemoteException {
        try{
            System.out.println("Invocação do método de compra pela loja: " + nomeLoja);
            Produto item = getItem(serial);
            
            if (item != null) {
                listaItens.remove(item);
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return true;
    }
    
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
}