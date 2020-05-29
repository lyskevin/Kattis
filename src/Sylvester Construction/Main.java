import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            long n = fio.nextLong();
            long x = fio.nextLong();
            long y = fio.nextLong();
            int w = fio.nextInt();
            int h = fio.nextInt();
            for (long j = y; j < y + h; j++) {
                for (long k = x; k < x + w; k++) {
                    if (k > x) {
                        fio.print(" ");
                    }
                    fio.print(generateNumber(n, k, j, 0));
                }
                fio.println();
            }
            fio.println();
        }
        fio.close();
    }

    // Recursively divide matrix into 4 regions and count how many times the
    // position at the specified coordinates appears in the fourth quadrant
    private static int generateNumber(long n, long x, long y, int count) {
        if (n == 1) {
            return count % 2 == 0 ? 1 : -1;
        }
        count += x >= n / 2 && y >= n / 2 ? 1 : 0;
        return generateNumber(n / 2, x % (n / 2), y % (n / 2), count);
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

