import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = fio.nextInt();
        }

        HashSet<Integer> gcds = new HashSet<>();
        HashSet<Integer> previousGcds = new HashSet<>();
        for (int i = 0; i < n; i++) {
            HashSet<Integer> newGcds = new HashSet<>();
            for (int gcd : previousGcds) {
                int newGcd = gcd(gcd, A[i]);
                newGcds.add(newGcd);
                gcds.add(newGcd);
            }
            newGcds.add(A[i]);
            gcds.add(A[i]);
            previousGcds = newGcds;
        }

        fio.println(gcds.size());
        fio.close();
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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

