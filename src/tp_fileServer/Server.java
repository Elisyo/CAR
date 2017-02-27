package tp_fileServer;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String [] args){
		FileStorage fileStorage = new FileStorage();
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
						File file = fileStorage.search(m);
						p.writeResponseHeader();
						p.writeParFile(file);
						p.endMessage();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
