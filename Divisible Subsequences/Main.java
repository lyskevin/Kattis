import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int c = fio.nextInt();
        for (int i = 0; i < c; i++) {
            int d = fio.nextInt();
            int n = fio.nextInt();
            long count = 0;
            int[] subsequenceRemainderFrequencies = new int[d];
            int remainder = 0;
            for (int j = 0; j < n; j++) {
                int number = fio.nextInt();
                remainder = (number % d + remainder) % d;
                if (remainder == 0) {
                    count++;
                }

                // If there are k prior subsequences with the same remainder,
                // number of new subsequences with remainder 0 (i.e. that are divisible by d) = k.
                // Since the remainder of both the current sum and that of any such prior
                // subsequence is k, then (current sum - any such prior subsequence) has a remainder of 0
                count += subsequenceRemainderFrequencies[remainder];

                // Keep track of frequencies of remainders in the range [0, d) among all prior subsequences
                subsequenceRemainderFrequencies[remainder]++;
            }
            fio.println(count);
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

