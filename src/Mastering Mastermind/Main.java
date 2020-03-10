import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        String code = fio.next();
        String guess = fio.next();
        int[] letters = new int[26];
        for (int i = 0; i < n; i++) {
            letters[code.charAt(i) - 'A']++;
        }
        // Count s
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (code.charAt(i) == guess.charAt(i)) {
                s++;
                letters[code.charAt(i) - 'A']--;
            }
        }
        // Count r
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (letters[guess.charAt(i) - 'A'] > 0 && code.charAt(i) != guess.charAt(i)) {
                letters[guess.charAt(i) - 'A']--;
                r++;
            }
        }
        fio.println(s + " " + r);
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

