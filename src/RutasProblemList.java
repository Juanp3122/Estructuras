package StringsProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import LinearDataStructures.ExampleNode;
import LinearDataStructures.List;
import LinearDataStructures.Node;

public class RutasProblemList {
	public class ExampleNode implements Node {

		public int value;
		public ExampleNode next = null;
		
		
		/**
		 * 
		 * @param value
		 */
		public ExampleNode(int value) 
		{
			this.value = value;
		}
		
		@Override
		public void setNext(Node node) 
		{
			next = (ExampleNode)node;
		}

		@Override
		public Node getNext() 
		{
			return next;
		}

		@Override
		public Node clone() 
		{
			return new ExampleNode(this.value);
		}

		@Override
		public boolean isEqual(Node node) 
		{
			ExampleNode temp = (ExampleNode)node;
			return this.value == temp.value ? true : false;
		}

		@Override
		public boolean isLessThan(Node node) 
		{
			ExampleNode temp = (ExampleNode)node;
			return this.value <= temp.value ? true : false;
		}
		
		@Override
		public String toString()
		{
			return this.value + " ";
		}
	}
	public void solution() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String s= br.readLine();
			
			while(s!="0 0") {
				List input1=new List();
				List input2=new List();
				String S[]=s.split("");
			    String S2[]=br.readLine().split("");
			   
				for (int i = 0; i < S.length; i++) {
					
					input1.insertAtEnd(new ExampleNode(Integer.parseInt(S[i])));
					input2.insertAtEnd(new ExampleNode(Integer.parseInt(S2[i])));
				}
				input1.bubbleSort(input1);
				
				
				input2.bubbleSort(input2);
				input2.reverse();
				
				
				ExampleNode temp=(ExampleNode)input1.head;
				ExampleNode temp2=(ExampleNode)input2.head;
				while(temp!=null) {
					
					bw.write(temp.toString()+" "+temp2.toString()+"\n");
					bw.flush();
					temp=(ExampleNode)temp.getNext();
					 temp2=(ExampleNode)temp2.getNext();
				}
				
				s=br.readLine();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		RutasProblemList ruta= new RutasProblemList();
		ruta.solution();
	}
}
