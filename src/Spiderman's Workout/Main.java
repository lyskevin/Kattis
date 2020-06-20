import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {


    private static int m;
    private static int[] distances;
    private static boolean hasSolution;
    private static int[][] memoTable;
    private static LinkedList<String> moves;
    private static int maxHeight;
    private static String solution;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            m = fio.nextInt();
            distances = new int[m];
            for (int j = 0; j < m; j++) {
                distances[j] = fio.nextInt();
            }
            hasSolution = false;
            memoTable = new int[m][1001];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 1001; k++) {
                    memoTable[j][k] = 1000000;
                }
            }
            moves = new LinkedList<>();
            maxHeight = 1000000;
            solve(0, 0, 0);
            if (hasSolution) {
                fio.println(solution);
            } else {
                fio.println("IMPOSSIBLE");
            }
        }
        fio.close();
    }

    private static void solve(int index, int height, int currentMaxHeight) {

        // Cannot have negative height
        if (height < 0) {
            return;
        }

        // Reached the end
        if (index == m) {
            if (height == 0 && currentMaxHeight < maxHeight) {
                hasSolution = true;
                maxHeight = currentMaxHeight;

                // Format output
                StringBuilder sb = new StringBuilder();
                for (String move : moves) {
                    sb.append(move);
                }
                solution = sb.toString();
            }
            return;
        }

        // Can reach current distance with lower max height
        if (currentMaxHeight < memoTable[index][height]) {
            memoTable[index][height] = currentMaxHeight;
            
            // Go up
            int upHeight = height + distances[index];
            moves.addLast("U");
            solve(index + 1, upHeight, Math.max(currentMaxHeight, upHeight));
            moves.removeLast();

            // Go down
            int downHeight = height - distances[index];
            moves.addLast("D");
            solve(index + 1, downHeight, currentMaxHeight);
            moves.removeLast();

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

