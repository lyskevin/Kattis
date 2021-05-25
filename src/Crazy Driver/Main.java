import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        int[] tollFees = new int[N - 1];
        int[] times = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            tollFees[i] = fio.nextInt();
        }

        fio.nextInt(); // T1 guaranteed to be 0
        for (int i = 0; i < N - 1; i++) {
            times[i] = fio.nextInt();
        }

        int index = 0;
        int minToll = Integer.MAX_VALUE;
        long time = 0l;
        long totalCost = 0l;

        while (index < N - 1) {
            time++;
            totalCost += tollFees[index];
            minToll = Math.min(minToll, tollFees[index]);

            if (time < times[index]) {
                long numberOfRoundTrips = ((times[index] - time + 1) / 2) * 2; // +1 to round up
                totalCost += numberOfRoundTrips * minToll; // long numberOfRoundTrips to prevent overflow
                time += numberOfRoundTrips;
            }

            index++;
        }

        fio.println(totalCost);

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

