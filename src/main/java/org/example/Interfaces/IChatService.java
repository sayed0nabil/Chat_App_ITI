package org.example.Interfaces;

import org.example.model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChatService extends Remote {

    List<User> getFriendList(int userId) throws RemoteException;
    void changeStatus(UserStatus userStatus) throws RemoteException;
    MSG sendMessage(User user) throws RemoteException;
    List<Notification>getNotifications() throws RemoteException;
    void register(User user) throws RemoteException;
    void unRegister(User user) throws RemoteException;
    void addFriend() throws RemoteException;
    void sendGroupMsg(User user, MSG groupMessage) throws RemoteException;
}
