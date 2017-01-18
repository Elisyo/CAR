package td1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class App {
	
	HashMap<String, Integer> map;
	Map.Entry<String,Integer> findMax() {
		return null;
	}

	public static void main(String [] args){
		System.out.println("Word counter");
		if(args.length < 1){
			System.err.println("Usage : app <filename>");
			System.exit(-1);
		}
		
		App myApp = new App();
		
		try{
			InputStream fil = new FileInputStream(args[0]);
			InputStreamReader isr = new InputStreamReader(fil);
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			
			while ((line = br.readLine()) != null){
				myApp.countWords(line);
			}
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
		
	}

	void countWords(String line) {
		// TODO Auto-generated method stub
		
	}

	public void merge(App app) {
		// TODO Auto-generated method stub
		
	}
}
