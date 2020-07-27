import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int[][] MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] grid;
    private static Queue<Triple> bfsQueue = new LinkedList<>();
    private static boolean[][] visited;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = fio.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j) - '0';

                // Add commercial zones to the queue
                if (grid[i][j] == 3) {
                    bfsQueue.add(new Triple(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // BFS
        int max = 0;
        while (!bfsQueue.isEmpty()) {
            Triple triple = bfsQueue.poll();

            // Residential zones are the endpoints
            if (grid[triple.row][triple.column] == 1) {
                max = Math.max(max, triple.distance);
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = triple.row + MOVES[i][0];
                int nextColumn = triple.column + MOVES[i][1];

                if (nextRow >= 0 && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid.length
                        && !visited[nextRow][nextColumn]) {
                    visited[nextRow][nextColumn] = true;
                    bfsQueue.add(new Triple(nextRow, nextColumn, triple.distance + 1));
                }
            }

        }

        fio.println(max);
        fio.close();
    }
}

class Triple {
    int row;
    int column;
    int distance;

    Triple(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
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

