import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String s1 = fio.nextLine();
        String s2 = fio.nextLine();
        int start = 0;
        int min = Math.min(s1.length(), s2.length());
        // Greedily match from start
        while (start < min && s1.charAt(start) == s2.charAt(start)) {
            start++;
        }
        // Handle edge cases, e.g. s1 = "A" and s2 = "AAA"
        if (start == min && s1.length() == min) {
            fio.println(s2.length() - s1.length());
        } else {
            int end = 1;
            // Greedily match from end
            while (end <= min && s1.charAt(s1.length() - end) == s2.charAt(s2.length() - end)) {
                end++;
            }
            // Answer = Portion of substring in the middle that does not match
            fio.println(Math.max(0, s2.length() - end - start + 1));
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

