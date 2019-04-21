package StringsProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Strings.StringAsList;

public class Subsequences {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
             try {
				String s=br.readLine();	
				int cases=Integer.parseInt(s);
				for (int i = 0; i < cases; i++) {
					StringAsList FirstSequence= new StringAsList(br.readLine().toCharArray());
					int queries= Integer.parseInt(br.readLine());
					for (int j = 0; j < queries; j++) {
						StringAsList SecondSequence = new StringAsList(br.readLine().toCharArray());
						if(FirstSequence.contains(SecondSequence)) {
							bw.write("Yes"+"\n");
							bw.flush();
						}
						else 
							bw.write("No"+"\n");
					}
					
				}
            	 
            	 
            	 
            	 
            	 
            	 
			} catch (Exception e) {
				// TODO: handle exception
			}	
	
	}
	
}
