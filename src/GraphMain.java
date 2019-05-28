package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GraphMain {
	public static void main(String[] args) {
		try {
			File file= new File("C:\\Users\\juanp\\git\\DataStructuresTemplates\\src\\Graph\\input2.txt");
			FileReader fr= new FileReader(file);
			BufferedReader br= new BufferedReader(fr);
		Graph twitterGraph= new Graph();
		int count=0;
			 String st; 
			  while ((st = br.readLine()) != null) {
				  count++;
			    String[]input= st.split(" ");
			    
			    GraphNode userNode= new GraphNode(Integer.parseInt(input[1]));
			    KeyNode conectedNode= new KeyNode(Integer.parseInt(input[0]));
			    
			    if(!twitterGraph.contains(userNode)) {
			    	twitterGraph.insert(userNode);
			    	twitterGraph.conect(userNode, conectedNode);
			    	
			    }
			    else {
			    	twitterGraph.conect(userNode, conectedNode);
			    }
				 // System.out.println(st); 
			  }
			  System.out.println("Graph print");
			 
			  twitterGraph.print();
			  System.out.println(twitterGraph.GraphNodes.length());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
