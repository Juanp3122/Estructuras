package StringsProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Arrays_1D.ProblemsExamples;
import LinearDS_Problems.LittleMonkAndGobletOfFire.ProblemNode;
import LinearDataStructures.List;
import LinearDataStructures.Node;
import LinearDataStructures.Prueba;

public class FriendsOfHabay {
	public class ProblemStringNode implements Node{

		public String name;

		public ProblemStringNode next =null;


		public ProblemStringNode(String name) {
			this.name=name;
		}
		public String toString() {
			return this.name+"\n";
		}

		public void setNext(Node node) {
			// TODO Auto-generated method stub
			this.next=(ProblemStringNode)node;
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
			ProblemStringNode temp=(ProblemStringNode)node;
			int index=0;
			boolean res=false;
			if(this.name.length()<temp.name.length()) {
				index=this.name.length();
			}else 
				index=temp.name.length();

			for (int i = 0; i < index; i++) {
				if(this.name.charAt(i)<=temp.name.charAt(i)) {
					res=true;
				}else {
					res=false;
				}
			}
			return  this.name.compareTo(temp.name)<0;
		}

		@Override
		public boolean isEqual(Node node) {
			ProblemStringNode temp=(ProblemStringNode)node;

			return this.name.equals(temp.name);

		}
	}
	public void solution() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String s= br.readLine();
			List input= new List();
			List yes= new List();
			while(s!="FIM") {
				String[] S= s.split(" ");
				if(s.equals("FIM"))break;

				if(S[1].equals("NO")) {
					if(input.indexOf(new ProblemStringNode(S[0]))==-1) {

						input.insertAtEnd(new ProblemStringNode(S[0]));
					}
				}

				if(S[1].equals("YES")) {
					if(yes.indexOf(new ProblemStringNode(S[0]))==-1) {
						yes.insertAtEnd(new ProblemStringNode(S[0]));

					}
				}



				s=br.readLine();

			}
			ProblemStringNode temp=(ProblemStringNode)yes.head;
			ProblemStringNode mayor=(ProblemStringNode)yes.head;
			while(temp!=null) {
				if(temp.name.length()>mayor.name.length()) {
					mayor=temp;
				}
				temp=(ProblemStringNode)temp.getNext();
			}

			
			yes.bubbleSort(yes);
			yes.printList();
			input.bubbleSort(input);
			input.printList();
			bw.write("\n");
			bw.flush();
			bw.write("Amigo do Habay:"+"\n");
			bw.write(mayor.name);
			bw.flush();






		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		FriendsOfHabay friends= new FriendsOfHabay();
		friends.solution();
	}

}
