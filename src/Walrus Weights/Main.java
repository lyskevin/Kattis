import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int n;
    private static int[] weights;
    private static boolean[][] memoTable = new boolean[1001][2000];
    private static int solution = -1;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        n = fio.nextInt();
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = fio.nextInt();
        }
        solve(0, 0);
        fio.println(solution);
        fio.close();
    }

    private static void solve(int index, int totalWeight) {

        // Can always find a better solution in this case
        if (totalWeight > 1999) {
            return;
        }

        // Generate optimal solution
        if (index == n) {
            solution = chooseSolution(solution, totalWeight);
            return;
        }

        if (!memoTable[index][totalWeight]) {
            memoTable[index][totalWeight] = true;
            solve(index + 1, totalWeight + weights[index]); // Use the current weight
            solve(index + 1, totalWeight); // Do not use the current weight
        }

    }

    private static int chooseSolution(int num1, int num2) {
        int diff1 = Math.abs(1000 - num1);
        int diff2 = Math.abs(1000 - num2);
        if (diff1 > diff2) {
            return num2;
        } else if (diff1 < diff2) {
            return num1;
        } else {
            return Math.max(num1, num2);
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

