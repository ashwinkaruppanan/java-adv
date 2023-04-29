package com.mycompany.zex1;

import java.rmi.Remote;
import java.rmi.*;

public interface Interface extends Remote{
    public String getString(String name) throws RemoteException;
}