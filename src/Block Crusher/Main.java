import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final int[][] MOVES = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int h = fio.nextInt();
        int w = fio.nextInt();
        while (h != 0 || w != 0) {
            char[][] grid = new char[h][w];
            int[][] distances = new int[h][w];
            for (int i = 0; i < h; i++) {
                String input = fio.nextLine();
                for (int j = 0; j < w; j++) {
                    grid[i][j] = input.charAt(j);
                    distances[i][j] = 1000000000;
                }
            }
            Node[][] predecessors = new Node[h][w];
            PriorityQueue<Node> nodePQ = new PriorityQueue<>();
            for (int i = 0; i < w; i++) {
                distances[0][i] = grid[0][i];
                nodePQ.offer(new Node(0, i, grid[0][i]));
            }
            while (!nodePQ.isEmpty()) {
                Node node = nodePQ.poll();
                int row = node.row;
                int column = node.column;
                for (int i = 0; i < 8; i++) {
                    int nextRow = row + MOVES[i][0];
                    int nextColumn = column + MOVES[i][1];
                    if (nextRow >= 0 && nextRow < h && nextColumn >= 0 && nextColumn < w
                            && distances[nextRow][nextColumn] > distances[row][column] + (grid[nextRow][nextColumn] - '0')) {
                        distances[nextRow][nextColumn] = distances[row][column] + (grid[nextRow][nextColumn] - '0');
                        nodePQ.offer(new Node(nextRow, nextColumn, distances[nextRow][nextColumn]));
                        predecessors[nextRow][nextColumn] = node;
                    }
                }
            }
            int minimumDistance = 1000000000;
            for (int i = 0; i < w; i++) {
                minimumDistance = Math.min(minimumDistance, distances[h - 1][i]);
            }
            int row = h - 1;
            int column = 0;
            for (int i = 0; i < w; i++) {
                if (distances[h - 1][i] == minimumDistance) {
                    column = i;
                }
            }
            while (predecessors[row][column] != null) {
                grid[row][column] = ' ';
                int initialRow = row;
                row = predecessors[row][column].row;
                column = predecessors[intitialRow][column].column;
            }
            grid[row][column] = ' ';
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    fio.print(grid[i][j]);
                }
                fio.println();
            }
            h = fio.nextInt();
            w = fio.nextInt();
            if (h != 0 || w != 0) {
                fio.println();
            }
        }
        fio.close();
    }
}

class Node implements Comparable<Node> {
    
    int row;
    int column;
    int distance;

    Node(int row, int column, int distance) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
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

