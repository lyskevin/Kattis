import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * @author lyskevin
 */
public class Main {

    private static BigInteger[] stringLengths = new BigInteger[100001];

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        long k = fio.nextLong();
        calculateStringLengths(n);
        fio.println(getLetter(n, k));
        fio.close();
    }

    // Calculate string lengths up to the nth string
    private static void calculateStringLengths(int n) {
        BigInteger number1 = new BigInteger("1");
        BigInteger number2 = new BigInteger("1");
        stringLengths[1] = number1;
        stringLengths[2] = number2;
        for (int i = 3; i <= n; i++) {
            BigInteger newNumber = number1.add(number2);
            stringLengths[i] = newNumber;
            number1 = number2;
            number2 = newNumber;
        }
    }

    // Divide and conquer algorithm to find the required letter
    // Recursion was not used since it results in a StackOverflowError
    private static char getLetter(int n, long k) {
        while (true) {
            if (n == 1) {
                return 'N';
            } else if (n == 2) {
                return 'A';
            } else {
                BigInteger index = new BigInteger(k + "");
                // index k is in string n - 2
                if (index.compareTo(stringLengths[n - 2]) <= 0) {
                    n -= 2;
                } else {
                    // index k is in string n - 1
                    k = index.subtract(stringLengths[n - 2]).longValue();
                    n -= 1;
                }
            }
        }
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

