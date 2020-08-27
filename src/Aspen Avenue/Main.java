import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int N;
    private static int L;
    private static int W;
    private static double[] fixedPositions;
    private static double[] treePositions;
    private static double[][] dpTable;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        N = fio.nextInt();
        L = fio.nextInt();
        W = fio.nextInt();
        fixedPositions = new double[N / 2];

        double fixedPosition = 0.0;
        double increment = 1.0 * L / ((N / 2) - 1);
        for (int i = 0; i < N / 2; i++) {
            fixedPositions[i] = fixedPosition;
            fixedPosition += increment;
        }
        
        treePositions = new double[N];
        for (int i = 0; i < N; i++) {
            treePositions[i] = fio.nextDouble();
        }
        Arrays.sort(treePositions);

        dpTable = new double[(N / 2) + 1][(N / 2) + 1];
        for (int i = 0; i <= N / 2; i++) {
            for (int j = 0; j <= N/ 2; j++) {
                dpTable[i][j] = -1.0;
            }
        }
        dpTable[0][0] = 0.0;

        solve(N / 2, N / 2);

        fio.println(dpTable[N / 2][N / 2]);
        fio.close();
    }

    private static void solve(int leftRemaining, int rightRemaining) {
        int total = leftRemaining + rightRemaining;

        // Stop here
        if (total == 0) {
            return;
        }

        // Already memoized
        if (dpTable[leftRemaining][rightRemaining] > -1.0) {
            return;
        }

        int treeIndex = N - leftRemaining - rightRemaining;
        double treePosition = treePositions[treeIndex];

        // Put the current tree on the left
        double leftResult = Double.MAX_VALUE;
        if (leftRemaining > 0) {
            solve(leftRemaining - 1, rightRemaining);
            double verticalDistance = Math.abs(fixedPositions[(N / 2) - leftRemaining] - treePosition);
            leftResult = Math.min(leftResult, dpTable[leftRemaining - 1][rightRemaining] + verticalDistance);
        }

        // Put the current tree on the right
        double rightResult = Double.MAX_VALUE;
        if (rightRemaining > 0) {
            solve(leftRemaining, rightRemaining - 1);
            double verticalDistance = Math.abs(fixedPositions[(N / 2) - rightRemaining] - treePosition);
            rightResult = Math.min(rightResult,
                    dpTable[leftRemaining][rightRemaining - 1] + Math.sqrt((verticalDistance * verticalDistance)
                    + (W * W)));
        }

        // Take min(left, right)
        dpTable[leftRemaining][rightRemaining] = Math.min(leftResult, rightResult);
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

