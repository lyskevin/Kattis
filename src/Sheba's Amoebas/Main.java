import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int[][] MOVES = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    private static char[][] grid;
    private static boolean[][] visited;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int m = fio.nextInt();
        int n = fio.nextInt();
        grid = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '#') {
                    count++;
                    dfs(i, j);
                }
            }
        }

        fio.println(count);
        fio.close();
    }

    private static void dfs(int row, int column) {
        visited[row][column] = true;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + MOVES[i][0];
            int nextColumn = column + MOVES[i][1];
            if (nextRow >= 0 && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid[row].length
                    && !visited[nextRow][nextColumn] && grid[nextRow][nextColumn] == '#') {
                dfs(nextRow, nextColumn);
            }
        }
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

