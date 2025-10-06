import java.util.Scanner;

/**
 * EX03_Developed_Digit_Split
 * --------------------------
 * A utility program that reads a real or integer number from user input,
 * validates it, and then displays all of its digits (and the decimal point, if present).
 * The user can also specify a digit position to extract.
 *
 * Supports:
 *  - Integer and real numbers (positive or negative)
 *  - Input validation and error messages
 *  - Indexed extraction of any character (digit or '.')
 *
 * Author: MOHAMAD Zakariya
 * Date: 6th october 2025
 */
public class EX03_Developed_Digit_Split {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true)
            splitDigits(scanner);
    }

    /**
     * Reads a real or integer number from the user,
     * validates it, and prints each digit individually.
     * Also allows the user to extract the digit at a specific position.
     *
     * @param scanner Scanner used to read user input
     */
    public static void splitDigits(Scanner scanner) {
        System.out.print(">  ");
        String input = scanner.nextLine().trim();

        // Ignore empty input
        if (input.isEmpty()) return;

        // Try to parse the input as a double
        double number;
        try {
            number = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("error: '" + input + "' is not a valid number");
            return;
        }

        // Work with the absolute value to simplify display
        double absValue = Math.abs(number);

        // Format as integer (no trailing .0) or as full real number
        String numberStr;
        if (absValue == Math.floor(absValue))
            numberStr = String.valueOf((long) absValue); // integer form
        else
            numberStr = String.valueOf(absValue);        // real form

        // Display all digits and symbols separated by commas
        System.out.print("[ℝ] ");
        for (int i = 0; i < numberStr.length(); i++) {
            char currentChar = numberStr.charAt(i);
            System.out.print(currentChar);
            if (i < numberStr.length() - 1) System.out.print(", ");
        }

        // Indicate if original number was negative
        if (number < 0)
            System.out.print(" (negative input)");
        System.out.println();

        // Ask for digit position to extract
        System.out.print("Enter digit position to extract: ");
        String positionInput = scanner.nextLine().trim();
        if (positionInput.isEmpty()) return;

        int position;
        try {
            position = Integer.parseInt(positionInput);
        } catch (NumberFormatException e) {
            System.out.println("error: '" + positionInput + "' is not a valid integer position");
            return;
        }

        // Validate position bounds
        if (position <= 0 || position > numberStr.length()) {
            System.out.println("error: position " + position + " is out of range");
            return;
        }

        // Extract the digit or symbol at the given position (from right to left)
        char digitAtPosition = numberStr.charAt(numberStr.length() - position);

        // Handle dot separately
        if (digitAtPosition == '.')
            System.out.println("Character at this position is a dot (decimal separator).");
        else
            System.out.println("[ℝ] Digit at position " + position + " is: " + digitAtPosition);
    }
}
