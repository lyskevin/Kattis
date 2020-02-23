import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                String pattern = fio.nextLine();
                String text = fio.nextLine();
                ArrayList<Integer> indices = kmp(pattern, text);
                for (int i = 0; i < indices.size(); i++) {
                    if (i > 0) {
                        fio.print(" ");
                    }
                    fio.print(indices.get(i));
                }
                fio.println();
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }

    // KMP string matching algorithm
    private static ArrayList<Integer> kmp(String p, String s) {
        int[] prefixes = prefix(p);
        ArrayList<Integer> indices = new ArrayList<>();
        int i = 0, j = 0;
        while (i < s.length()) {
            // Find next largest border at prefixes[j]
            while (j >= 0 && s.charAt(i) != p.charAt(j)) {
                j = prefixes[j];
            }
            i++;
            j++;
            if (j == p.length()) {
                indices.add(i - j);
                j = prefixes[j];
            }
        }
        return indices;
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
        // Modified to throw NullPointerException when EOF is reached
        if (str == null) {
            throw new NullPointerException();
        } 
        return str; 
    } 
}

