package domain.util;

import domain.model.chat.Message;
import domain.model.util.Observer;
import domain.model.util.RemoteObserver;
import lombok.Data;
import misc.ConsolePrinter;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Data
public class ClientObserver extends UnicastRemoteObject implements RemoteObserver , Serializable {

    String user;
    public ClientObserver(String user) throws RemoteException {
        super();
        this.user = user;
    }

    @Override
    public void update(Message s) throws RemoteException{
        if (!s.getUser().equals(user)){
            ConsolePrinter.WARNING(s.getUser(), s.getText());
        }
    }

    @Override
    public void update() throws RemoteException {

    }
}
