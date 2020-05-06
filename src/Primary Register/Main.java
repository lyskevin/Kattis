import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int[] capacities = {2, 3, 5, 7, 11, 13, 17, 19};
    private static int[] values = new int[8];
    private static boolean hasOverflowed = false;
    private static int numberOfOperations = 0;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String[] input = fio.nextLine().split(" ");
        for (int i = 0; i < 8; i++) {
            values[i] = Integer.parseInt(input[i]);
        }
        while (!hasOverflowed) {
            increment();
            numberOfOperations++;
        }
        fio.println(numberOfOperations - 1);
        fio.close();
    }

    // Increment operation
    private static void increment() {
        for (int i = 0; i < 8; i++) {
            values[i]++;
            if (values[i] == capacities[i]) {
                if (i == 7) { // Last register has overflowed
                    hasOverflowed = true;
                } else {
                    values[i] = 0;
                }
            } else {
                break;
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

