package TallerP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Estudio {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	System.out.println("type the amount of  topics you´re going to study");
	int s= Integer.parseInt(br.readLine());
	System.out.println("type the amount of hours you´re going to spend studying each topic");
	int s2= Integer.parseInt(br.readLine());
	System.out.println("the minimum time you should study is "+s*s2+" hours");
}
}
