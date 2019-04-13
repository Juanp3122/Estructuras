package TallerP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class COCTEL {
	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Type the number of family members");
		int familyMembers=Integer.parseInt(br.readLine());
		System.out.println("Type the number of underaged family members");
		int underAgedMembers=Integer.parseInt(br.readLine());
		System.out.println("The items needed for making the cocktail are:");

		cocktail(familyMembers, underAgedMembers);

	}
	public static void cocktail(int familyMembers, int underAgedMembers) {


		final String  ingredients[]= {"Vodka","Apple juice","Lemon slice","Strawberries","ice cubes","Cocktail glass"};
		int[] amountsNeeded=new int[ingredients.length];
		final int amounts[]= {70,140,4,1,2,1};
		for (int i = 0; i < amounts.length; i++) {
			amountsNeeded[i]=amounts[i]*familyMembers;
		}
		amountsNeeded[0]-=underAgedMembers*70;
		if(familyMembers>=underAgedMembers&&familyMembers>=0&&underAgedMembers>=0) {
			for (int i = 0; i < amounts.length; i++) {
				if(i<2) {
					System.out.println(ingredients[i]+" : "+amountsNeeded[i]+" mL");
				}
				else {
					System.out.println(ingredients[i]+" : "+amountsNeeded[i]);
				}
			}
		}
		else {System.out.println("Invalid data.");}
	}


}
