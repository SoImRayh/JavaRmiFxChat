
import domain.Server;
import domain.model.auth.Auth;
import domain.model.auth.AuthDto;
import domain.model.util.Observer;
import domain.model.util.RemoteObserver;
import domain.util.ClientObserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("iniciando o cliente");
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 8081);
            Server server = (Server) Naming.lookup("rmi://localhost:8081/server");

            RemoteObserver observer = new ClientObserver();
            server.addObserverAndNotify(observer);

            Thread.currentThread().wait(5000);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
