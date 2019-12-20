import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        HashMap<String, Integer> prefixFrequencies = new HashMap<>();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            String word = fio.nextLine();
            if (prefixFrequencies.containsKey(word)) {
                fio.println(prefixFrequencies.get(word));
            } else {
                fio.println(0);
            }
            for (int j = 0; j < word.length(); j++) {
                String substring = word.substring(0, j + 1);
                if (!prefixFrequencies.containsKey(substring)) {
                    prefixFrequencies.put(substring, 1);
                } else {
                    prefixFrequencies.put(substring, prefixFrequencies.get(substring) + 1);
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

