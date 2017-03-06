package RMI_CLIENT;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

import RMI_INTERFACE.Information;


public class Client {

  public static void main(String[] args) throws UnknownHostException {
    System.out.println("Lancement du client");
    while(true){
    	try {
    	      Remote r = Naming.lookup("ChatRoomServer");
    	      System.out.println(r.toString());
    	      
    	      if (r instanceof Information) {
    	    	Scanner sc = new Scanner(System.in);
    	  		System.out.println("Veuillez saisir un message :");
    	  		String str = sc.nextLine();
    	    	  
    	        String s = ((Information) r).getInformation(str);
    	        System.out.println("chaine renvoyee = " + s);
    	      }
    	    } catch (MalformedURLException e) {
    	      e.printStackTrace();
    	    } catch (RemoteException e) {
    	      e.printStackTrace();
    	    } catch (NotBoundException e) {
    	      e.printStackTrace();
    	    }
    }
    //System.out.println("Fin du client");
  }
}