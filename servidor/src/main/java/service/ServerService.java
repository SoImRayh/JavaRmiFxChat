package service;

import domain.model.util.Observer;
import domain.model.util.RemoteObserver;

public interface ServerService {
    void addObserverAndNotify(RemoteObserver observer);
}
