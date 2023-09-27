package dev.rayh.server;


import dev.rayh.core.Server;
import dev.rayh.core.domain.chat.Message;
import dev.rayh.registry.domain.Saver;
import dev.rayh.server.domain.ServerImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
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
            Registry registry = LocateRegistry.getRegistry(8081);

            Saver saver = (Saver) Naming.lookup("rmi://localhost:8081/saver") ;
            Server server = new ServerImpl(saver);


            Naming.rebind("rmi://localhost:8081/server", server);
        } catch (RemoteException e) {
            System.out.println("error: "+ e.getMessage());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }

    }
}
