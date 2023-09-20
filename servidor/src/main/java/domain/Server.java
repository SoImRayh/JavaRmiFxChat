package domain;

import domain.model.auth.Auth;
import domain.model.auth.AuthDto;
import domain.model.chat.Chat;
import domain.model.util.RemoteObserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {

    Auth requestAuth(AuthDto dto) throws RemoteException;
    void addObserverAndNotify(RemoteObserver observer) throws RemoteException;

    Chat createNewChat() throws RemoteException;
    boolean joinInAchat(RemoteObserver remoteObserver)throws  RemoteException;
    void postNewMessage(String message)throws RemoteException;
}
