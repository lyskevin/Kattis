import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static long[] A;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        // longs because a * x might be > Integer.MAX_VALUE
        int n = fio.nextInt();
        long m = fio.nextLong();
        long a = fio.nextLong();
        long c = fio.nextLong();
        long x = fio.nextLong();
        A = new long[n];

        for (int i = 0; i < n; i++) {
            A[i] = (a * x + c) % m;
            x = A[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            // Binary search unsorted array
            if (binarySearch(A[i], 0, n - 1)) {
                count++;
            }
        }

        fio.println(count);
        fio.close();
    }

    private static boolean binarySearch(long number, int low, int high) {
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (A[middle] == number) {
                return true;
            } else if (A[middle] < number) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return false;
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

