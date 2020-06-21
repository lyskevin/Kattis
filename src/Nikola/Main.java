import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int n;
    private static int[] costs;
    private static int[][] memoTable;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        n = fio.nextInt();
        costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = fio.nextInt();
        }
        memoTable = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memoTable[i][j] = 1000000000;
            }
        }
        fio.println(solve(1, 1));
        fio.close();
    }

    private static int solve(int position, int previousJump) {

        // Out of board
        if (position < 0 || position >= n) {
            return 1000000000;
        }

        // Reached destination
        if (position == n - 1) {
            return costs[n - 1];
        }
        
        // Current position and number of jumps already memoized
        if (memoTable[position][previousJump] < 1000000000) {
            return memoTable[position][previousJump];
        }

        int back = solve(position - previousJump, previousJump); // Go back
        int forward = solve(position + previousJump + 1, previousJump + 1); // Go forward
        int result = costs[position] + Math.min(back, forward); // Result = current cost + min
        memoTable[position][previousJump] = result; // Memoize result
        return result;

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

