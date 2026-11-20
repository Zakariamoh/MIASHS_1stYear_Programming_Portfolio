import java.util.Scanner;

/**
 * Tutorial 1, exercise 01: reads two integers and prints their product.
 * Original version; see Improved/ for the version handling any number of factors.
 */
public class EX01_ProductOfTwoIntegers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// Read the two factors
		System.out.print("Enter an integer : ");
		int firstInteger = s.nextInt();
		System.out.print("Enter another integer : "); 
		int secondInteger = s.nextInt();
		// Compute and display the product
		int product=firstInteger*secondInteger;
		System.out.print("The product of "+firstInteger +" and "+secondInteger +" is "+ product +"."); 
	}

}
