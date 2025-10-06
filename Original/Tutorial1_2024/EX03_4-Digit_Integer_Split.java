
import java.util.Scanner;

public class EX03_4_Digit_Integer_Split {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Data input
		System.out.print("Enter a 4-digit integer: "); 
		int integer = scanner.nextInt();
		scanner.close();
		
		// Digits split
		int thousands = integer / 1000;
		int hundreds = (integer / 100) % 10;
		int tens = (integer / 10) % 10;
		int units = integer % 10;
		System.out.println("The digits are " + thousands + ", " + hundreds + ", " + tens + ", " + units + "."); 
	}

}
