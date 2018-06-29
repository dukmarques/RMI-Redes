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
    private LinkedList<Produto> listaItens = null;
    private LinkedList<Produto> listaVendidos = new LinkedList<>();
    
    public ServerController() throws RemoteException {
        super();
    }
    
    public void registrarMetodos(){
        try {
            ServerController obj = new ServerController();
            System.setProperty("java.rmi.server.hostname", InetAddress.getLocalHost().getHostAddress());
            Registry registry = LocateRegistry.createRegistry(1010);
            
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
    
    @Override
    synchronized public LinkedList<Produto> getItens(String nomeLoja) throws RemoteException {
        try{
            System.out.println("Invocação do método da lista de itens pela loja: " + nomeLoja);
            
            listaItens = ManipularArquivo.lerDic();
            return listaItens = removeVendidos();
//            if (listaItens == null) {
//                return listaItens = ManipularArquivo.lerDic();
//            }else{
//                return listaItens;
//            }
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    @Override
    synchronized public boolean comprarProduto(String nomeLoja, String serial) throws RemoteException {
        try{
            System.out.println("Invocação do método de compra pela loja: " + nomeLoja);
            Produto item = getItem(serial);
            
            if (item != null) {
                listaVendidos.add(item);
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
    
    private LinkedList<Produto> removeVendidos(){
        LinkedList<Produto> disponiveis = new LinkedList<>();
        Iterator itr = listaItens.iterator();
        
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            if (!verificaVendido(p.getSerial())) {
                disponiveis.add(p);
            }
        }
        
        return disponiveis;
    }
    
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