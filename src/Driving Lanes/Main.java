import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final long INF = 1000000000000000l;
    private static int n;
    private static int m;
    private static long k;
    private static long r;
    private static long[] straights;
    private static Curve[] curves;
    private static long[][] dpTable;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        n = fio.nextInt();
        m = fio.nextInt();

        k = fio.nextLong();
        r = fio.nextLong();

        straights = new long[n];
        for (int i = 0; i < n; i++) {
            straights[i] = fio.nextLong();
        }

        curves = new Curve[n - 1];
        for (int i = 0; i < n - 1; i++) {
            curves[i] = new Curve(fio.nextLong(), fio.nextLong());
        }

        dpTable = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dpTable[i][j] = -1;
            }
        }

        solve(0, 0);
        fio.println(dpTable[0][0]);

        fio.close();
    }

    private static void solve(int index, int lane) {

        // Last straight
        if (index == n - 1) {
            if (dpTable[index][lane] == -1 && canChangeLane(index, lane, 0)) {
                dpTable[index][lane] = getLaneChangeDistance(lane, 0)
                        + straights[index] - k * lane;
            }
            return;
        }

        // Already memoized
        if (dpTable[index][lane] > -1) {
            return;
        }

        long result = INF;
        for (int i = 0; i < m; i++) {
            if (canChangeLane(index, lane, i)) {
                solve(index + 1, i);

                // Must be > 0 to be a valid distance
                if (dpTable[index + 1][i] > 0) {
                    long newDistance = getLaneChangeDistance(lane, i)
                            + straights[index] - k * Math.abs(lane - i)
                            + curves[index].s + curves[index].c * (i + 1)
                            + dpTable[index + 1][i];
                    result = Math.min(result, newDistance);
                }
            }
        }

        dpTable[index][lane] = result;
    }

    private static boolean canChangeLane(int index, int start, int end) {
        return straights[index] >= Math.abs(start - end) * k;
    }

    private static long getLaneChangeDistance(int start, int end) {
        return (k + r) * Math.abs(start - end);
    }

}

class Curve {
    long s;
    long c;

    Curve(long s, long c) {
        this.s = s;
        this.c = c;
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

