package StringsProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class NoelsLabels {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	       try {
	    	   String s= br.readLine();
	    	   int languages=Integer.parseInt(s);
	    	   HashMap<String, String> map= new HashMap<String, String>();
	    	   for (int i = 0; i < languages; i++) {
	    		   String language_=br.readLine();
	    		   String languageShow=br.readLine();
	    		   map.put(language_, languageShow);
				
			}
	    	   int kids=Integer.parseInt(br.readLine());
	    	   for (int i = 0; i <kids; i++) {
	    		   String kidName=br.readLine();
	    		   String languagee=br.readLine();
	    		   bw.write(kidName+"\n");
	    		   bw.flush();
	    		   bw.write(map.get(languagee)+"\n");
	    		   bw.write("\n");
	    		   bw.flush();
	    		   
				
			}
	    	   
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
