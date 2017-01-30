package carmiage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class CompteurParallele extends Thread{
	public App app;
	public String text;
	
	public CompteurParallele(App a, String t){
		this.app = a;
		this.text=t;
	}
	
	public void run(){
		String array[] = text.split("\\s");
		for(String l : array){
			app.countWords(l);
		}
	}
	
	public static void main(String [] args){
		int nthreads = Integer.parseInt(args[0]);
		StringBuilder lines [] = new StringBuilder [nthreads];
		for(int i=0; i< nthreads; i++){
			lines[i]= new StringBuilder();
		}
		
		InputStream fil;
		BufferedReader br = null;
		try {
			fil = new FileInputStream(args[0]);
			InputStreamReader isr = new InputStreamReader(fil);
			br = new BufferedReader(isr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String l = null;
		int i=0;
		try {
			while((l = br.readLine()) != null){
				lines[i].append(l);
				i = (i+1) / nthreads;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		App [] apps = new App[nthreads];
		for(i=0;i<nthreads;i++){
			apps[i]= new App();
		}
		
		CompteurParallele [] compt = new CompteurParallele[nthreads];
		for(i=0;i<nthreads;i++){
			compt[i] = new CompteurParallele(apps[i], lines[i].toString());
			compt[i].start();
		}
		
		for(i=0;i<nthreads;i++){
			try {
				compt[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(i=1;i<nthreads;i++){
			apps[0].merge(apps[i]);
		}
		
		Map.Entry<String, Integer> max = apps[0].findMax();
	}
}
