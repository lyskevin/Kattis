import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static HashMap<String, Integer> dictionary = new HashMap<>();
    private static long[] cache;
    private static int N;
    private static String W;
    private static final long MOD = 1000000007l;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        N = fio.nextInt();
        W = fio.next();

        for (int i = 0; i < N; i++) {
            dictionary.put(fio.next(), fio.nextInt());
        }

        cache = new long[W.length() + 1];
        cache[W.length()] = 1;

        solve(0);

        if (cache[0] < 0) {
            fio.println(0);
        } else {
            fio.println(cache[0]);
        }

        fio.close();
    }

    private static void solve(int index) {

        // Stop here
        if (index >= W.length()) {
            return;
        }

        // Already memoized
        if (cache[index] != 0) {
            return;
        }

        // General case
        long result = -1l;
        boolean hasResult = false;
        for (String word : dictionary.keySet()) {
            if (W.length() - index >= word.length() && W.substring(index, index + word.length()).equals(word)) {
                solve(index + word.length());
                if (cache[index + word.length()] > 0) {
                    if (hasResult) {
                        result = ((((dictionary.get(word) % MOD) * (cache[index + word.length()] % MOD)) % MOD) + (result % MOD)) % MOD;
                    } else {
                        hasResult = true;
                        result = ((dictionary.get(word) % MOD) * (cache[index + word.length()] % MOD)) % MOD;
                    }
                }
            }
        }

        cache[index] = result;
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

