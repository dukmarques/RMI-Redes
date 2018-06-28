package br.uefs.ecomp.controller;

// @author Eduardo

import br.uefs.ecomp.model.Produto;
import br.uefs.ecomp.util.IEcommerce;
import br.uefs.ecomp.util.ManipularArquivo;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class ServerController extends UnicastRemoteObject implements IEcommerce{

    @Override
    public LinkedList<Produto> getItens() throws RemoteException {
        try{
            System.out.println("Invocação do método da lista de itens por: " + "decidirei isso");
            return ManipularArquivo.lerDic();
        }catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        return null;
    }
    
    public void registrarMetodos(){
        try {
            ServerController obj = new ServerController();
            System.setProperty("java.rmi.server.hostname", "192.168.25.190");
            Registry registry = LocateRegistry.createRegistry(1010);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}