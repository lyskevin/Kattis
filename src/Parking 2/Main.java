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
            int[] storeLocations = new int[n];
            for (int j = 0; j < n; j++) {
                storeLocations[j] = fio.nextInt();
            }
            Arrays.sort(storeLocations);
            int minimumDistance = 1000000;
            for (int j = 0; j < 100; j++) {
                // Total distance = 2 * distance to store at lowest x coordinate
                //                  + 2 * distance to store at highest x coordinate
                int distance = 2 * Math.abs(storeLocations[0] - j)
                        + 2 * Math.abs(storeLocations[n - 1] - j);
                minimumDistance = Math.min(minimumDistance, distance);
            }
            fio.println(minimumDistance);
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

