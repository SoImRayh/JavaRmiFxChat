package dev.rayh.server;


import dev.rayh.core.Server;
import dev.rayh.core.domain.chat.Message;
import dev.rayh.server.domain.ServerImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println("iniciando servidor");
        try{
            Message message = new Message();

            message.setText("alo");
            Server server = new ServerImpl();
            Registry registry = LocateRegistry.createRegistry(8081);

            Naming.rebind("rmi://localhost:8081/server", server);
        } catch (RemoteException e) {
            System.out.println("error: "+ e.getMessage());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
