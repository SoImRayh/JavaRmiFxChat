package dev.rayh.core;


import dev.rayh.core.domain.chat.Message;
import dev.rayh.core.util.RemoteObserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {

    void join(RemoteObserver remoteObserver, Message message) throws RemoteException;

    void sendMensage(Message message)throws RemoteException;

}
