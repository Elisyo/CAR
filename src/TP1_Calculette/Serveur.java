package TP1_Calculette;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.HashMap;

public class Serveur {
	final static int port = 9632;

	public static void main(String[] args) throws IOException {
		ServerSocket socketServeur = null;
		try {
			socketServeur = new ServerSocket(port);
			System.out.println("Lancement du serveur");
			HashMap<String, Integer> map = new HashMap<>();

			while (true) {
				Socket socketClient = socketServeur.accept();
				String message = "";
				String ipClient = "" + socketClient.getInetAddress();
				System.out.println("Connexion avec : " + ipClient);

				BufferedReader in = new BufferedReader(new InputStreamReader(
						socketClient.getInputStream()));
				DataOutputStream out = new DataOutputStream(
						socketClient.getOutputStream());
				message = in.readLine();
				System.out.println(message);

				socketClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			socketServeur.close();
		}
	}

	public static void receptionFichier(Socket s, File file) {
		try {
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			byte[] content = (byte[]) in.readObject();
			Files.write(file.toPath(), content);

		} catch (IOException e) {
			System.out
					.println("ServeurFichier : Erreur de réception du fichier ----> "
							+ e);
		} catch (ClassNotFoundException e) {
			System.out.println("Une erreur est survenue avec le fichier ----> "
					+ e);
		}
	}

}