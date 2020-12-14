import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int[] bitmasks;
    private static int count;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        bitmasks = new int[N];
        for (int i = 0; i < N; i++) {
            String word = fio.nextLine();
            int bitmask = 0;
            for (int j = 0; j < word.length(); j++) {
                int position = word.charAt(j) - 'a';
                bitmask |= (1 << position);
            }
            bitmasks[i] = bitmask;
        }

        solve(0, 0);
        fio.println(count);
        fio.close();
    }

    private static void solve(int index, int bitmask) {
        // Reached the end
        // 2^26 - 1 = 67108863
        if (index == bitmasks.length) {
            if (bitmask == 67108863) {
                count++;
            }
            return;
        }

        // Use current word
        solve(index + 1, bitmask | bitmasks[index]);
        
        // Do not use current word
        solve(index + 1, bitmask);
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

