package RMI_CLIENT;

import java.rmi.RemoteException;

import RMI_INTERFACE.ClientInterface;
import RMI_INTERFACE.Information;

public class ClientImpl implements ClientInterface {

	public String login;
	public String mdp;
	
	ClientImpl(String nom, String mdp){
		this.login = nom;
		this.mdp=mdp;
	}
	
	@Override
	public void notify(Information i) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
