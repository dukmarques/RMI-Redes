package br.uefs.ecomp.util;

// @author Eduardo

import br.uefs.ecomp.model.Produto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface IEcommerce extends Remote{
    //Interface de nomencçatura dos métodos remotos;
    
    //método para lista de produtos disponíveis;
    public LinkedList<Produto> getItens(String nomeLoja) throws RemoteException;
    
    //Método para compra de produto;
    public boolean comprarProduto(String nomeLoja, String serial) throws RemoteException;
}
