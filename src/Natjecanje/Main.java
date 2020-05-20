import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static boolean[] usableKayaks;
    private static boolean[] reserveKayaks;
    private static int n;
    private static int minimum;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        n = fio.nextInt();
        int s = fio.nextInt();
        int r = fio.nextInt();
        usableKayaks = new boolean[n];
        reserveKayaks = new boolean[n];
        for (int i = 0; i < n; i++) {
            usableKayaks[i] = true;
        }
        for (int i = 0; i < s; i++) {
            usableKayaks[fio.nextInt() - 1] = false;
        }
        for (int i = 0; i < r; i++) {
            reserveKayaks[fio.nextInt() - 1] = true;
        }
        minimum = s;
        generateKayakAssignments(0);
        fio.println(minimum);
        fio.close();
    }

    private static void generateKayakAssignments(int index) {
        if (index == n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(!usableKayaks[i]) {
                    count++;
                }
            }
            minimum = Math.min(minimum, count);
            return;
        }
        if (reserveKayaks[index]) {
            // Pass reserve kayak to the left if applicable
            if (index > 0 && !usableKayaks[index - 1]) {
                usableKayaks[index - 1] = true;
                generateKayakAssignments(index + 1);
                usableKayaks[index - 1] = false;
            }
            // Pass reserve kayak to the right if applicable
            if (index < n - 1 && !usableKayaks[index + 1]) {
                usableKayaks[index + 1] = true;
                generateKayakAssignments(index + 1);
                usableKayaks[index + 1] = false;
            }
            // Use reserve kayak if applicable
            if (!usableKayaks[index]) {
                usableKayaks[index] = true;
                generateKayakAssignments(index + 1);
                usableKayaks[index] = false;
            }
        }
        // Do nothing
        generateKayakAssignments(index + 1);
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

