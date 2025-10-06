import java.util.Scanner;

public class EX01_ProductOfTwoIntegers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter an integer : "); 
		int firstInteger = s.nextInt();
		System.out.print("Enter another integer : "); 
		int secondInteger = s.nextInt();
		int product=firstInteger*secondInteger;
		System.out.print("The product of "+firstInteger +" and "+secondInteger +" is "+ product +"."); 
	}

}
