package RMI_SERVER;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import RMI_INTERFACE.ChatRoomInterface;
import RMI_INTERFACE.ClientInterface;

public class ChatRoom extends UnicastRemoteObject implements ChatRoomInterface {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -29158704217888500L;

	protected ChatRoom() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	List<ClientInterface> clients = new ArrayList<ClientInterface>();

	@Override
	public boolean connexion(ClientInterface c) throws RemoteException {
		clients.add(c);
		return true;
	}

	@Override
	public boolean deconnexion(ClientInterface c) throws RemoteException {
		clients.remove(c);
		return true;
	}


	@Override
	public void sendMessage(ClientInterface c, String message)
			throws RemoteException {
		for(ClientInterface  j : clients){
			System.out.println("notify");
			if(!j.equals(c)){
				j.notify(message);
			}
		}
		
	}

}
