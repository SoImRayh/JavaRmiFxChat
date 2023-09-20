package domain.model.util;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface Observer extends Remote {
    void update(String s) throws RemoteException;
}
