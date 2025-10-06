
import java.util.Scanner;

/**
 * EX02_Developed_Interval_Calculator
 *
 * Interactive program to calculate an interval around a user-provided number.
 * The user can define the interval either as a percentage (e.g., "10%") or
 * as an absolute value (e.g., "5").
 * Works in a REPL style to allow repeated entries until stopped.
 *
 * Features:
 * - Empty input → skips without error
 * - Handles invalid input with explicit error messages
 * - Interval can be absolute or percentage-based
 * - Removes unnecessary trailing zeros in input (e.g., "10.50%" → "10.5%")
 * - Displays integers if results are exact, or doubles otherwise
 * - User chooses the number of decimal places when doubles are displayed
 */
public class EX02_Developed_Interval_Calculator {

    /**
     * Main entry point.
     * Creates a Scanner and continuously reads user inputs in a REPL loop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // Infinite loop → repeatedly read and evaluate expressions
        while (true) {
            computeInterval(scanner);
        }
    }

    /**
     * Reads a base number and an interval from the user, computes the interval, and displays it.
     * Handles both absolute values and percentages.
     *
     * @param scanner Scanner instance used to read user input
     */
    public static void computeInterval(Scanner scanner) {
        System.out.print(">  "); // prompt
        String input = scanner.nextLine().trim();

        // Skip if input is empty
        if (input.isEmpty()) return;

        double baseValue;
        try {
            // Parse main number entered by user
            baseValue = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            // If the input is not a valid number → error message
            System.out.println("error: '" + input + "' is not valid input");
            return;
        }

        // Ask user for the interval
        System.out.print("Enter interval (e.g., 10% for ±10%, 5 for ±5 absolute)\n>  ");
        String intervalInput = scanner.nextLine().trim();

        if (intervalInput.isEmpty()) return; // skip if empty

        // Keep only digits, decimal points, and percent sign
        String cleaned = intervalInput.replaceAll("[^0-9.%]", "");

        // Determine if interval is percentage
        boolean isPercent = cleaned.endsWith("%");

        // Extract numeric part (without % if it exists)
        String numberPart = isPercent ? cleaned.substring(0, cleaned.length() - 1) : cleaned;

        // Remove unnecessary trailing zeros and trailing decimal point
        if (numberPart.contains(".")) {
            numberPart = numberPart.replaceAll("0+$", "").replaceAll("\\.$", "");
        }

        // Rebuild the final cleaned interval string
        cleaned = isPercent ? numberPart + "%" : numberPart;

        double lowerBound, upperBound;

        try {
            if (cleaned.endsWith("%")) {
                // Relative interval (percentage-based)
                String percStr = cleaned.substring(0, cleaned.length() - 1);
                double perc = Double.parseDouble(percStr) / 100.0;
                lowerBound = baseValue * (1 - perc);
                upperBound = baseValue * (1 + perc);

                // Show the chosen percentage interval
                System.out.println("Using ±" + percStr + "% interval.");
            } else {
                // Absolute interval
                double absInterval = Double.parseDouble(cleaned);
                lowerBound = baseValue - absInterval;
                upperBound = baseValue + absInterval;

                // Show the chosen absolute interval
                System.out.println("Using ±" + absInterval + " absolute interval.");
            }
        } catch (NumberFormatException e) {
            // If parsing failed → invalid interval
            System.out.println("error: '" + intervalInput + "' is not a valid interval");
            return;
        }

        // Determine whether results are integers or doubles
        boolean lowerIsInt = lowerBound == (int) lowerBound;
        boolean upperIsInt = upperBound == (int) upperBound;

        if (lowerIsInt && upperIsInt) {
            // Both values are exact integers
            System.out.println("[Interval] [" + (int) lowerBound + " , " + (int) upperBound + "]");
        } else {
            // Results involve decimals → ask how many decimals to display
            System.out.print("Enter number of decimal places to display: ");
            int decimals = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            // Dynamic formatting string, e.g. "%.2f"
            String format = "%." + decimals + "f";
            System.out.println("[Interval] [" + String.format(format, lowerBound) + " , " + String.format(format, upperBound) + "]");
        }
    }
}
