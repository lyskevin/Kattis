import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final char[][] GRID = {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'},
        {'I', 'J', 'K', 'L'}, {'M', 'N', 'O', '.'}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int scatter = 0;
        for (int i = 0; i < 4; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < 4; j++) {
                char c = row.charAt(j);
                if (c != '.') {
                    for (int k = 0; k < 4; k++) {
                        for (int m = 0; m < 4; m++) {
                            if (GRID[k][m] == c) {
                                scatter += Math.abs(k - i) + Math.abs(m - j);
                            }
                        }
                    }
                }
            }
        }
        fio.println(scatter);
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

