package TallerP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViajeMochilero {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int[] daysInCity=new int[4];
		System.out.println("Type the amount of Days you´ll spent in Medellín:");
		daysInCity[0]=Integer.parseInt(br.readLine());
		System.out.println("Type the amount of Days you´ll spent in Cali:");
		daysInCity[1]=Integer.parseInt(br.readLine());
		System.out.println("Type the amount of Days you´ll spent in Ibagué:");
		daysInCity[2]=Integer.parseInt(br.readLine());
		System.out.println("Type the amount of Days you´ll spent in Barranquilla:");
		daysInCity[3]=Integer.parseInt(br.readLine());
		
		RoadTrip(daysInCity);
	}
public static void RoadTrip(int[]DaysInCity ) {
	final int[] PricesCity= {100_000,150_000,125_000,200_000};
	final String cities[]= {"Medellín","Cali","Ibagué","Barranquilla"};
	 int transportCost=50_000*5;
	int total=0;
	for (int i = 0; i < PricesCity.length; i++) {
		System.out.println(cities[i]+" cost= "+PricesCity[i]*DaysInCity[i]);
		total+=DaysInCity[i]*PricesCity[i];
		if(DaysInCity[i]==0) {
			transportCost-=50_000;
		}
	}
	System.out.println("Transpot cost= "+transportCost);
	System.out.println("Total cost of your trip: "+total+transportCost);
	
}
}
