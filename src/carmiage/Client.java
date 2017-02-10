package carmiage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.Scanner;

public class Client {
	private static Socket conn() {
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

	public static void main(String[] args) {
		Socket as = null;
		try {
			while (true) {
				Scanner scanner = new Scanner(System.in);
				String sentence = "";
				System.out.println("Entrer un fichier");

				String selection;
				try {
					selection = scanner.next();
				} catch (Exception e) {

				}

				as = conn();
				DataOutputStream out = new DataOutputStream(
						as.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(
						as.getInputStream()));

				scanner = new Scanner(System.in);
				envoiFichier(as, scanner);

				out.writeBytes(sentence);
				// System.out.println("Message envoyé");
				String response = in.readLine();
				System.out.println("Résultat obtenu: " + response);

				as.close();

			}

		} catch (UnknownHostException ex) {
			System.out.println("Ip du serveur non trouvée");
			System.exit(-1);
		} catch (IOException ex) {
			System.exit(-1);
		}
	}

	public static void envoiFichier(Socket s, File f) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			byte content[] = Files.readAllBytes(f.toPath());
			out.writeObject(content);
		} catch (Exception e) {
			System.out
					.println("EnvoiFichier : Erreur lors de l'envoi du fichier "
							+ e);
		}
	}

}
