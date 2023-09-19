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
        service.addObserverAndNotify(observer);
    }


}
