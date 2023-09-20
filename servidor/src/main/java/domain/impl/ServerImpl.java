package domain.impl;

import domain.Server;
import domain.model.auth.Auth;
import domain.model.auth.AuthDto;
import domain.model.chat.Chat;
import domain.model.util.RemoteObserver;
import service.ServerService;
import service.impl.ServerServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class ServerImpl extends UnicastRemoteObject implements Server {

    private final ServerService service = new ServerServiceImpl();

    private List<Chat> chats = new LinkedList<>();

    public ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public Auth requestAuth(AuthDto dto) throws RemoteException {
        if (Objects.isNull(dto))
            throw new RemoteException("dto is null");
        return new Auth( dto.getUser() , LocalDateTime.now().plusSeconds(60).toLocalDate());
    }

    @Override
    public void addObserverAndNotify(RemoteObserver observer) throws RemoteException {
        observer.update("updated!");
    }

    @Override
    public Chat createNewChat() throws RemoteException {
        Chat chat = new Chat();

        chats.add(chat);

        return chat;
    }

    @Override
    public boolean joinInAchat(RemoteObserver remoteObserver) throws RemoteException {
        if (chats.isEmpty()){
            return false;
        }
        Chat c = chats.get(0);
        c.addClient(remoteObserver);
        return true;
    }

    @Override
    public void postNewMessage(String message) throws RemoteException {
        Chat chat = chats.get(0);

        chat.addMessage(message);
    }


}
