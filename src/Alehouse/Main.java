import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int k = fio.nextInt();
        PriorityQueue<Integer> arrivals = new PriorityQueue<>();
        PriorityQueue<Integer> departures = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            arrivals.offer(fio.nextInt());
            departures.offer(fio.nextInt());
        }

        int current = 0;
        int max = 0;

        while (!arrivals.isEmpty()) {
            int arrival = arrivals.poll();
            current++;

            while (!departures.isEmpty() && departures.peek() + k < arrival) {
                departures.poll();
                current--;
            }

            max = Math.max(current, max);
        }

        fio.println(max);

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

