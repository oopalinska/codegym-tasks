package task3207_rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
Toward an RMI server

In the "Description" file I added my step-by-step instruction how to implement an RMI.
*/

public class Solution {
    // This variable is essential! Needs to be declared in both server and client main classes.
    // Here we have only one, because both "sides" (client and server) are here as two different threads
    // (just in order to make this task more condensed).
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //write your code here
            String result;
            try {
                DoubleString service = (DoubleString) registry.lookup(UNIC_BINDING_NAME);
                result = service.doubleString("lalala ");
                System.out.println(result);
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) {
        // Pretend we're starting an RMI server as the main thread
        Remote stub;
        try {
            registry = LocateRegistry.createRegistry(2099);
            final DoubleStringImpl service = new DoubleStringImpl();
            stub = UnicastRemoteObject.exportObject(service, 0);
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

        // Start the client
        CLIENT_THREAD.start();
    }
}
