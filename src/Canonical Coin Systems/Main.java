import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int[] denominations = new int[n];
        for (int i = 0; i < n; i++) {
            denominations[i] = fio.nextInt();
        }
        int limit = denominations[n - 2] + denominations[n - 1];
        int[] greedySolutions = new int[limit];
        int[] dpSolutions = new int[limit];
        boolean isCanonical = true;
        for (int i = 1; i < limit && isCanonical; i++) {
            greedySolutions[i] = calculateGreedySolution(i, denominations);
            // Useful for the relaxation (Math.min) operation in the dp method
            if (dpSolutions[i] == 0) {
                dpSolutions[i] = 10000000;
            }
            calculateDPSolution(i, denominations, dpSolutions);
            // Compare greedy and DP solutions
            if (greedySolutions[i] != dpSolutions[i]) {
                isCanonical = false;
            }
        }
        if (isCanonical) {
            fio.println("canonical");
        } else {
            fio.println("non-canonical");
        }
        fio.close();
    }

    private static int calculateGreedySolution(int amount, int[] denominations) {
        int n = denominations.length;
        int solution = 0;
        for (int i = n - 1; i >= 0 && amount > 0; i--) {
            if (amount >= denominations[i]) {
                solution += amount / denominations[i];
                amount %= denominations[i];
            }
        }
        return solution;
    }

    private static int calculateDPSolution(int amount, int[] denominations, int[] dpSolutions) {
        if (amount < 0) {
            // A number > 10000000 is chosen here so that
            // this result will not be used in the Math.min step
            return 1000000000;
        } else if (amount == 0) {
            return 0;
        } else {
            if (dpSolutions[amount] < 10000000) {
                return dpSolutions[amount];
            } else {
                // 2000000000 is chosen so that result will always be less
                // than this number by the end of the loop
                int result = 2000000000;
                for (int i = 0; i < denominations.length; i++) {
                    int newResult = 1 + calculateDPSolution(amount - denominations[i],
                            denominations, dpSolutions);
                    result = Math.min(result, newResult);
                }
                dpSolutions[amount] = result;
                return result;
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

