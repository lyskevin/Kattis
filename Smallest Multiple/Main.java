import java.io.*;
import java.util.*;
import java.math.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                String[] input = fio.nextLine().split(" ");
                // Use BigInteger to avoid overflow
                BigInteger lcm = new BigInteger("1");
                for (int i = 0; i < input.length; i++) {
                    lcm = lcm(lcm, new BigInteger(input[i] + ""));
                }
                fio.println(lcm);
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }
    
    private static BigInteger gcd(BigInteger number1, BigInteger number2) {
        BigInteger max = number1.max(number2);
        BigInteger min = number1.min(number2);
        while (min.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = max.remainder(min);
            max = min;
            min = remainder;
        }
        return max;
    }

    private static BigInteger lcm(BigInteger number1, BigInteger number2) {
        return number1.multiply(number2).divide(gcd(number1, number2));
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

