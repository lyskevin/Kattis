import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int d = fio.nextInt();
        long[] prices = new long[d];
        for (int i = 0; i < d; i++) {
            prices[i] = fio.nextLong();
        }
        long total = 100l;
        long currentMinimum = prices[0];
        // General idea:
        // 1. Find every contiguous non-decreasing subsequence
        // 2. Buy at the start (if possible) and sell at the end of each subsequence
        for (int i = 1; i < d; i++) {
            if (prices[i] < prices[i - 1]) {
                total += Math.min(100000l, (total / currentMinimum)) * (prices[i - 1] - currentMinimum);
                currentMinimum = prices[i];
            }
        }
        if (prices[d - 1] > currentMinimum) {
            total += Math.min(100000l, (total / currentMinimum)) * (prices[d - 1] - currentMinimum); 
        }
        fio.println(total);
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

