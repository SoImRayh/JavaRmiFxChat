package service.impl;

import domain.model.util.Observer;
import domain.model.util.RemoteObserver;
import service.ServerService;

import java.util.ArrayList;
import java.util.List;

public class ServerServiceImpl implements ServerService {
    @Override
    public void addObserverAndNotify(RemoteObserver observer) {
        List<Observer> observers = new ArrayList<>();

        //observers.add(observer);

        //observer.update("evento disparado");
    }
}
