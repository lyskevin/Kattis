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
            int w = fio.nextInt();
            long lcm = 1l;
            // Answer is the least common multiple among all the given numbers
            for (int j = 0; j < w; j++) {
                lcm = lcm(lcm, fio.nextLong());
            }
            if (lcm > 1000000000l) {
                fio.println("More than a billion.");
            } else {
                fio.println(lcm);
            }
        }
        fio.close();
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

