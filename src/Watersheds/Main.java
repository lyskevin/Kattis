import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int[][] MOVES = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private static int[][] grid;
    private static char[][] output;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int T = fio.nextInt();
        for (int i = 0; i < T; i++) {
            int H = fio.nextInt();
            int W = fio.nextInt();
            grid = new int[H][W];
            
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    grid[j][k] = fio.nextInt();
                }
            }

            output = new char[H][W];
            char basin = 'a';
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    if (output[j][k] == 0) {
                        solve(j, k, basin);
                        basin++;
                    }
                }
            }

            fio.println("Case #" + (i + 1) + ": ");
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    if (k > 0) {
                        fio.print(" ");
                    }
                    fio.print(output[j][k]);
                }
                fio.println();
            }
        }

        fio.close();
    }

    private static void solve(int row, int column, char basin) {
        output[row][column] = basin;
        for (int i = 0; i < 4; i++) {

            // Water flows from the adjacent cell to this cell
            int nextRow = row + (-1 * MOVES[i][0]);
            int nextColumn = column + (-1 * MOVES[i][1]);
            if ((nextRow >= 0 && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid[0].length
                    && output[nextRow][nextColumn] == 0)
                    && flowDirection(nextRow, nextColumn) == i) {
                solve(nextRow, nextColumn, basin);
            }

            // Water flows from this cell to the adjacent cell
            nextRow = row + MOVES[i][0];
            nextColumn = column + MOVES[i][1];
            if ((nextRow >= 0 && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid[0].length
                    && output[nextRow][nextColumn] == 0)
                    && flowDirection(row, column) == i) {
                solve(nextRow, nextColumn, basin);
            }
        }
    }

    // -1: Sink, 0: North, 1: West, 2: East, 3: South
    private static int flowDirection(int row, int column) {
        int direction = -1;
        int minimum = grid[row][column];
        for (int i = 0; i < 4; i++) {
            int nextRow = row + MOVES[i][0];
            int nextColumn = column + MOVES[i][1];
            if (nextRow >= 0 && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid[0].length) {
                if (grid[nextRow][nextColumn] < minimum) {
                    minimum = grid[nextRow][nextColumn];
                    direction = i;
                }
            }
        }
        return direction;
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

