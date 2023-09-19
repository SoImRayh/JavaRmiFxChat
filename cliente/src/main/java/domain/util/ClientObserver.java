package domain.util;

import domain.model.util.Observer;
import domain.model.util.RemoteObserver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientObserver extends UnicastRemoteObject implements RemoteObserver {
    public ClientObserver() throws RemoteException {
        super();
    }

    @Override
    public void update(String s) {
        System.out.println(s);
    }
}
