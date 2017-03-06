package RMI_CLIENT;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import RMI_INTERFACE.ChatRoomInterface;


public class Client {

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
    	      System.out.println(r.toString());
    	      while(true){  
	    	      
	    	      if (r instanceof ChatRoomInterface) {
	    	    	Scanner messageScanner = new Scanner(System.in);
	    	  		System.out.println("Veuillez saisir un message :");
	    	  		String message = messageScanner.nextLine();
	    	  		System.out.println("sendmessage");
	    	  		r.sendMessage(ci,message);
	    	    
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