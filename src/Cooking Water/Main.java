import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(fio.nextInt(), fio.nextInt());
        }
        boolean isPossible = false;
        for (int i = 0; i <= 1000 && !isPossible; i++) { // Try all times in [0, 1000]
            boolean isValidBoilingTime = true;
            for (int j = 0; j < n && isValidBoilingTime; j++) { // Check current time against all intervals
                if (intervals[j].start > i || intervals[j].end < i) {
                    isValidBoilingTime = false;
                }
            }
            if (isValidBoilingTime) {
                isPossible = true;
            }
        }
        if (isPossible) {
            fio.println("gunilla has a point");
        } else {
            fio.println("edward is right");
        }
        fio.close();
    }
}

class Interval {

    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
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

