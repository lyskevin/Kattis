import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static final int[][] MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int r = fio.nextInt();
            int c = fio.nextInt();
            int n = fio.nextInt();
            char[][] grid = new char[r][c];
            char[][] tempGrid = new char[r][c];
            for (int j = 0; j < r; j++) {
                String row = fio.nextLine();
                for (int k = 0; k < c; k++) {
                    grid[j][k] = row.charAt(k);
                    tempGrid[j][k] = row.charAt(k);
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < r; k++) {
                    for (int l = 0; l < c; l++) {
                        char current = grid[k][l];
                        for (int m = 0; m < 4; m++) {
                            int nextRow = k + MOVES[m][0];
                            int nextColumn = l + MOVES[m][1];
                            if (nextRow >= 0 && nextRow < r && nextColumn >= 0 && nextColumn < c) {
                                char other = grid[nextRow][nextColumn];
                                // Occupy land outwards
                                if (current == 'S' && other == 'P'
                                        || current == 'P' && other == 'R'
                                        || current == 'R' && other == 'S') {
                                    tempGrid[nextRow][nextColumn] = current;
                                } else if (current == 'P' && other == 'S'
                                        || current == 'R' && other == 'P'
                                        || current == 'S' && other == 'R') { // Current land is occupied
                                    tempGrid[k][l] = other;
                                }
                            }
                        }
                    }
                }
                for (int k = 0; k < r; k++) {
                    for (int l = 0; l < c; l++) {
                        grid[k][l] = tempGrid[k][l];
                    }
                }
            }
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    fio.print(grid[j][k]);
                }
                fio.println();
            }
            if (i < t - 1) {
                fio.println();
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

