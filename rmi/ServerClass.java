package com.mycompany.zex1;

import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServerClass extends UnicastRemoteObject implements Interface{
    public ServerClass() throws RemoteException {
        super();
    }
    
    public static void main(String[] args) {
        try {
            ServerClass sc = new ServerClass();
            Registry reg = LocateRegistry.createRegistry(8080);
            reg.bind("work", sc);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public String getString(String name) throws RemoteException{
         return "hello " + name;
    }
}
