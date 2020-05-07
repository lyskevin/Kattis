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
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        int[] statistics = new int[5];
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c - 1; j++) {
                int count = 0;
                boolean hasBuilding = false;
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        if (grid[i + k][j + l] == 'X') {
                            count++;
                        } else if (grid[i + k][j + l] == '#') {
                            hasBuilding = true;
                        }
                    }
                }
                if (!hasBuilding) {
                    statistics[count]++;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            fio.println(statistics[i]);
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

