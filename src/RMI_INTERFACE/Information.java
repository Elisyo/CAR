package RMI_INTERFACE;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Information extends Remote {

	public String getInformation(String info) throws RemoteException;
}
