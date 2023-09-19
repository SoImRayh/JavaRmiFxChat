package domain.model.util;

import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

public interface Observer {
    void update(String s);
}
