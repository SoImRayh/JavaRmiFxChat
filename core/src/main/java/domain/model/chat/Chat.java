package domain.model.chat;

import domain.model.User;
import domain.model.util.Observer;
import lombok.Data;

import java.util.List;

@Data
public class Chat {
    private Long id;
    private List<Message> messages;
    private List<Observer> observers;
    private List<User> users;


}
