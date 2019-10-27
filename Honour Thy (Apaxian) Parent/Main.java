import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String y = fio.next();
        String p = fio.next();
        if (y.charAt(y.length() - 1) == 'e') {
            fio.println(y + "x" + p);
        } else if (y.charAt(y.length() - 1) == 'a'
                   || y.charAt(y.length() - 1) == 'i'
                   || y.charAt(y.length() - 1) == 'o'
                   || y.charAt(y.length() - 1) == 'u') {
            fio.println(y.substring(0, y.length() - 1) + "ex" + p);
        } else if (y.charAt(y.length() - 2) == 'e' && y.charAt(y.length() - 1) == 'x') {
            fio.println(y + p);
        } else {
            fio.println(y + "ex" + p);
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

