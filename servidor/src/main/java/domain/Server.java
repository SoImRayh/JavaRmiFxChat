package domain;


import domain.model.chat.Message;
import domain.model.util.RemoteObserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {

    void join(RemoteObserver remoteObserver, Message message) throws RemoteException;

    void sendMensage(Message message)throws RemoteException;

}
