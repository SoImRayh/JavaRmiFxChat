package dev.rayh.core.util;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {
    void update(String s) throws RemoteException;
}
