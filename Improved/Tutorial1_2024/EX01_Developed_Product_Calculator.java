
import java.util.Scanner;

/**
 * EX01_Developed_Product_Calculator
 * 
 * Interactive program to calculate the product of numbers entered by the user.
 * Works like a mini-REPL: reads an expression separated by '*', 
 * checks input validity, and displays the result.
 * 
 * Features:
 * - Handles empty lines (skips line without error)
 * - Handles invalid inputs with indication of the invalid factor
 * - Displays result as integer if exact
 * - Displays result as double otherwise
 */
public class EX01_Developed_Product_Calculator {

    /**
     * Main entry point of the program.
     * Creates a Scanner and runs an infinite loop to read and calculate expressions.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Single Scanner for the entire application

        // Infinite loop simulating a REPL (Read-Eval-Print Loop)
        while (true) 
            productCalculator(s);

        // Note: s.close() is not used here
        // Do not close Scanner on System.in in an interactive loop
    }

    /**
     * Reads a '*' separated operation from the user,
     * calculates the product of valid numbers, and displays the result.
     * 
     * Error handling:
     * - If a factor cannot be converted to a number, it prints an error message
     *   showing the invalid factor and stops calculation for that line.
     * - If the line is empty, the function returns immediately to continue.
     *
     * @param s Open Scanner to read user input
     */
    public static void productCalculator(Scanner s) {
        System.out.print(">  "); // Display the prompt

        String operation = s.nextLine().trim(); // Read and trim the line

        // Empty line → nothing to calculate, return to main loop
        if (operation.isEmpty()) return;

        // Split the operation into individual factors
        String[] factors = operation.split("\\*");
        double product = 1; // Initialize product to 1

        // Iterate and process each factor
        for (String f : factors) {
            String trimmed = f.trim(); // Trim the factor

            try {
                // Convert the factor to a real number
                double value = Double.parseDouble(trimmed);
                product *= value; // Cumulative multiplication
            } catch (NumberFormatException e) {
                // Invalid factor → print error message with exact factor
                System.out.println("error: '" + trimmed + "' tu es con"); 
                return; // Stop calculation for this line
            }
        }

        // Display the result:
        // - as integer if exact
        // - as double otherwise
        if (product == (int) product)   
        	System.out.println("[ℝ] " + (int) product);
        else
        	System.out.println("[ℝ] " + product);
    }
}
