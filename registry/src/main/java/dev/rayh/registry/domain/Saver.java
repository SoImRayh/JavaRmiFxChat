package dev.rayh.registry.domain;

import dev.rayh.core.domain.chat.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Saver extends Remote {

    public void save(Message message) throws RemoteException;
}
