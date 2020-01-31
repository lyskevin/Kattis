import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        char b = fio.next().charAt(0);
        int total = 0;
        for (int i = 0; i < 4 * n; i++) {
            String s = fio.next();
            int number = s.charAt(0);
            int suit = s.charAt(1);
            // Increment total according to number and suit
            if (number == 'A') {
                total += 11;
            } else if (number == 'K') {
                total += 4;
            } else if (number == 'Q') {
                total += 3;
            } else if (number == 'J') {
                if (suit == b) {
                    total += 20;
                } else {
                    total += 2;
                }
            } else if (number == 'T') {
                total += 10;
            } else if (number == '9') {
                if (suit == b) {
                    total += 14;
                }
            }
        }
        fio.println(total);
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

