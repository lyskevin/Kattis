import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int n;
    private static char[][] grid;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        n = fio.nextInt();
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        boolean isValid = true;
        for (int i = 0; i < n && isValid; i++) {
            if (!checkRow(i) || !checkColumn(i)) {
                isValid = false;
            }
        }

        if (isValid) {
            fio.println(1);
        } else {
            fio.println(0);
        }

        fio.close();
    }

    private static boolean checkRow(int row) {
        int whiteCount = 0;

        for (int i = 0; i < n; i++) {
            if (grid[row][i] == 'W') {
                whiteCount++;
            }
        }
        
        if (whiteCount != n / 2) {
            return false;
        }

        for (int i = 0; i < n - 2; i++) {
            if (grid[row][i] == grid[row][i + 1] && grid[row][i] == grid[row][i + 2]) {
                return false;
            }
        }

        return true;
    }
    
    private static boolean checkColumn(int column) {
        int whiteCount = 0;

        for (int i = 0; i < n; i++) {
            if (grid[i][column] == 'W') {
                whiteCount++;
            }
        }
        
        if (whiteCount != n / 2) {
            return false;
        }

        for (int i = 0; i < n - 2; i++) {
            if (grid[i][column] == grid[i + 1][column] && grid[i][column] == grid[i + 2][column]) {
                return false;
            }
        }

        return true;
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

