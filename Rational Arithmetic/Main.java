import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = fio.nextInt();
            int y1 = fio.nextInt();
            String op = fio.next();
            int x2 = fio.nextInt();
            int y2 = fio.nextInt();
            Fraction f1 = new Fraction(x1, y1);
            Fraction f2 = new Fraction(x2, y2);
            // Perform operations with fractions
            if (op.equals("+")) {
                fio.println(f1.add(f2));
            } else if (op.equals("-")) {
                fio.println(f1.subtract(f2));
            } else if (op.equals("*")) {
                fio.println(f1.multiply(f2));
            } else {
                fio.println(f1.divide(f2));
            }
        }
        fio.close();
    }
}

/**
 * Helper class to handle fractions.
 */
class Fraction {

    private static final int DEFAULT_DENOMINATOR = 1;

    long numerator;
    long denominator;

    /**
     * Constructs a fraction with the specified numerator.
     * The denominator will be set to 1.
     * @param numerator The specified numerator.
     */
    Fraction(long numerator) {
        this.numerator = numerator;
        this.denominator = DEFAULT_DENOMINATOR;
    }

    /**
     * Constructs a fraction with the specified numerator and denominator.
     * @param numerator The specified numerator.
     * @param denominator The specified denominator.
     */
    Fraction(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        if (denominator > 0) {
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        } else if (denominator < 0) {
            this.numerator = numerator / gcd * -1;
            this.denominator = denominator / gcd * -1;
        } else {
            throw new IllegalArgumentException("Denominator cannot be 0.");
        }
    }

    /**
     * Returns the result of summing this and the specified fraction.
     * @param other The specified fraction.
     * @return The result of summing this and the specified fraction.
     */
    Fraction add(Fraction other) {
        long newNumerator = this.numerator * other.denominator
            + other.numerator * this.denominator;
        long newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Returns the result of subtracting the specified fraction from this.
     * @param other The specified fraction.
     * @return The result of subtracting the specified fraction from this.
     */
    Fraction subtract(Fraction other) {
        long newNumerator = this.numerator * other.denominator
            - other.numerator * this.denominator;
        long newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Returns the result of multiplying this by the specified fraction.
     * @param other The specified fraction.
     * @return The result of multiplying this by the specified fraction.
     */
    Fraction multiply(Fraction other) {
        long newNumerator = this.numerator * other.numerator;
        long newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Returns the result of dividing this by the specified fraction.
     * @param other The specified fraction.
     * @return The result of dividing this by the specified fraction.
     */
    Fraction divide(Fraction other) {
        long newNumerator = this.numerator * other.denominator;
        long newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Returns the reciprocal of this fraction.
     * @return The reciprocal of this fraction.
     */
    Fraction reciprocal() {
        return new Fraction(denominator, numerator);
    }

    /**
     * Returns a copy of this fraction.
     * @return A copy of this fraction.
     */
    Fraction copy() {
        return new Fraction(numerator, denominator);
    }

    /**
     * Returns the string representation of this fraction.
     * @return The string representation of this fraction.
     */
    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }

    /**
     * Returns the greatest common divisor (gcd) of the two specified numbers.
     * The gcd will always be positive.
     * @param number1 The first specified number.
     * @param number2 The second specified number.
     * @return The gcd of the two specified numbers.
     */
    private static long gcd(long number1, long number2) {
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        long max = Math.max(number1, number2);
        long min = Math.min(number1, number2);
        while (min > 0) {
            long remainder = max % min;
            max = min;
            min = remainder;
        }
        return max;
    }

    /**
     * Returns the lowest common multiple (lcm) of the two specified numbers.
     * @param number1 The first specified number.
     * @param number2 The second specified number.
     * @return The lcm of the two specified numbers.
     */
    private static long lcm(long number1, long number2) {
        return (number1 * number2) / gcd(number1, number2);
    }

}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}

