package LinearDS_Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import LinearDS_Problems.MonkAndChamberOfSecrets.ProblemNode;
import LinearDataStructures.List;
import LinearDataStructures.Node;
import LinearDataStructures.Queue;

//https://www.urionlinejudge.com.br/judge/en/problems/view/1211

public class EconomicPhonebook {


	public class ProblemNode implements Node{
		public String data;

		public ProblemNode next=null;

		ProblemNode(String data){
			this.data=data;
		}


		public String toString() {




			return this.data;
		}
		@Override
		public void setNext(Node node) {
			// TODO Auto-generated method stub
			this.next=(ProblemNode)node;
		}

		@Override
		public Node getNext() {
			// TODO Auto-generated method stub
			return next;
		}

		@Override
		public Node clone() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isEqual(Node node) {
			// TODO Auto-generated method stub
			ProblemNode temp = (ProblemNode)node;
			return this.data == temp.data ? true : false;
		}

		@Override
		public boolean isLessThan(Node node) {
			boolean res= false;
			ProblemNode temp = (ProblemNode)node;
			for (int i = 0; i < data.length(); i++) {
				if((int)data.charAt(i)<(int)temp.data.charAt(i)) {
					res=true;
					break;
				}
				else if((int)data.charAt(i)>(int)temp.data.charAt(i)) {
					res=false;
					break;
				}
			}
			return res;
		}


	}
	
	
	public void sort(List x) {
		if (x.length() > 1) {
			boolean wasChanged;

			do {
				Node current = x.head;
				Node previous = null;
				Node next = x.head.next;
				wasChanged = false;

				while ( next != null ) {
					if (current.isLessThan(next) ) {
						/*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
						wasChanged = true;

						if ( previous != null ) {
							Node sig = next.next;

							previous.setNext( next);
							next.setNext(current);
							current.setNext( sig);
						} else {
							Node sig = next.next;

							x.head = next;
							next.setNext(current);
							current.setNext(sig);
						}

						previous = next;
						next = current.next;
					} else { 
						previous = current;
						current = next;
						next = next.next;
					}
				} 
			} while( wasChanged );
		}
	}
	public void solution() {
		EconomicPhonebook b=new EconomicPhonebook();
		try {
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
			RadixSort sort= new RadixSort();
			String s;
			int cuenta=0;
			while((s=br.readLine())!=null) {

				List x= new List();
				String[] node=new String[Integer.parseInt(s)];

				for (int i = 0; i < Integer.parseInt(s); i++) {
                  //inserts all the lines of the test case in an array.
					node[i]=br.readLine();
                   

				}
				
				// sort the lines according of the numbers in them.
				sort.radixSort(node, '0','9');
				
				for (int i = 0; i < node.length; i++) {
					//inserts in list each line as a String from the input as node 
					x.insertAtEnd(new ProblemNode(node[i]));
				}

				ProblemNode temp=(ProblemNode)x.head;

				
				
				while(!temp.equals(null)) {
                    //counts how many characters are saved comparing one node with the next.
					for (int i = 0; i < temp.data.length(); i++) {
						if(temp.data.charAt(i)==temp.next.data.charAt(i)) {
							cuenta++;
						}
						else {
							break;
						}

					}
					temp=(ProblemNode)temp.getNext();



					//prints the result
					bw.write(cuenta+"\n");
					bw.flush();

				}


				
			}








			//if(!br.ready()) break;




		}
		catch (Exception e) {
			// TODO: handle exception
		}


	}

	public static void main(String[] args) {
		EconomicPhonebook book= new EconomicPhonebook();
		book.solution();
	}

}
