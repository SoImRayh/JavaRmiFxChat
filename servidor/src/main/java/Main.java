import domain.Server;
import domain.impl.ServerImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        System.out.println("iniciando servidor");
        try{
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
