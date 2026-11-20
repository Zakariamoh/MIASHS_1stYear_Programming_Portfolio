import java.util.Scanner;

/**
 * Tutorial 1, exercise 05: prints the n-th decimal digit of pi.
 * Shifts the fractional part of Math.PI left by n places and keeps the last digit,
 * so it is only reliable up to about 15 digits (double precision).
 */
public class EX05_PI_Decimal_Finder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//User input
		System.out.println("Rang du chiffre de Pi à afficher ? "); 
		int  position = scanner.nextInt();
		
		//Extraction of the digit at the asked position 
		int digitAtPosition= (int) (((Math.PI-3)*Math.pow(10, position))%10);
		
		//Printing the result
		System.out.println("The "+position+"th digit after the decimal is " + digitAtPosition);
		scanner.close();		//closing the scanner

	}

}
