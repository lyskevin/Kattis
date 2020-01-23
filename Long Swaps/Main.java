import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String s = fio.next();
        int n = s.length();
        int k = fio.nextInt();
        // k <= n / 2 ==> Possible to swap any pair of adjacent characters, which is sufficient to sort the entire string
        if (k <= n / 2) {
            fio.println("Yes");
        } else {
            char[] chars = new char[n];
            for (int i = 0; i < n; i++) {
                chars[i] = s.charAt(i);
            }
            // Sort characters and check if characters which cannot move remain in the same position
            Arrays.sort(chars);
            boolean canSort = true;
            for (int i = n - k; i <= k - 1 && canSort; i++) {
                if (chars[i] != s.charAt(i)) {
                    canSort = false;
                }
            }
            if (canSort) {
                fio.println("Yes");
            } else {
                fio.println("No");
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

