package StringsProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Strings.StringAsList;
import Strings.StringNode;

public class ParenthesisBalance {
	public static void main(String[] args) {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
       try {
    	   
    	   String s= br.readLine();
    	   while(s!=null) {
    		int openedParenthesis=0;
				for (int i = 0; i < s.length(); i++) {
					if(s.charAt(i)=='(') openedParenthesis++;
					else if(s.charAt(i)==')') {
						if(openedParenthesis<=0) {
							openedParenthesis=-100;
							break;
						}
						else 
							openedParenthesis--;
					}
				}
				if(openedParenthesis==0) {
					bw.write("correct");
					bw.flush();
				}else {
					bw.write("incorrect");
					bw.flush();
				}
					
				
				
				
				
				
			
    		 
            System.out.println();
    		   
    		   s=br.readLine();
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
       
	}
}
