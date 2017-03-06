package RMI_INTERFACE;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ClientInterface extends Remote{
	void notify(Information i) throws RemoteException;
}
