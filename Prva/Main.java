import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int r = fio.nextInt();
        int c = fio.nextInt();
        TreeSet<String> words = new TreeSet<>();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = fio.next();
            for (int j = 0; j < c; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        for (int i = 0; i < r; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '#') {
                    if (word.length() >= 2) {
                        words.add(word.toString());
                    }
                    word = new StringBuilder();
                } else {
                    word.append(grid[i][j]);
                }
            }
            if (word.length() >= 2) {
                words.add(word.toString());
            }
        }
        for (int i = 0; i < c; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < r; j++) {
                if (grid[j][i] == '#') {
                    if (word.length() >= 2) {
                        words.add(word.toString());
                    }
                    word = new StringBuilder();
                } else {
                    word.append(grid[j][i]);
                }
            }
            if (word.length() >= 2) {
                words.add(word.toString());
            }
        }
        fio.println(words.first());
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

