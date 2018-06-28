package br.uefs.ecomp.controller;

// @author Eduardo

import br.uefs.ecomp.model.Produto;
import br.uefs.ecomp.util.IEcommerce;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController {
    static LinkedList<Produto> lista = new LinkedList<>();
    static IEcommerce obj = null;
    Registry registry;
    
//    private void registrer(){
//        try {
//            registry = LocateRegistry.getRegistry("192.168.25.190",1010);
//            obj = (IEcommerce) registry.lookup("Server");
//        } catch (Exception e) {
//            System.out.println("Erro: " + e.getMessage());
//        }
//    }
    
    public LinkedList<Produto> getItens(){
        try {
            
            registry = LocateRegistry.getRegistry("192.168.25.190",1010);
            obj = (IEcommerce) registry.lookup("Server");
            lista = obj.getItens();
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Exceção: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
}