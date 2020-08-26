import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int N;
    private static int[] dpTable = new int[361];

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        N = fio.nextInt();
        int K = fio.nextInt();

        for (int i = 0; i <= 360; i++) {
            dpTable[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            solve(fio.nextInt());
        }

        // We know how to construct 360 degrees (draw a circle using the compass; see sample test case 2)
        solve(360);

        for (int i = 0; i < K; i++) {
            if (dpTable[fio.nextInt()] == 1) {
                fio.println("YES");
            } else {
                fio.println("NO");
            }
        }

        fio.close();
    }

    private static void solve(int angle) {
        
        // Stop here
        if (angle > 360) {
            return;
        }

        // Already memoized
        if (dpTable[angle] > -1) {
            return;
        }

        // Memoize this angle
        dpTable[angle] = 1;

        // Use this angle to generate new angles (if applicable)
        for (int i = 0; i <= 360; i++) {
            if (dpTable[i] == 1) {
                solve(Math.abs(angle - i)); // Difference
                solve(angle + i); // Sum
            }
        }
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

