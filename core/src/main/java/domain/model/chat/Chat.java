package domain.model.chat;

import domain.model.User;
import domain.model.util.Observer;
import domain.model.util.RemoteObserver;
import lombok.Data;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

@Data
public class Chat implements Serializable {
    private Long id;
    private List<Message> messages;
    private List<RemoteObserver> observers;
    private List<User> users;

    public Chat(){
        id = 1L;
        messages = new LinkedList<>();
        observers = new LinkedList<>();
        users = new LinkedList<>();
    }

    //TODO implementar para aceitar uma classe Message
    public void addMessage(String message){
        Message m = new Message();
        m.setText(message);
        messages.add(m);

        notifyAllObservers(message);
    }

    private void notifyAllObservers(String message) {
        observers.forEach( obs -> {
            try {
                obs.update(message);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addClient(RemoteObserver remoteObserver) {
        observers.add(remoteObserver);
    }
}
