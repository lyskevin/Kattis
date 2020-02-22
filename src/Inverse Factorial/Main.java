import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String s = fio.nextLine();
        // The logarithmic method is too imprecise for small values of the factorial
        if (s.equals("1")) {
            fio.println(1);
        } else if (s.equals("2")) {
            fio.println(2);
        } else if (s.equals("6")) {
            fio.println(3);
        } else {
            // Take log base 10 of the number's first digit
            double mantissa = Math.log10(Double.parseDouble(s.substring(0, 1)));
            double logApprox = mantissa + s.length() - 1;
            double factorialLog = 0.0;
            int n = 0;
            while (factorialLog < logApprox) {
                n++;
                factorialLog += Math.log10(n);
            }
            fio.println(n);
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

