package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class InformationImpl extends UnicastRemoteObject implements Information {

	private static final long serialVersionUID = 2674880711467464646L;

	public InformationImpl() throws RemoteException {
		super();
	}

	public String getInformation() throws RemoteException {
		System.out.println("Invocation de la méthode getInformation()");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un message :");
		String str = sc.nextLine();
		
		return str;
	}
}