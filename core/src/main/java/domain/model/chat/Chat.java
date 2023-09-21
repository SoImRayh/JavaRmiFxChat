package domain.model.chat;

import domain.model.User;
import domain.model.util.Observer;
import domain.model.util.RemoteObserver;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Data
public class Chat implements Serializable {
    private List<Message> messages;
    private List<RemoteObserver> observers;


    public Chat(){
        messages = new LinkedList<>();
        observers = new LinkedList<>();
    }

    public void addUser(RemoteObserver remoteObserver, Message message){
      observers.add(remoteObserver);
      notifyAllusers(message);
    };

    public void addMessage(Message message){
        messages.add(message);
        notifyAllusers(message);
    }

    void notifyAllusers(Message message){

        for (RemoteObserver observer : observers) {
            try {
                observer.update(message);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
