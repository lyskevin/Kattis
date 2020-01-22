import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int t = fio.nextInt();
        int a = fio.nextInt();
        int b = fio.nextInt();
        int c = fio.nextInt();
        long time = fio.nextLong();
        // Generate and sort time to solve each problem in ascending order
        int[] times = new int[n];
        times[0] = (int) time;
        for (int i = 1; i < n; i++) {
            time = ((a * time + b) % c) + 1;
            times[i] = (int) time;
        }
        Arrays.sort(times);
        long totalTime = 0l;
        long penalty = 0l;
        int count = 0;
        // Greedily select problems according to solve time and calculate penalty accordingly
        for (int i = 0; i < n && t >= times[i]; i++) {
            t -= times[i];
            totalTime = (times[i] + totalTime) % 1000000007;
            penalty = (penalty + totalTime) % 1000000007;
            count++;
        }
        fio.println(count + " " + penalty);
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

