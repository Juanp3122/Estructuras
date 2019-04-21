package StringsProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import LinearDataStructures.Node;
import Strings.StringAsList;
import Strings.StringNode;
import LinearDataStructures.List;

public class JingleComposing {
	
	public static double getIndex(char x) {
		
		double[] values= {1,0.5,0.25,0.125,0.0625,0.03125,0.015625};
		char[] letters= {'W','H','Q','E','S','T','X'};
		double res=9;
		for (int i = 0; i < letters.length; i++) {
			if(x==letters[i]) {
				res=values[i];
			}
		}
		return res;
	}
	public static void main(String[] args) {
	       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	       try {
	    	   StringAsList string= new StringAsList();
	    	   String s= br.readLine();
	    	   while(s!="*") {
	    		   string=new StringAsList(s.toCharArray());
	    		   StringAsList[]input=string.split(new StringAsList(new char[] {'/'}));
	    		   int res=0;
	    		   for (int i = 0; i < input.length; i++) {
					StringNode temp= (StringNode)input[i].string.head;
					double cuenta=0;
	    			   while(temp!=null) {
	    				   cuenta+=getIndex(temp.character);
	    				   //System.out.println(getIndex(temp.character));
	    				   temp=(StringNode)temp.getNext();
	    			   }
	    			   if(cuenta==1.0)res++;
	    			  
	    			   
					
				}
	    		   bw.write(res+"");
	    				  
	    		   s=br.readLine();
	    	   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	       
		}
}
