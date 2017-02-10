package carmiage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	private static Socket conn(){
		Socket as = null;
		try {
			as = new Socket(InetAddress.getLocalHost(), 9632);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return as;
	}
	
	public static void main(String [] args){
		Socket as = null;
		try {
			while (true) {
				Scanner scanner = new Scanner(System.in);
				String sentence = "";
	            System.out.println("\nCalculette\n");
	            System.out.println("Avez-vous changer l'ip du serveur ?");
	            System.out.println("(1) - Rentrer un calcul");
	            System.out.println("(2) - Quitter");

	            System.out.print("Rentrer le chiffre qui correspond à ce que vous souhaitez faire:\n");
	            int selection = 0;
	            try{
	            	selection = scanner.nextInt();
	            }catch(Exception e){
	            	
	            }
	            if (selection == 1) {
	            	as = conn();
					DataOutputStream out = new DataOutputStream(as.getOutputStream());
					BufferedReader in = new BufferedReader(
					new InputStreamReader(as.getInputStream()));
					
					scanner = new Scanner(System.in);
	                System.out.print("Entrer une opération: (op) (chiffre) (chiffre) \n");
	                sentence = scanner.nextLine() + "\n";

	                out.writeBytes(sentence);
	    			//System.out.println("Message envoyé");
	    			String response = in.readLine();
	    			System.out.println("Résultat obtenu: " + response);
	    			
		            as.close();
	            }
	            else if (selection == 2) {
	                break;
	            }
	        }
			
		} catch (UnknownHostException ex) {
			System.out.println("Ip du serveur non trouvée");
			System.exit(-1);
		} catch (IOException ex) {
			System.exit(-1);
		}
	}
}



