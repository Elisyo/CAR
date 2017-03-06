package RMI_SERVER;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import RMI_CLIENT.Client;
import RMI_INTERFACE.ChatRoomInterface;
import RMI_INTERFACE.ClientInterface;
import RMI_INTERFACE.Information;

public class ChatRoom implements ChatRoomInterface{
	
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
	public void sendMessage(ClientInterface c, Information i)
			throws RemoteException {
		for(ClientInterface  j : clients){
			if(!j.equals(c)){
				j.notify(i);
			}
		}
	}

}
