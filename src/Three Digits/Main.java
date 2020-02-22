import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        long factorial = 1;
        int numberOfTwos = 0;
        int numberOfFives = 0;
        for (int i = 1; i <= n; i++) {
            int iCopy = i;
            // Remove all twos
            while (iCopy % 2 == 0) {
                iCopy /= 2;
                numberOfTwos++;
            }
            // Remove all fives
            while (iCopy % 5 == 0) {
                iCopy /= 5;
                numberOfFives++;
            }
            // Keep 9 trailing digits
            factorial = (factorial * iCopy) % 1000000000;
        }
        int numberOfTwosToCompensate = numberOfTwos - numberOfFives;
        // Multiply factorial by the appropriate number of twos
        // since some number of twos are leftover after being used to get rid of trailing zeroes
        for (int i = 0; i < numberOfTwosToCompensate; i++) {
            factorial = (factorial * 2) % 1000000000;
        }
        // Only want formatted strings for n >= 7 since n! will then have >= 3 digits after the trailing zeroes
        if (n >= 7) {
            fio.println(String.format("%03d", factorial % 1000));
        } else {
            fio.println(factorial % 1000);
        }
        fio.close();
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

