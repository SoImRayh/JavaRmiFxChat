package domain;

import domain.model.auth.Auth;
import domain.model.auth.AuthDto;
import domain.model.chat.Chat;
import domain.model.chat.Message;
import domain.model.util.Observer;
import domain.model.util.RemoteObserver;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

public interface Server extends Remote {

    void join(RemoteObserver remoteObserver, Message message) throws RemoteException;

    void sendMensage(Message message)throws RemoteException;

}
