package domain.model.util;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteObserver extends Remote {
    void update(String s) throws RemoteException;
}
