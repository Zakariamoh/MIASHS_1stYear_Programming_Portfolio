import java.util.Scanner;

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
