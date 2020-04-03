import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int s = fio.nextInt();
        int t = fio.nextInt();
        int n = fio.nextInt();
        int[] walkTimes = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            walkTimes[i] = fio.nextInt();
        }
        int[] busTimes = new int[n];
        for (int i = 0; i < n; i++) {
            busTimes[i] = fio.nextInt();
        }
        int[] busIntervals = new int[n];
        for (int i = 0; i < n; i++) {
            busIntervals[i] = fio.nextInt();
        }
        int time = s + walkTimes[0];
        for (int i = 0; i < n; i++) {
            int nextBusArrivalTime = (busIntervals[i] - (time % busIntervals[i])) % busIntervals[i];
            time += nextBusArrivalTime + busTimes[i] + walkTimes[i + 1];
        }
        if (time <= t) {
            fio.println("yes");
        } else {
            fio.println("no");
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

