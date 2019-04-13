package TallerP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parranda {

	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int []itemNeededPerPerson= new int[3];
		System.out.println("Type the amount of people assisting to the party: ");
		int numInv=Integer.parseInt(br.readLine());
		System.out.println("Type the amount of Beer per person:");
		itemNeededPerPerson[0]=Integer.parseInt(br.readLine());
		System.out.println("Type the amount of Aguardiente per person:");
		itemNeededPerPerson[1]=Integer.parseInt(br.readLine());
		System.out.println("Type the amount of food");
		itemNeededPerPerson[2]=Integer.parseInt(br.readLine());
		
		ParrandaItems(numInv, itemNeededPerPerson);
		
	}
	
	
	public static void ParrandaItems(int invitados,int itemNeededPerPerson[]) {
		final String []itemsNeeded= {"Beer","Aguardiente","Food"};
		final int []Prices= {2000,5000,3500};
		int total=0;
		for (int i = 0; i < itemNeededPerPerson.length; i++) {
			int itemPerP=itemNeededPerPerson[i]*invitados;
			int priceItem=itemPerP*Prices[i];
			System.out.println(itemsNeeded[i]+" = "+itemPerP+" ---> "+priceItem+" Pesos");
			total+=itemNeededPerPerson[i]*invitados*Prices[i];
		}
		System.out.println("Money Needed: "+total+" Pesos");
	}
	
}
