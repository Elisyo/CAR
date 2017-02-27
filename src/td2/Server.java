package td2;

import java.awt.Image;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String [] args){
		ImageStorage imgStorage = new ImageStorage();
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(4000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			Socket s;
			Protocol p;
			try {
				s = ss.accept();
				p = new Protocol(s);
				String op = p.readRequestHeader();
				switch(op){
					case "SEARCH":
						String m = p.readParString();
						Image img = imgStorage.search(m);
						p.writeResponseHeader();
						p.writeParImage(img);
						p.endMessage();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
