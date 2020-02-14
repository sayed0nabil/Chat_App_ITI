package org.example.Interfaces;

import org.example.model.Message;

import java.rmi.Remote;

public interface IUserService extends Remote {

    void receiveMessage(Message message);
}
