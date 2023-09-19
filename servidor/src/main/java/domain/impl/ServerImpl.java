package domain.impl;

import domain.Server;
import domain.model.auth.Auth;
import domain.model.auth.AuthDto;
import domain.model.util.Observer;
import domain.model.util.RemoteObserver;
import lombok.RequiredArgsConstructor;
import service.ServerService;
import service.impl.ServerServiceImpl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.Objects;


public class ServerImpl extends UnicastRemoteObject implements Server {

    private final ServerService service = new ServerServiceImpl();

    private List<Chat> chats = new ArrayList<>();

    public ServerImpl() throws RemoteException {
        super();
    }

    @Override
    Auth requestAuth(AuthDto dto) throws RemoteException {
        return service.doLoginUsingRemoteServer(AuthDto);
    };
    
    @Override
    List<Chat> getChats() throws RemoteException {
        return chats;
    };
    
    @Override
    boolean sendMessage() throws RemoteException;
    
    @Override
    boolean quitChat() throws RemoteException;


}
