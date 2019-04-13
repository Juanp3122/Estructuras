package LinearDS_Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import com.sun.imageio.plugins.common.InputStreamAdapter;

import LinearDS_Problems.EconomicPhonebook.ProblemNode;
import LinearDataStructures.List;
import LinearDataStructures.Node;
import LinearDataStructures.Queue;

//https://www.hackerearth.com/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/little-monk-and-goblet-of-fire/

public class LittleMonkAndGobletOfFire {



	public class ProblemNode implements Node{

		public int school;
		public int roll;
		public ProblemNode next =null;


		public ProblemNode(int school,int roll) {
			this.school=school;
			this.roll=roll;
		}
		public String toString() {
			return this.school+" "+this.roll+"\n";
		}

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
		public boolean isLessThan(Node node) {
			ProblemNode temp=(ProblemNode)node;
			return  this.school<temp.school? true : false;
		}

		@Override
		public boolean isEqual(Node node) {
			ProblemNode temp=(ProblemNode)node;

			return (this.school==temp.school);

		}


	}
	// this method tells wether the list already contains a studend of the same school
	public boolean nodeFound(List x,ProblemNode insert) {
		boolean res=false;
		ProblemNode temp= (ProblemNode)x.head;
		while(temp!=null) {
			if(temp.school==insert.school) return true;
			temp=(ProblemNode)temp.getNext();

		}
		return res;
	}
	public void solution() {

		try {
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String s;
			while((s=br.readLine())!=null) {
				List fila= new List();
				int cases= Integer.parseInt(s);
				for (int i = 0; i < cases; i++) {
					String input[]=br.readLine().split(" ");

					if(input[0].contains("E")) {
						int school=Integer.parseInt(input[1]);
						int roll=Integer.parseInt(input[2]);
						ProblemNode insert= new ProblemNode(school, roll);
						if(nodeFound(fila,insert)) {
		
							int index=fila.length()-1;
							for (int j = 0; j < fila.length(); j++) {
								//this loop  tries to insert a node in the list until the next position has the same school

								fila.insertAtIndex(insert, index);
								ProblemNode x= (ProblemNode)fila.get(index);
								ProblemNode y= (ProblemNode)fila.get(index-1);
								if(x.school==y.school) {
									// if the next node has the same school , leave it there
									break;
								}else {
									//else remove it and try in the next position from last to first
									fila.deleteAtIndex(index);
								}
								index--;
							}
						}
						else {
							//if the list does not contains a node with the same school theres no need to insert the node in any particular position 
							fila.insertAtEnd(insert);
						}


					}

					else {


						// if the input does not contain a "E" in the first position it means is a delete operation, we need to print an remove the first node in the list
						bw.write(fila.get(0).toString());
						bw.flush();
						fila.deleteAtBegin();
					}


				}
				//fila.printList();






			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	};

	public static void main(String[] args) {
		LittleMonkAndGobletOfFire monk= new LittleMonkAndGobletOfFire();
		monk.solution();
	}
}
