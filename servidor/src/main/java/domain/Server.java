package domain;

import domain.model.auth.Auth;
import domain.model.auth.AuthDto;
import domain.model.util.Observer;
import domain.model.util.RemoteObserver;
import domain.model.chat.Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Server extends Remote {

    Auth requestAuth(AuthDto dto) throws RemoteException;
    List<Chat> getChats() throws RemoteException;
    boolean sendMessage() throws RemoteException;
    boolean quitChat() throws RemoteException;
}
