
import java.util.Scanner;

/**
 * Tutorial 1, exercise 02: reads a value x and prints the interval [x - 10%, x + 10%].
 * Original version; see Improved/ for percentage or absolute intervals.
 */
public class EX02_Interval_Calculator_For_Single_Double {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// Read the central value
		System.out.println("Entrez une valeur : ");
		double x = s.nextDouble();
		// Lower bound = 90% of x, upper bound = 110% of x
		System.out.println("[" + x*0.9 + " , " + x*1.1+"]"); 
	}

}
