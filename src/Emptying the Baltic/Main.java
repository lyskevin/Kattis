import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final int[][] MOVES = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int h = fio.nextInt();
        int w = fio.nextInt();
        // Initialise grid
        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = fio.nextInt();
            }
        }
        int drainRow = fio.nextInt() - 1;
        int drainColumn = fio.nextInt() - 1;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(drainRow, drainColumn, grid[drainRow][drainColumn]));
        boolean[][] visited = new boolean[h][w];
        visited[drainRow][drainColumn] = true;
        long totalAmount = -1 * (grid[drainRow][drainColumn]);
        // Dijkstra's algorithm using drain location as the source
        while (!pq.isEmpty()) {
            Vertex u = pq.poll();
            for (int i = 0; i < 8; i++) {
                int nextRow = u.row + MOVES[i][0];
                int nextColumn = u.column + MOVES[i][1];
                if (nextRow >= 0 && nextRow < h && nextColumn >= 0 && nextColumn < w && !visited[nextRow][nextColumn]) {
                    if (grid[nextRow][nextColumn] < 0) { // Water found here
                        visited[nextRow][nextColumn] = true;
                        // Amount that can flow from subsequent cells = max of current and neighbouring cell
                        int amount = Math.max(u.amount, grid[nextRow][nextColumn]);
                        totalAmount += -1 * amount;
                        pq.offer(new Vertex(nextRow, nextColumn, amount));
                    }
                }
            }
        }
        fio.println(totalAmount);
        fio.close();
    }
}

class Vertex implements Comparable<Vertex> {

    int row;
    int column;
    int amount;

    Vertex(int row, int column, int amount) {
        this.row = row;
        this.column = column;
        this.amount = amount;
    }

    @Override
    public int compareTo(Vertex other) {
        return this.amount - other.amount;
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

