import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        boolean[] buses = new boolean[1001];
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            buses[fio.nextInt()] = true;
        }
        boolean hasPriorOutput = false;
        for (int i = 1; i <= 1000; i++) {
            int start = i;
            int end = i;
            int count = 0;
            while (i <= 1000 && buses[i]) {
                end = i;
                i++;
                count++;
            }
            if (hasPriorOutput && count > 0) {
                fio.print(" ");
            }
            if (count == 1) {
                fio.print(start);
                hasPriorOutput = true;
            }
            if (count == 2) {
                fio.print(start);
                fio.print(" " + end);
                hasPriorOutput = true;
            }
            if (count > 2) {
                fio.print(start + "-" + end);
                hasPriorOutput = true;
            }
        }
        fio.println();
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

