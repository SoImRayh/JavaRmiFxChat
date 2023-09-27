package dev.rayh.server.domain;

import dev.rayh.core.domain.chat.Chat;
import dev.rayh.core.domain.chat.Message;
import dev.rayh.core.Server;
import dev.rayh.core.util.RemoteObserver;
import dev.rayh.registry.domain.Saver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServerImpl extends UnicastRemoteObject implements Server {

    private Saver saver;
    private Chat chat = new Chat();

    public ServerImpl() throws RemoteException {
        super();
    }
    public ServerImpl(Saver saver) throws RemoteException {
        super();
        this.saver = saver;
    }


    @Override
    public void join(RemoteObserver remoteObserver, Message message) throws RemoteException {
        chat.addUser(remoteObserver, message);
    }

    @Override
    public void sendMensage(Message message) throws RemoteException {
        chat.addMessage(message);
        saver.save(message);
    }
}
