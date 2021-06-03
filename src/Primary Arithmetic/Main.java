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

        while (a > 0 || b > 0) {
            simulate(a, b, fio);
            a = fio.nextInt();
            b = fio.nextInt();
        }

        fio.close();
    }

    private static void simulate(int a, int b, FastIO fio) {
        int count = 0;
        int carry = 0;

        while (a > 0 || b > 0) {
            carry = ((a % 10) + (b % 10) + carry) / 10;
            count += carry;
            a /= 10;
            b /= 10;
        }

        if (count == 0) {
            fio.println("No carry operation.");
        } else if (count == 1) {
            fio.println("1 carry operation.");
        } else {
            fio.println(count + " carry operations.");
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

