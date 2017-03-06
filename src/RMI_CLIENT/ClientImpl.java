package RMI_CLIENT;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import RMI_INTERFACE.ClientInterface;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2957200074762737249L;
	public String login;
	public String mdp;
	
	ClientImpl(String nom, String mdp) throws RemoteException{
		this.login = nom;
		this.mdp=mdp;
	}

	@Override
	public void notify(String message) throws RemoteException {
		System.out.println(message);
	}


}
