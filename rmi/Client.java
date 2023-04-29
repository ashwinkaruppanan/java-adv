package com.mycompany.zex1;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.*;
import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 8080);
            Interface i = (Interface)reg.lookup("work");
            System.out.println("Enter name:");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            System.err.println(i.getString(name));
        } catch (Exception e) {
        }
    }
}
