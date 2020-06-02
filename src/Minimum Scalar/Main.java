import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fio.nextInt();
            long[] v1 = new long[n];
            long[] v2 = new long[n];
            for (int j = 0; j < n; j++) {
                v1[j] = fio.nextLong();
            }
            for (int j = 0; j < n; j++) {
                v2[j] = fio.nextLong();
            }
            Arrays.sort(v1);
            Arrays.sort(v2);
            long product = 0l;
            // Iterate from left to right (increasing order) for vector 1
            // and from right to left (decreasing order) for vector 2
            for (int j = 0; j < n; j++) {
                product += v1[j] * v2[n - j - 1];
            }
            fio.println("Case #" + (i + 1) + ": " + product);
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

