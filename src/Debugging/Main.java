import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static long[] dpTable;
    private static long r;
    private static long p;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        r = fio.nextLong();
        p = fio.nextLong();
        dpTable = new long[n + 1];

        solve(n);

        fio.println(dpTable[n]);
        fio.close();
    }

    private static void solve(int n) {
        if (n < 2 || dpTable[n] > 0) {
            return;
        }

        long result = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int newLines = n / (i + 1);
            if (n % (i + 1) > 0) {
                newLines++;
            }
            solve(newLines);
            
            result = Math.min(result, p * i + r + dpTable[newLines]);
        }

        dpTable[n] = result;
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

