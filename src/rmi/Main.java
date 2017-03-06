package rmi;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class Main {

	public static void main(String[] args) {
		  try {
		    if (System.getSecurityManager() == null) {
		      System.setSecurityManager(new RMISecurityManager());
		    }
		    
		    InformationImpl informationImpl = new InformationImpl();
		    String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
		    System.out.println("Enregistrement de l'objet avec l'url : " + url);
		    Naming.rebind(url, informationImpl);
		    Naming.lookup(url);
		  } catch (Exception e) {
		     e.printStackTrace();
		  }
		}
}
