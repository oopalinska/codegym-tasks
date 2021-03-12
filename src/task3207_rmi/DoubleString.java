package task3207_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Two things to remember:
// 1. The interface has to extend Remote (marker interface)
// 2. All the methods need to throw RemoteException
public interface DoubleString extends Remote {
    String doubleString(String str) throws RemoteException;
}
