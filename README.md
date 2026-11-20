# MIASHS — First-Year Programming Portfolio

Java exercises from my first year of the Licence MIASHS (applied mathematics, computer science and social sciences) at Université Grenoble Alpes.

Each exercise is kept in **two versions**:

| Folder | What it is |
|---|---|
| `Original/` | the solution as written for the tutorial: the minimal answer to the question |
| `Improved/` | the same exercise reworked afterwards, with input validation, an interactive loop, error messages, Javadoc and extra features |

Comparing the two shows how the code evolved, from "it works on the happy path" to "it handles real input".

## Tutorial 1 (2024)

| Exercise | Original | Improved |
|---|---|---|
| **01: Product** | multiplies two integers | multiplies any number of factors typed as `2 * 3.5 * 4`, rejects invalid factors, and prints an integer when the result is exact |
| **02: Interval** | prints `[x − 10 %, x + 10 %]` | the interval can be a percentage (`10%`) or an absolute value (`5`), with a choice of decimal places |
| **03: Digit split** | splits a 4-digit integer into its digits | works for any integer or real number, including negatives, and extracts the digit at a chosen position |
| **05: Digits of π** | the n-th decimal of π using `Math.PI` | a range of digits, with an optional high-precision mode: about 200 digits computed with the Gauss–Legendre algorithm and `BigDecimal` |

## Running an exercise

Requires a JDK (17 or newer). Each file is a standalone program, for example:

```bash
cd Improved/Tutorial1_2024
java EX02_Developed_Interval_Calculator.java
```

The improved versions run in a loop; press `Ctrl+C` to quit.

## License

MIT — see [LICENSE](LICENSE).
