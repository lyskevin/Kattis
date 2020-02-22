import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String s = fio.nextLine();
        while (!s.equals(".")) {
            int index = kmp(s, s + s);
            fio.println(s.length() / index);
            s = fio.nextLine();
        }
        fio.close();
    }

    // KMP string matching algorithm
    private static int kmp(String p, String s) {
        int[] prefixes = prefix(p);
        int i = 0, j = 0;
        while (i < s.length()) {
            // Find next largest border at prefixes[j]
            while (j >= 0 && s.charAt(i) != p.charAt(j)) {
                j = prefixes[j];
            }
            i++;
            j++;
            // Return first occurrence of s in s + s after index 0,
            // i.e. we do not want the first/left s in s + s
            if (j == p.length()) {
                if (i > p.length()) {
                    return i - j;
                }
                j = prefixes[j];
            }
        }
        return s.length();
    }

    // KMP algorithm pre-processing step to generate prefix index table
    private static int[] prefix(String p) {
        int[] prefixes = new int[p.length() + 1];
        prefixes[0] = -1;
        int i = 0, j = -1;
        while (i < p.length()) {
            while (j >= 0 && p.charAt(i) != p.charAt(j)) {
                j = prefixes[j];
            }
            i++;
            j++;
            prefixes[i] = j;
        }
        return prefixes;
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

