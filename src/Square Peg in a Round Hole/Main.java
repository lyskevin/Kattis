import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        int k = fio.nextInt();
        int[] plots = new int[n];
        int[] houses = new int[m + k];
        for (int i = 0; i < n; i++) {
            plots[i] = fio.nextInt();
        }
        for (int i = 0; i < m; i++) {
            houses[i] = fio.nextInt();
        }
        for (int i = m; i < m + k; i++) {
            int length = fio.nextInt();
            houses[i] = (int) Math.sqrt(2 * (length / 2.0) * (length / 2.0));
        }
        Arrays.sort(plots);
        Arrays.sort(houses);
        int plotIndex = 0;
        int houseIndex = 0;
        int count = 0;
        while (plotIndex < n && houseIndex < m + k) {
            if (houses[houseIndex] < plots[plotIndex]) {
                count++;
                houseIndex++;
            }
            plotIndex++;
        }
        fio.println(count);
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

