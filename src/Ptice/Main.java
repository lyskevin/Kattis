import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        String s = fio.next();
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 && s.charAt(i) == 'A'
                || i % 3 == 1 && s.charAt(i) == 'B'
                || i % 3 == 2 && s.charAt(i) == 'C') {
                count1++;
            }
        }
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && s.charAt(i) == 'B'
                || i % 4 == 1 && s.charAt(i) == 'A'
                || i % 4 == 3 && s.charAt(i) == 'C') {
                count2++;
            }
        }
        int count3 = 0;
        for (int i = 0; i < n; i++) {
            if (((i % 6 == 0 || i % 6 == 1) && s.charAt(i) == 'C')
                || ((i % 6 == 2 || i % 6 == 3) && s.charAt(i) == 'A')
                || ((i % 6 == 4 || i % 6 == 5) && s.charAt(i) == 'B')) {
                count3++;
            }
        }
        int max = Math.max(Math.max(count1, count2), count3);
        fio.println(max);
        if (count1 == max) {
            fio.println("Adrian");
        }
        if (count2 == max) {
            fio.println("Bruno");
        }
        if (count3 == max) {
            fio.println("Goran");
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

