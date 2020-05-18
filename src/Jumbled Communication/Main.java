import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int[] messages = new int[256]; // Index: scrambled message; content: normal message

    public static void main(String[] args) {
        generateMessages();
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                fio.print(" ");
            }
            fio.print(messages[fio.nextInt()]);
        }
        fio.println();
        fio.close();
    }

    private static void generateMessages() {
        for (int i = 0; i < 256; i++) {
            messages[i ^ ((i << 1) & 255)] = i; // & 255 to limit scrambled message to 8 bits
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

