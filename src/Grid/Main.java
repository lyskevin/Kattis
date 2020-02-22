import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static final int[][] MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }
        Queue<Coordinates> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Coordinates(0, 0, 0));
        int[][] distances = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distances[i][j] = 1000000000;
            }
        }
        distances[0][0] = 0;
        boolean[][] visited = new boolean[n][m];
        while (!bfsQueue.isEmpty()) {
            Coordinates coordinates = bfsQueue.poll();
            int row = coordinates.row;
            int column = coordinates.column;
            int steps = coordinates.steps;
            int nextDistance = grid[row][column];
            for (int i = 0; i < 4; i++) {
                int nextRow = row + nextDistance * MOVES[i][0];
                int nextColumn = column + nextDistance * MOVES[i][1];
                if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m && !visited[nextRow][nextColumn]) {
                    visited[nextRow][nextColumn] = true;
                    distances[nextRow][nextColumn] = steps + 1;
                    bfsQueue.offer(new Coordinates(nextRow, nextColumn, steps + 1));
                }
            }
        }
        if (visited[n - 1][m - 1]) {
            fio.println(distances[n - 1][m - 1]);
        } else {
            fio.println(-1);
        }
        fio.close();
    }
}

class Coordinates {

    int row;
    int column;
    int steps;

    Coordinates(int row, int column, int steps) {
        this.row = row;
        this.column = column;
        this.steps = steps;
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

