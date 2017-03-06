package RMI_INTERFACE;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ChatRoomInterface extends Remote{
	boolean connexion(ClientInterface c) throws RemoteException;
	boolean deconnexion(ClientInterface c) throws RemoteException;
	void sendMessage(ClientInterface c, String message) throws RemoteException;
}
