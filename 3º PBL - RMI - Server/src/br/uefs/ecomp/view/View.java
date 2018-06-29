package br.uefs.ecomp.view;

// * @author Eduardo

import br.uefs.ecomp.controller.ServerController;
import java.rmi.RemoteException;


public class View {
    public static void main(String[] args) throws RemoteException {
        ServerController c = new ServerController();
        
        //Registra os métodos remotos na rede RMI;
        c.registrarMetodos();
    }
}