import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int[][] MOVES = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int r = fio.nextInt();
        int c = fio.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = fio.nextInt();
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Connect an imaginary source vertex to all vertices in the leftmost column
        for (int i = 0; i < r; i++) {
            pq.offer(new Edge(i, 0, grid[i][0]));
        }

        boolean[][] visited = new boolean[r][c];

        // Modified Prims' to find minimax path
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            if (visited[edge.row][edge.column]) {
                continue;
            }

            visited[edge.row][edge.column] = true;
            
            if (edge.column == c - 1) {
                fio.println(edge.weight);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = edge.row + MOVES[i][0];
                int nextColumn = edge.column + MOVES[i][1];
                if (nextRow >= 0 && nextRow < r && nextColumn >= 0 && nextColumn < c
                        && !visited[nextRow][nextColumn]) {
                    pq.offer(new Edge(nextRow, nextColumn, Math.max(edge.weight, grid[nextRow][nextColumn])));
                }
            }
        }

        fio.close();
    }
}

class Edge implements Comparable<Edge> {
    int row;
    int column;
    int weight;

    Edge(int row, int column, int weight) {
        this.row = row;
        this.column = column;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
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

