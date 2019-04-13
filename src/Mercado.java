package TallerP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import LinearDataStructures.List;
import LinearDataStructures.Node;

public class Mercado  {
	
	public class ProductoNode implements Node{

		public int itemPrice;
		public String itemName;
		public int timesinlist;
		public ProductoNode next=null;
		
		public  ProductoNode(String itemname, int itemPrice) {
			this.itemName=itemname;
			this.itemPrice=itemPrice;
		}
		public String toString() {
			return this.itemName+": "+this.itemPrice+" Pesos"+"\n";
		}
		public void setTimesInList(int times) {
			
		}
		@Override
		public void setNext(Node node) {
			// TODO Auto-generated method stub
			this.next=(ProductoNode)node;
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
			return false;
		}

		@Override
		public boolean isLessThan(Node node) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	public void solution() {
		try {
			List t= new List();
			// reference for extracting the item names and prices 
			final String products[]= {"","Milk","Rice","Pasta","Eggs","Zugar","Salt","Tuna"};
			final int prices[]= {0,2800,1800,1500,200,1500,1200,4000};
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw= new BufferedWriter(new  OutputStreamWriter(System.out));
			
			bw.write("Type the amount of money available (pesos) for buying"+"\n");
			bw.flush();
			int money=Integer.parseInt(br.readLine());
			
			bw.write("Type the number of the item and the amount you´d like to buy separated by a space, press enter to add your item to the shopping cart, type \"0 0\" to end the buy "+"\n");
			bw.flush();
			bw.write("-------Items-------"+"\n");
			bw.write("1) Milk in pounds 2800$ c/u"+"\n");
			bw.write("2) Rice in pounds 1800$ c/u"+"\n");
			bw.write("3) Pasta in pounds 1500$ c/u"+"\n");
			bw.write("4) Eggs in pounds 200$ c/u"+"\n");
			bw.write("5) Zugar in pounds 1500$ c/u"+"\n");
			bw.write("6) Salt in pounds 1200$ c/u"+"\n");
			bw.write("7) Tuna in pounds 4000$ c/u"+"\n");
			bw.flush();
			String input;
			while (!(input=br.readLine()).equals("0 0")) {
				
			
				String s[]=input.trim().split(" ");
				for (int i = 0; i < Integer.parseInt(s[1]); i++) {
					// insert the product in the list as many times as the person wants.
				
				t.insertAtEnd(new ProductoNode(products[Integer.parseInt(s[0])], prices[Integer.parseInt(s[0])]));
				}
				
				
				
			}
			
			
			t.printList();
			ProductoNode temp= (ProductoNode)t.head;
			int suma=0;
			while(temp!=null) {
				// calculate the total of money needed for the purchase
				suma+=temp.itemPrice;
				temp=(ProductoNode)temp.getNext();
				
			}
			//prints a message telling the user wether or not the purchase was successful and the total.
			if(money<suma)bw.write("You don´t have enought money to purchase these items"+"\n");
			if(money>=suma)bw.write("Successful purchase, your change :"+(money-suma)+" Pesos"+"\n");
			bw.write("Total price: "+suma+" Pesos");
			bw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) throws IOException {
		Mercado m= new Mercado();
		m.solution();
	}

	

}
