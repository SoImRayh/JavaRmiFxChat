package domain.impl;

import domain.Server;
import domain.model.auth.Auth;
import domain.model.auth.AuthDto;
import domain.model.chat.Chat;
import domain.model.chat.Message;
import domain.model.util.Observer;
import domain.model.util.RemoteObserver;
import lombok.RequiredArgsConstructor;
import service.ServerService;
import service.impl.ServerServiceImpl;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class ServerImpl extends UnicastRemoteObject implements Server {

    private Chat chat = new Chat();

    public ServerImpl() throws RemoteException {
        super();
    }


    @Override
    public void join(RemoteObserver remoteObserver, Message message) throws RemoteException {
        chat.addUser(remoteObserver, message);
    }

    @Override
    public void sendMensage(Message message) throws RemoteException {
        chat.addMessage(message);
    }
}
