package dev.rayh.registry;

import dev.rayh.registry.domain.Saver;
import dev.rayh.registry.domain.impl.SaverImpl;

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
    private static final int porta = 8081;

    public static void main( String[] args )
    {
        try {

            Registry registry = LocateRegistry.createRegistry(porta);

            Saver saver = new SaverImpl();
            Naming.rebind("rmi://localhost:8081/saver", saver );

            System.out.format("registry criado na porta: %d aguardando mensagens a serem salvas\n", porta);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
