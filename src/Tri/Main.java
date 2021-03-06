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
        if (a + b == c) {
            fio.println(a + "+" + b + "=" + c);
        } else if (a - b == c) {
            fio.println(a + "-" + b + "=" + c);
        } else if (a * b == c) {
            fio.println(a + "*" + b + "=" + c);
        } else if (a / b == c && a % b == 0) {
            fio.println(a + "/" + b + "=" + c);
        } else if (a == b + c) {
            fio.println(a + "=" + b + "+" + c);
        } else if (a == b - c) {
            fio.println(a + "=" + b + "-" + c);
        } else if (a == b * c) {
            fio.println(a + "=" + b + "*" + c);
        } else {
            fio.println(a + "=" + b + "/" + c);
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

