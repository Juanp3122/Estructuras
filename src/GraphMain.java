package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GraphMain {
	public static void main(String[] args) {
		try {
			
			BufferedReader br= new BufferedReader(new FileReader("input2.txt"));
			
			String s= br.readLine();
			
			while(s!=null) {
				System.out.println("ohoh");
				s=br.readLine();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
