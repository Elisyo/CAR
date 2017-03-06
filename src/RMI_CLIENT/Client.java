package RMI_CLIENT;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

import RMI_INTERFACE.ChatRoomInterface;
import RMI_INTERFACE.ClientInterface;
import RMI_INTERFACE.Information;
import RMI_SERVER.ChatRoom;
import RMI_SERVER.InformationImpl;


public class Client{

	static ChatRoomInterface r = null;
	
  public static void main(String[] args) throws UnknownHostException {
    System.out.println("Lancement du client");
    	try {
    	      r = (ChatRoomInterface) Naming.lookup("ChatRoomServer");
    	      
    	      Scanner sc = new Scanner(System.in);
    	  		System.out.println("Veuillez saisir un login :");
    	  		String login = sc.nextLine();
    	  		Scanner mdp = new Scanner(System.in);
    	  		System.out.println("Veuillez saisir un mot de passe :");
    	  		String password = mdp.nextLine();
    	  		System.out.println(login + " : " + password);
    	      
    	      ClientImpl ci = new ClientImpl(login,password);
    	      r.connexion(ci);
    	      while(true){  
	    	      System.out.println(r.toString());
	    	      
	    	      if (r instanceof Information) {
	    	    	Scanner messageScanner = new Scanner(System.in);
	    	  		System.out.println("Veuillez saisir un message :");
	    	  		String message = messageScanner.nextLine();
	    	  		r.sendMessage(ci, new InformationImpl(message));
	    	    
	    	  		if(message.equals("deco")){
	    	  			r.deconnexion(ci);
	    	  		}
	    	        
	    	      }
    	      }
    	    } catch (MalformedURLException e) {
    	      e.printStackTrace();
    	    } catch (RemoteException e) {
    	      e.printStackTrace();
    	    } catch (NotBoundException e) {
    	      e.printStackTrace();
    	    }
 
    //System.out.println("Fin du client");
  }
}