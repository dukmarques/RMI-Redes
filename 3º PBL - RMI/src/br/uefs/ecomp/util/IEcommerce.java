package br.uefs.ecomp.util;

// @author Eduardo

import br.uefs.ecomp.model.Produto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface IEcommerce extends Remote{
    //Interface que defini a nomenclatura dos métodos remotos do RMI;
    
    //Método remoto para buscar os produtos do RMI;
    public LinkedList<Produto> getItens(String nomeLoja) throws RemoteException;
    
    //Método remoto para a compra de um produto;
    public boolean comprarProduto(String nomeLoja, String serial) throws RemoteException;
}
