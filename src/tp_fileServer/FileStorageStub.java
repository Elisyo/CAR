package tp_fileServer;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

public class FileStorageStub implements FileStorageInterface{
	
	HashMap map;
	Socket sock;
	Protocol prot;
	
	public FileStorageStub(String addresse, int port){
		try {
			sock = new Socket(addresse, port);
			prot = new Protocol(sock);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public File search(String name) {
		try {
			prot.writeRequestHeader("SEARCH");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prot.writeParString(name);
		prot.endMessage();
		int code = prot.readResponseHeader();
		if(code==0){
			return prot.readParFile();
		}else{
			return null;
		}
	}

	@Override
	public void add(File file, String name, List<String> tags) {
		
	}

	@Override
	public void delete(String name) {
		
	}
}
