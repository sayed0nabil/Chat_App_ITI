package org.example.Controller;

import org.example.IChatController;
import org.example.model.IClient;
import org.example.model.MSG;
import org.example.model.Notification;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImp extends UnicastRemoteObject implements IClient {

    protected ClientImp() throws RemoteException {
    }

    public ClientImp(IChatController view) throws RemoteException {

    }

    @Override
    public void receive(MSG message) throws RemoteException {

    }

    public void sendMessage(int id, MSG message){

    }
    @Override
    public void receiveNotification(Notification notification) throws RemoteException {

    }
}
