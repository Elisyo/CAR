package tp_fileServer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Protocol {
	Socket sock;
	InputStream in;
	OutputStream out;
	
	public Protocol(Socket s){
		sock = s;
		// in = ...
		// out = ...
	}
	
	public void writeRequestHeader(String name) throws NumberFormatException, IOException{
		out.write(new Byte("IMG STORAGE 1.0 \n"));
		out.write(new Byte(name+"\n"));
		out.write(new Byte("\n"));
	}
	
	public String readRequestHeader(){
		return "";
	}
	
	public void writeParString(String name){
		
	}
	
	public void writeParFile(File file){
		
	}

	
	public void endMessage() {
		try {
			out.write(new Byte("\n"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File readParFile() {
		// TODO Auto-generated method stub
		return null;
	}

	public int readResponseHeader() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String readParString() {
		// TODO Auto-generated method stub
		return null;
	}

	public void writeResponseHeader() {
		// TODO Auto-generated method stub
		
	}
}
