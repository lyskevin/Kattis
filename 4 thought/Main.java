import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> mappings = new HashMap<>();
        mappings.put(4 + 4 + 4 + 4, "4 + 4 + 4 + 4 = " + (4 + 4 + 4 + 4));
        mappings.put(4 + 4 + 4 - 4, "4 + 4 + 4 - 4 = " + (4 + 4 + 4 - 4));
        mappings.put(4 + 4 + 4 * 4, "4 + 4 + 4 * 4 = " + (4 + 4 + 4 * 4));
        mappings.put(4 + 4 + 4 / 4, "4 + 4 + 4 / 4 = " + (4 + 4 + 4 / 4));
        mappings.put(4 + 4 - 4 + 4, "4 + 4 - 4 + 4 = " + (4 + 4 - 4 + 4));
        mappings.put(4 + 4 - 4 - 4, "4 + 4 - 4 - 4 = " + (4 + 4 - 4 - 4));
        mappings.put(4 + 4 - 4 * 4, "4 + 4 - 4 * 4 = " + (4 + 4 - 4 * 4));
        mappings.put(4 + 4 - 4 / 4, "4 + 4 - 4 / 4 = " + (4 + 4 - 4 / 4));
        mappings.put(4 + 4 * 4 + 4, "4 + 4 * 4 + 4 = " + (4 + 4 * 4 + 4));
        mappings.put(4 + 4 * 4 - 4, "4 + 4 * 4 - 4 = " + (4 + 4 * 4 - 4));
        mappings.put(4 + 4 * 4 * 4, "4 + 4 * 4 * 4 = " + (4 + 4 * 4 * 4));
        mappings.put(4 + 4 * 4 / 4, "4 + 4 * 4 / 4 = " + (4 + 4 * 4 / 4));
        mappings.put(4 + 4 / 4 + 4, "4 + 4 / 4 + 4 = " + (4 + 4 / 4 + 4));
        mappings.put(4 + 4 / 4 - 4, "4 + 4 / 4 - 4 = " + (4 + 4 / 4 - 4));
        mappings.put(4 + 4 / 4 * 4, "4 + 4 / 4 * 4 = " + (4 + 4 / 4 * 4));
        mappings.put(4 + 4 / 4 / 4, "4 + 4 / 4 / 4 = " + (4 + 4 / 4 / 4));
        mappings.put(4 - 4 + 4 + 4, "4 - 4 + 4 + 4 = " + (4 - 4 + 4 + 4));
        mappings.put(4 - 4 + 4 - 4, "4 - 4 + 4 - 4 = " + (4 - 4 + 4 - 4));
        mappings.put(4 - 4 + 4 * 4, "4 - 4 + 4 * 4 = " + (4 - 4 + 4 * 4));
        mappings.put(4 - 4 + 4 / 4, "4 - 4 + 4 / 4 = " + (4 - 4 + 4 / 4));
        mappings.put(4 - 4 - 4 + 4, "4 - 4 - 4 + 4 = " + (4 - 4 - 4 + 4));
        mappings.put(4 - 4 - 4 - 4, "4 - 4 - 4 - 4 = " + (4 - 4 - 4 - 4));
        mappings.put(4 - 4 - 4 * 4, "4 - 4 - 4 * 4 = " + (4 - 4 - 4 * 4));
        mappings.put(4 - 4 - 4 / 4, "4 - 4 - 4 / 4 = " + (4 - 4 - 4 / 4));
        mappings.put(4 - 4 * 4 + 4, "4 - 4 * 4 + 4 = " + (4 - 4 * 4 + 4));
        mappings.put(4 - 4 * 4 - 4, "4 - 4 * 4 - 4 = " + (4 - 4 * 4 - 4));
        mappings.put(4 - 4 * 4 * 4, "4 - 4 * 4 * 4 = " + (4 - 4 * 4 * 4));
        mappings.put(4 - 4 * 4 / 4, "4 - 4 * 4 / 4 = " + (4 - 4 * 4 / 4));
        mappings.put(4 - 4 / 4 + 4, "4 - 4 / 4 + 4 = " + (4 - 4 / 4 + 4));
        mappings.put(4 - 4 / 4 - 4, "4 - 4 / 4 - 4 = " + (4 - 4 / 4 - 4));
        mappings.put(4 - 4 / 4 * 4, "4 - 4 / 4 * 4 = " + (4 - 4 / 4 * 4));
        mappings.put(4 - 4 / 4 / 4, "4 - 4 / 4 / 4 = " + (4 - 4 / 4 / 4));
        mappings.put(4 * 4 + 4 + 4, "4 * 4 + 4 + 4 = " + (4 * 4 + 4 + 4));
        mappings.put(4 * 4 + 4 - 4, "4 * 4 + 4 - 4 = " + (4 * 4 + 4 - 4));
        mappings.put(4 * 4 + 4 * 4, "4 * 4 + 4 * 4 = " + (4 * 4 + 4 * 4));
        mappings.put(4 * 4 + 4 / 4, "4 * 4 + 4 / 4 = " + (4 * 4 + 4 / 4));
        mappings.put(4 * 4 - 4 + 4, "4 * 4 - 4 + 4 = " + (4 * 4 - 4 + 4));
        mappings.put(4 * 4 - 4 - 4, "4 * 4 - 4 - 4 = " + (4 * 4 - 4 - 4));
        mappings.put(4 * 4 - 4 * 4, "4 * 4 - 4 * 4 = " + (4 * 4 - 4 * 4));
        mappings.put(4 * 4 - 4 / 4, "4 * 4 - 4 / 4 = " + (4 * 4 - 4 / 4));
        mappings.put(4 * 4 * 4 + 4, "4 * 4 * 4 + 4 = " + (4 * 4 * 4 + 4));
        mappings.put(4 * 4 * 4 - 4, "4 * 4 * 4 - 4 = " + (4 * 4 * 4 - 4));
        mappings.put(4 * 4 * 4 * 4, "4 * 4 * 4 * 4 = " + (4 * 4 * 4 * 4));
        mappings.put(4 * 4 * 4 / 4, "4 * 4 * 4 / 4 = " + (4 * 4 * 4 / 4));
        mappings.put(4 * 4 / 4 + 4, "4 * 4 / 4 + 4 = " + (4 * 4 / 4 + 4));
        mappings.put(4 * 4 / 4 - 4, "4 * 4 / 4 - 4 = " + (4 * 4 / 4 - 4));
        mappings.put(4 * 4 / 4 * 4, "4 * 4 / 4 * 4 = " + (4 * 4 / 4 * 4));
        mappings.put(4 * 4 / 4 / 4, "4 * 4 / 4 / 4 = " + (4 * 4 / 4 / 4));
        mappings.put(4 / 4 + 4 + 4, "4 / 4 + 4 + 4 = " + (4 / 4 + 4 + 4));
        mappings.put(4 / 4 + 4 - 4, "4 / 4 + 4 - 4 = " + (4 / 4 + 4 - 4));
        mappings.put(4 / 4 + 4 * 4, "4 / 4 + 4 * 4 = " + (4 / 4 + 4 * 4));
        mappings.put(4 / 4 + 4 / 4, "4 / 4 + 4 / 4 = " + (4 / 4 + 4 / 4));
        mappings.put(4 / 4 - 4 + 4, "4 / 4 - 4 + 4 = " + (4 / 4 - 4 + 4));
        mappings.put(4 / 4 - 4 - 4, "4 / 4 - 4 - 4 = " + (4 / 4 - 4 - 4));
        mappings.put(4 / 4 - 4 * 4, "4 / 4 - 4 * 4 = " + (4 / 4 - 4 * 4));
        mappings.put(4 / 4 - 4 / 4, "4 / 4 - 4 / 4 = " + (4 / 4 - 4 / 4));
        mappings.put(4 / 4 * 4 + 4, "4 / 4 * 4 + 4 = " + (4 / 4 * 4 + 4));
        mappings.put(4 / 4 * 4 - 4, "4 / 4 * 4 - 4 = " + (4 / 4 * 4 - 4));
        mappings.put(4 / 4 * 4 * 4, "4 / 4 * 4 * 4 = " + (4 / 4 * 4 * 4));
        mappings.put(4 / 4 * 4 / 4, "4 / 4 * 4 / 4 = " + (4 / 4 * 4 / 4));
        mappings.put(4 / 4 / 4 + 4, "4 / 4 / 4 + 4 = " + (4 / 4 / 4 + 4));
        mappings.put(4 / 4 / 4 - 4, "4 / 4 / 4 - 4 = " + (4 / 4 / 4 - 4));
        mappings.put(4 / 4 / 4 * 4, "4 / 4 / 4 * 4 = " + (4 / 4 / 4 * 4));
        mappings.put(4 / 4 / 4 / 4, "4 / 4 / 4 / 4 = " + (4 / 4 / 4 / 4));
        FastIO fio = new FastIO();
        int m = fio.nextInt();
        for (int i = 0; i < m; i++) {
            int n = fio.nextInt();
            if (mappings.containsKey(n)) {
                fio.println(mappings.get(n));
            } else {
                fio.println("no solution");
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

