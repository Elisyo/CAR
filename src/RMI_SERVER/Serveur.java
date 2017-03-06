package RMI_SERVER;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class Serveur {

  public static void main(String[] args) {
    try {
    	//Au moment de lancer le serveur, lancer rmiregistry dans le repertoire "/workspace/S2/OBD/Chat/bin"
      InformationImpl informationImpl = new InformationImpl();

      String url = "ChatRoomServer"; 
      System.out.println("Enregistrement de l'objet avec l'url : " + url);
      Naming.rebind(url, informationImpl);

      System.out.println("Serveur lancé");
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }
}