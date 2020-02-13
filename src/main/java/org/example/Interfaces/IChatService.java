package org.example.Interfaces;

import org.example.model.Message;
import org.example.model.Notification;
import org.example.model.User;
import org.example.model.UserStatus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChatService extends Remote {

    List<User> getFriendList(int userId) throws RemoteException;
    void changeStatus(UserStatus userStatus) throws RemoteException;
    Message sendMessage(User user) throws RemoteException;
    List<Notification>getNotifications() throws RemoteException;
    void register(User user) throws RemoteException;
    void unRegister(User user) throws RemoteException;
    void addFriend() throws RemoteException;
    void sendGroupMsg(User user, Message groupMessage) throws RemoteException;
}
