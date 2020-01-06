import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        boolean[] rows = new boolean[n];
        boolean[] columns = new boolean[n];
        boolean[] diagonals = new boolean[2 * (n - 1)];
        boolean[] antiDiagonals = new boolean[2 * (n - 1)];
        boolean isSolution = true;
        for (int i = 0; i < n && isSolution; i++) {
            int column = fio.nextInt();
            int row = fio.nextInt();
            int diagonal = n - 1 - row + column;
            int antiDiagonal = row + column;
            // Mark the row, column, diagonal and anti-diagonal which the queen can attack
            // If a row, column, diagonal or anti-diagonal has already been marked,
            // then the solution is invalid because another queen can attack the current queen's position
            if (rows[row]) {
                isSolution = false;
            } else {
                rows[row] = true;
            }
            if (columns[column]) {
                isSolution = false;
            } else {
                columns[column] = true;
            }
            if (diagonals[diagonal]) {
                isSolution = false;
            } else {
                diagonals[diagonal] = true;
            }
            if (antiDiagonals[antiDiagonal]) {
                isSolution = false;
            } else {
                antiDiagonals[antiDiagonal] = true;
            }
        }
        if (isSolution) {
            fio.println("CORRECT");
        } else {
            fio.println("INCORRECT");
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

