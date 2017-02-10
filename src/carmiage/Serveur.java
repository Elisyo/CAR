package carmiage;
import java.net.*;
import java.util.HashMap;
import java.io.*;

public class Serveur {
  final static int port = 9632;
  
  public static int calculer(String calcul, Integer ans) {
		int result = 0;
		String[] tab = calcul.split(" ");
		if(tab.length==1){
			return Integer.parseInt(tab[0]);
		}else if(tab.length==2){
			switch (tab[0]) {
			case ("+"):
				try {
					return ans + Integer.parseInt(tab[1]);
				} catch (Exception e) {
					break;
				}
			case ("-"):
				try {
					return ans - Integer.parseInt(tab[1]);
				} catch (Exception e) {
					break;
				}
			case ("/"):
				try {
					return ans / Integer.parseInt(tab[1]);
				} catch (ArithmeticException e) {
				    System.out.println("Division par zéro !");
				} catch (Exception e) {
					break;
				}			
			case ("*"):
				try {
					return ans * Integer.parseInt(tab[1]);
				} catch (Exception e) {
					break;
				}
			}
		}else{
			switch (tab[0]) {
			case ("+"):
				try {
					return Integer.parseInt(tab[1]) + Integer.parseInt(tab[2]);
				} catch (Exception e) {
					break;
				}
			case ("-"):
				try {
					return Integer.parseInt(tab[1]) - Integer.parseInt(tab[2]);
				} catch (Exception e) {
					break;
				}
			case ("/"):
				try {
					return Integer.parseInt(tab[1]) / Integer.parseInt(tab[2]);
				} catch (ArithmeticException e) {
				    System.out.println("Division par zéro !");
				} catch (Exception e) {
					break;
				}
			case ("*"):
				try {
					return Integer.parseInt(tab[1]) * Integer.parseInt(tab[2]);
				} catch (Exception e) {
					break;
				}
			}
		}
		return result;
	}

  public static void main(String[] args) throws IOException {
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
	        int result = calculer(message,map.get(ipClient));
	        out.writeBytes(Integer.toString(result));
	        map.replace(ipClient, result);
	        socketClient.close();
	      }
	  }catch (Exception e) {
		  e.printStackTrace();
		  socketServeur.close();
	  }
  }   
}