package RMI_SERVER;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import RMI_INTERFACE.Information;


public class InformationImpl extends UnicastRemoteObject implements Information {

	private static final long serialVersionUID = 2674880711467464646L;

	public InformationImpl() throws RemoteException {
		super();
	}

	public String getInformation(String info) throws RemoteException {
		System.out.println("Invocation de la méthode getInformation()");
		System.out.println(info);
		return info;
	}
}