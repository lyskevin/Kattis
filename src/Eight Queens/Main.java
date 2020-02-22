import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        char[][] grid = new char[8][8];
        int count = 0;
        for (int i = 0; i < 8; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < 8; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == '*') {
                    count++;
                }
            }
        }
        boolean isValid = true;
        for (int i = 0; i < 8 && isValid; i++) {
            for (int j = 0; j < 8 && isValid; j++) {
                if (grid[i][j] == '*') {
                    // Vertical check
                    for (int k = 0; k < 8; k++) {
                        if (k != i && grid[k][j] == '*') {
                            isValid = false;
                        }
                    }
                    // Horizontal check
                    for (int k = 0; k < 8; k++) {
                        if (k != j && grid[i][k] == '*') {
                            isValid = false;
                        }
                    }
                    // Diagonal check
                    int nextRow = i - 1;
                    int nextColumn = j - 1;
                    while (nextRow >= 0 && nextColumn >= 0) {
                        if (grid[nextRow][nextColumn] == '*') {
                            isValid = false;
                        }
                        nextRow--;
                        nextColumn--;
                    }
                    nextRow = i + 1;
                    nextColumn = j + 1;
                    while (nextRow < 8 && nextColumn < 8) {
                        if (grid[nextRow][nextColumn] == '*') {
                            isValid = false;
                        }
                        nextRow++;
                        nextColumn++;
                    }
                    // Anti-diagonal check
                    nextRow = i + 1;
                    nextColumn = j - 1;
                    while (nextRow < 8  && nextColumn >= 0) {
                        if (grid[nextRow][nextColumn] == '*') {
                            isValid = false;
                        }
                        nextRow++;
                        nextColumn--;
                    }
                    nextRow = i - 1;
                    nextColumn = j + 1;
                    while (nextRow >= 0 && nextColumn < 8) {
                        if (grid[nextRow][nextColumn] == '*') {
                            isValid = false;
                        }
                        nextRow--;
                        nextColumn++;
                    }
                }
            }
        }
        // Must have 8 queens for the solution to be valid
        if (isValid && count == 8) {
            fio.println("valid");
        } else {
            fio.println("invalid");
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

