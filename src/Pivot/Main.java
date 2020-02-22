import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = fio.nextInt();
        }
        int[] leftMaximums = new int[n];
        int[] rightMinimums = new int[n];
        int leftMaximum = 0;
        int rightMinimum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            leftMaximum = Math.max(array[i], leftMaximum);
            leftMaximums[i] = leftMaximum;
            rightMinimum = Math.min(array[n - 1 - i], rightMinimum);
            rightMinimums[n - 1 - i] = rightMinimum;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && leftMaximums[i] <= array[i] && rightMinimums[i + 1] > array[i]
                    || i == n - 1 && leftMaximums[i] <= array[i]) {
                count++;
            }
        }
        fio.println(count);
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

