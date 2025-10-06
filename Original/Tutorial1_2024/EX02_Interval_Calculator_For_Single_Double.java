
import java.util.Scanner;

public class EX02_Interval_Calculator_For_Single_Double {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		System.out.println("Entrez une valeur : "); 
		double x = s.nextDouble();
		System.out.println("[" + x*0.9 + " , " + x*1.1+"]"); 
	}

}
