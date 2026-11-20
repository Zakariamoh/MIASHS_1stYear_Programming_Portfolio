import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

/**
 * EX05_Developed_Pi_Decimal_Finder
 *
 * Interactive program that extracts one or multiple decimal digits of π (Pi).
 * 
 * Features:
 * - Input validation for digit position and count
 * - Option to switch between standard double precision and high precision (BigDecimal)
 * - Clean formatted output
 * - Graceful handling of invalid user input
 */
public class EX05_Developed_Pi_Decimal_Finder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Continuous interactive loop
        while (true)
            findPiDigits(scanner);
    }

    /**
     * Reads and validates user input, then displays the requested digits of π.
     *
     * @param s Scanner object for reading user input
     */
    public static void findPiDigits(Scanner s) {
        // === Input: starting position ===
        System.out.print("Enter the starting position after the decimal point (e.g., 1 for first digit): ");
        String positionInput = s.nextLine().trim();
        if (positionInput.isEmpty()) return; // exit silently if no input

        int startPosition;
        try {
            startPosition = Integer.parseInt(positionInput);
            if (startPosition <= 0) {
                System.out.println("error: position must be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("error: '" + positionInput + "' is not a valid integer.");
            return;
        }

        // === Input: number of digits to display ===
        System.out.print("How many digits do you want to display (1 for a single digit)? ");
        String countInput = s.nextLine().trim();
        if (countInput.isEmpty()) return;

        int count;
        try {
            count = Integer.parseInt(countInput);
            if (count <= 0) {
                System.out.println("error: count must be positive.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("error: '" + countInput + "' is not a valid integer.");
            return;
        }

        // === Input: precision mode ===
        System.out.print("Use high precision mode? (y/n): ");
        String precisionChoice = s.nextLine().trim().toLowerCase();
        boolean highPrecision = precisionChoice.equals("y");

        // === Computation ===
        String piDigits = getPiDigits(startPosition, count, highPrecision);

        // Check for computation failure (e.g., insufficient precision)
        if (piDigits == null) {
            System.out.println("error: could not compute digits.");
            return;
        }

        // === Output result ===
        System.out.println("[π] Digits from position " + startPosition + " → " + (startPosition + count - 1) + ": " + piDigits);
        System.out.println();
    }

    /**
     * Extracts a substring of the decimal digits of π (after the decimal point).
     * Can operate in two modes:
     *  - Standard precision (using Math.PI)
     *  - High precision (using BigDecimal)
     *
     * @param start starting digit index (1-based)
     * @param count number of digits to extract
     * @param highPrecision true to use BigDecimal for computation
     * @return the requested digits as a String, or null if unavailable
     */
    public static String getPiDigits(int start, int count, boolean highPrecision) {
        String piString;

        if (highPrecision) {
            // Compute π with arbitrary precision (~200 digits)
            BigDecimal pi = computePi(200);
            piString = pi.toPlainString();
        } else {
            // Standard double precision (≈15 digits)
            piString = String.valueOf(Math.PI);
        }

        // Locate the decimal separator and isolate fractional part
        int dotIndex = piString.indexOf('.');
        if (dotIndex == -1) return null; // sanity check

        String decimals = piString.substring(dotIndex + 1);

        // Ensure the requested range exists within available precision
        if (start > decimals.length()) {
            System.out.println("error: π precision is too low to extract that digit.");
            return null;
        }

        // Compute safe upper bound
        int endIndex = Math.min(start - 1 + count, decimals.length());

        // Extract and return the requested segment
        return decimals.substring(start - 1, endIndex);
    }

    /**
     * Computes π using the Gauss–Legendre iterative algorithm.
     * This algorithm converges quadratically, doubling precision each iteration.
     *
     * @param precision desired precision in decimal digits
     * @return BigDecimal approximation of π
     */
    public static BigDecimal computePi(int precision) {
        MathContext mc = new MathContext(precision);

        // Initial values of the algorithm
        BigDecimal a = BigDecimal.ONE;
        BigDecimal b = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.sqrt(2)), mc);
        BigDecimal t = BigDecimal.valueOf(0.25);
        BigDecimal p = BigDecimal.ONE;

        // Iterative process — 10 iterations yield ≈200 digits
        for (int i = 0; i < 10; i++) {
            BigDecimal aNext = a.add(b).divide(BigDecimal.valueOf(2), mc);
            BigDecimal bNext = a.multiply(b, mc).sqrt(mc);
            BigDecimal diff = a.subtract(aNext, mc);
            t = t.subtract(p.multiply(diff.pow(2, mc), mc), mc);
            a = aNext;
            b = bNext;
            p = p.multiply(BigDecimal.valueOf(2));
        }

        // Final formula: π = (a + b)² / (4t)
        BigDecimal numerator = a.add(b, mc).pow(2, mc);
        BigDecimal denominator = BigDecimal.valueOf(4).multiply(t, mc);
        return numerator.divide(denominator, mc);
    }
}
