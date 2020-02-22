import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                int n = fio.nextInt();
                int[] numbers = new int[n];
                boolean[] differences = new boolean[n];
                for (int i = 0; i < n; i++) {
                    numbers[i] = fio.nextInt();
                }
                for (int i = 0; i < n - 1; i++) {
                    int difference = Math.abs(numbers[i] - numbers[i + 1]);
                    if (difference <= n - 1) {
                        differences[difference] = true;
                    }
                }
                boolean isJolly = true;
                for (int i = 1; i < n; i++) {
                    if (!differences[i]) {
                        isJolly = false;
                        break;
                    }
                }
                if (isJolly) {
                    fio.println("Jolly");
                } else {
                    fio.println("Not jolly");
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
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

