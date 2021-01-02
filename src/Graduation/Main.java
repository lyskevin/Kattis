import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        int M = fio.nextInt();
        int K = fio.nextInt();

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        boolean[] used = new boolean[K];
        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean hasColumnColour = false;

            // First check whether this column has already been assigned a colour
            // I.e. This column contains >= 1 student from a class which already has a colour
            for (int j = 0; j < N; j++) {
                char c = grid[j][i];
                if (used[c - 'A']) {
                    hasColumnColour = true;
                }
            }

            // Assign this column a colour if it does not already have one
            for (int j = 0; j < N; j++) {
                char c = grid[j][i];
                if (!used[c - 'A']) {
                    used[c - 'A'] = true;
                    if (!hasColumnColour) {
                        hasColumnColour = true;
                        count++;
                    }
                } else {
                    hasColumnColour = true;
                }
            }
        }

        fio.println(count);

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

