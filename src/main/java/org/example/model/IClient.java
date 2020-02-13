package org.example.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
   void receive(MSG message) throws RemoteException;
   void receiveNotification(Notification notification) throws RemoteException;
}