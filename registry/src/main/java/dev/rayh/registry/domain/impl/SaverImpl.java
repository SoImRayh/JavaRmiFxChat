package dev.rayh.registry.domain.impl;

import dev.rayh.core.domain.chat.Message;
import dev.rayh.registry.domain.Saver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class SaverImpl extends UnicastRemoteObject implements Saver {

    private final List<Message> buffer = new LinkedList<>();

    public SaverImpl() throws RemoteException{
        super();
    }
    @Override
    public void save(Message message) throws RemoteException {
        buffer.add(message);
        System.out.println("messagem salva com sucesso: "+ message);
    }
}
