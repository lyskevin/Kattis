import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int c = fio.nextInt();
        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = fio.nextInt();
        }
        int maxNumberOfFruits = 0;
        for (int i = 0; i < n; i++) {
            int totalWeight = 0;
            int numberOfFruits = 0;
            for (int j = i; j < n; j++) {
                if (totalWeight + fruits[j] <= c) {
                    numberOfFruits++;
                    totalWeight += fruits[j];
                }
            }
            maxNumberOfFruits = Math.max(numberOfFruits, maxNumberOfFruits);
        }
        fio.println(maxNumberOfFruits);
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

