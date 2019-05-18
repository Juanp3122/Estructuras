package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import LinearDataStructures.List;

public class Graph {
	public List GraphNodes;


	public Graph() {
		List GraphNodes= new List();
		this.GraphNodes=GraphNodes;

	}
	public void insert(GraphNode node) {
		if(this.GraphNodes.linealSearch(node)==null) {
			this.GraphNodes.insertAtEnd(node);
		}
	}
	public void conect(GraphNode node,KeyNode key) {
		
		GraphNode temp=(GraphNode)this.GraphNodes.linealSearch(node);
		
		temp.ConectedNodes.insertAtEnd(key);
		
	}
	public void print() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
		GraphNode temp1=(GraphNode) this.GraphNodes.head;
		try {
			while(temp1!=null) {
				
				bw.write(temp1.toString()+":");
				bw.flush();
				temp1.ConectedNodes.printList();
				bw.write("\n");
				temp1 = (GraphNode)temp1.getNext();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
