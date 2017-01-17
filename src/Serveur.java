import java.net.*;
import java.util.HashMap;
import java.io.*;

public class Serveur {
  final static int port = 9632;

  public static void main(String[] args) throws IOException {
	  Calculatrice calculatrice = new Calculatrice();
	  ServerSocket socketServeur = null;
	  try {
		  socketServeur = new ServerSocket(port);
      System.out.println("Lancement du serveur");
      HashMap<String, Integer> map = new HashMap<>();
      
      while (true) {
        Socket socketClient = socketServeur.accept();
        String message = "";
        String ipClient = ""+socketClient.getInetAddress();
        System.out.println("Connexion avec : "+ipClient);
        
        if(!map.containsKey(ipClient)){
        	map.put(ipClient, 0);
        }

        BufferedReader in = new BufferedReader(
          new InputStreamReader(socketClient.getInputStream()));
        DataOutputStream out= new DataOutputStream(socketClient.getOutputStream());
        message = in.readLine();
        System.out.println(message);
        int result = calculatrice.calculer(message,map.get(ipClient));
        out.writeBytes(Integer.toString(result));
        map.replace(ipClient, result);
        socketClient.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
      socketServeur.close();
    }
  }
    
}



