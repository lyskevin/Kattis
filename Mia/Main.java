import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int a = fio.nextInt();
        int b = fio.nextInt();
        int c = fio.nextInt();
        int d = fio.nextInt();
        while (a > 0 || b > 0 || c > 0 || d > 0) {
            int num1 = Integer.parseInt(Math.max(a, b) + "" + Math.min(a, b));
            int num2 = Integer.parseInt(Math.max(c, d) + "" + Math.min(c, d));
            if (num1 == num2) {
                fio.println("Tie.");
            } else if (num1 == 21 && num2 != 21) {
                fio.println("Player 1 wins.");
            } else if (num2 == 21 && num1 != 21) {
                fio.println("Player 2 wins.");
            } else if (a == b && c != d) {
                fio.println("Player 1 wins.");
            } else if (c == d && a != b) {
                fio.println("Player 2 wins.");
            } else if (num1 > num2) {
                fio.println("Player 1 wins.");
            } else {
                fio.println("Player 2 wins.");
            }
            a = fio.nextInt();
            b = fio.nextInt();
            c = fio.nextInt();
            d = fio.nextInt();
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

