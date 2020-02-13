import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * @author lyskevin
 */
public class Main {

    private static int[] aValues;
    private static int[] bValues;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            String[] values = fio.nextLine().split(" ");
            String[] input = fio.nextLine().split(" ");
            aValues = new int[(values.length - 2) / 2];
            bValues = new int[(values.length - 2) / 2];
            for (int j = 0; j < aValues.length; j++) {
                aValues[j] = Integer.parseInt(values[j * 2]);
                bValues[j] = Integer.parseInt(values[j * 2 + 1]);
            }
            int c = Integer.parseInt(values[values.length - 2]);
            int d = Integer.parseInt(values[values.length - 1]);
            // Use BigInteger to avoid overflow
            BigInteger[][] memoTable = new BigInteger[101][101];
            for (int j = 0; j < input.length / 2; j++) {
                fio.println(f(Integer.parseInt(input[j * 2]), Integer.parseInt(input[j * 2 + 1]),
                    aValues, bValues, c, d, memoTable));
            }
            fio.println();
        }
        fio.close();
    }

    private static BigInteger f(int x, int y, int[] a, int[] b, int c, int d, BigInteger[][] memoTable) {
        // Base case
        if (x <= 0 || y <= 0) {
            return new BigInteger(d + "");
        }
        // (x, y) tuple calculated before
        if (memoTable[x][y] != null) {
            return memoTable[x][y];
        }
        // Standard recursive function with memoization
        BigInteger result = new BigInteger("0");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0 && b[i] == 0) {
                continue;
            }
            result = result.add(f(x - a[i], y - b[i], a, b, c, d, memoTable));
        }
        result = result.add(new BigInteger("" + c));
        memoTable[x][y] = result;
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

