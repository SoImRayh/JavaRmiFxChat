package dev.rayh.core.util;

import dev.rayh.core.domain.chat.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteObserver extends Remote {
    void update(Message m) throws RemoteException;
    void update() throws  RemoteException;
}
