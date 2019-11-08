import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String input = fio.next();
        int a = 0;
        int b = 0;
        boolean isDeuce = false;
        for (int i = 0; i < input.length(); i += 2) {
            if (input.charAt(i) == 'A') {
                a += input.charAt(i + 1) - '0';
            } else {
                b += input.charAt(i + 1) - '0';
            }
            if (a == 10 && b == 10) {
                isDeuce = true;
            }
            if (isDeuce) {
                if (a >= b + 2) {
                    fio.println("A");
                } else if (b >= a + 2) {
                    fio.println("B");
                }
            } else {
                if (a >= 11) {
                    fio.println("A");
                } else if (b >= 11) {
                    fio.println("B");
                }
            }
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

