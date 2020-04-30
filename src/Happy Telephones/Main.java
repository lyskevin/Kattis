import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        while (!(n == 0 && m == 0)) {
            // Store calls
            Call[] calls = new Call[n];
            for (int i = 0; i < n; i++) {
                fio.nextInt();
                fio.nextInt();
                calls[i] = new Call(fio.nextInt(), fio.nextInt());
            }
            // Iterate over each interval of interest
            for (int i = 0; i < m; i++) {
                int start = fio.nextInt();
                int end = start + fio.nextInt();
                int count = 0;
                // Iterate over each call to see if some part of it is within the current interval
                for (int j = 0; j < n; j++) {
                    Call call = calls[j];
                    if (call.start < end && call.end > start) {
                        count++;
                    }
                }
                fio.println(count);
            }
            n = fio.nextInt();
            m = fio.nextInt();
        }
        fio.close();
    }
}

class Call {

    int start;
    int end;

    Call(int start, int duration) {
        this.start = start;
        this.end = start + duration;
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

