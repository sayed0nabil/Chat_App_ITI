package org.example.Controller;

import org.example.IChatController;
import org.example.model.IClient;
import org.example.model.Message;
import org.example.model.Notification;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImp extends UnicastRemoteObject implements IClient {
    private IChatController view;

    protected ClientImp() throws RemoteException {
    }

    public ClientImp(IChatController view) throws RemoteException {
     this.view = view ;
    }

    @Override
    public void receive(Message message) throws RemoteException {

    }

    public void sendMessage(int id, Message message){

    }
    @Override
    public void receiveNotification(Notification notification) throws RemoteException {

    }
}
