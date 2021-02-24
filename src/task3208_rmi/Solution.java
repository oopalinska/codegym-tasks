package task3208_rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
RMI (part 2)

COME BACK TO THIS TASK
(I don't know how it works)
*/

public class Solution {
    public static final String UNIC_BINDING_NAME = "animals.behaviour";
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //write your code here
            try {
                Cat cat = new Cat("Koń");
                Dog dog = new Dog("Azor");
                registry = LocateRegistry.createRegistry(2099);
                Remote stub1 = UnicastRemoteObject.exportObject(cat, 2099);
                Remote stub2 = UnicastRemoteObject.exportObject(dog, 2099);
                registry.bind(UNIC_BINDING_NAME, stub1);
                registry.bind(UNIC_BINDING_NAME, stub2);
            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
