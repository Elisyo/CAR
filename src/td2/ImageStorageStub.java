package td2;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

public class ImageStorageStub implements ImageStorageInterface{
	
	HashMap map;
	Socket sock;
	Protocol prot;
	
	public ImageStorageStub(String addresse, int port){
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
	public Image search(String name) {
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
			return prot.readParImage();
		}else{
			return null;
		}
	}

	@Override
	public void add(Image img, String name, List<String> tags) {
		
	}

	@Override
	public void delete(String name) {
		
	}

}
