import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int numberOfVisitedVertices;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int h = fio.nextInt();
        int w = fio.nextInt();
        while (!(h == 0 && w == 0)) {
            Vertex[][] grid = new Vertex[h][w];
            int numberOfEdges = 0;
            int startingRow = -1;
            int startingColumn = -1;
            int endingRow = -1;
            int endingColumn = -1;
            for (int i = 0; i < h; i++) {
                String row = fio.nextLine();
                for (int j = 0; j < w; j++) {
                    char c = row.charAt(j);
                    // Count edges to check if graph is a tree
                    if (i < h - 1 && j < w - 1) {
                        if ((c >= '2' && c <= '5') || (c >= 'A' && c <= 'D')) {
                            numberOfEdges += 1;
                        } else if (c == '0' || c == '1' || c == '8' || c == '9') {
                            numberOfEdges += 2;
                        }
                    } else if (i == h - 1 && j < w - 1) {
                        if ((c >= '0' && c <= '3') || c == '8' || c == '9' || c == 'A' || c == 'B') {
                            numberOfEdges += 1;
                        }
                    } else if (i < h - 1 && j == w - 1) {
                        if (c == '0' || c == '1' || c == '4' || c == '5' || c == '8' || c == '9' || c == 'C' || c == 'D') {
                            numberOfEdges += 1;
                        }
                    }
                    Vertex v = getVertex(c);
                    grid[i][j] = v;
                    // Get starting and ending positions to check if there is a path between them
                    if ((i == 0 && v.hasTopEdge) || (i == h - 1 && v.hasBottomEdge)
                            || (j == 0 && v.hasLeftEdge) || (j == w - 1 && v.hasRightEdge)) {
                        if (startingRow == -1 && startingColumn == -1) {
                            startingRow = i;
                            startingColumn = j;
                        } else {
                            endingRow = i;
                            endingColumn = j;
                        }
                    }
                }
            }
            boolean[][] visited = new boolean[h][w];
            numberOfVisitedVertices = 0;
            dfs(startingRow, startingColumn, visited, grid);
            // Ending position not visited after performing DFS from starting position ==> No solution
            if (!visited[endingRow][endingColumn]) {
                fio.println("NO SOLUTION");
            } else if (numberOfVisitedVertices < h * w) {
                // Number of visited vertices < total number of vertices ==> Unreachable cell
                fio.println("UNREACHABLE CELL");
            } else if (numberOfEdges > h * w - 1) {
                // Number of edges > total number of vertices - 1 (i.e. graph is not a tree) ==> Multiple paths
                fio.println("MULTIPLE PATHS");
            } else {
                // Maze is ok if all of the above are false
                fio.println("MAZE OK");
            }
            h = fio.nextInt();
            w = fio.nextInt();
        }
        fio.close();
    }

    private static void dfs(int row, int column, boolean[][] visited, Vertex[][] grid) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return;
        }
        if (!visited[row][column]) {
            visited[row][column] = true;
            numberOfVisitedVertices++;
            Vertex v = grid[row][column];
            if (v.hasLeftEdge) {
                dfs(row, column - 1, visited, grid);
            }
            if (v.hasRightEdge) {
                dfs(row, column + 1, visited, grid);
            }
            if (v.hasTopEdge) {
                dfs(row - 1, column, visited, grid);
            }
            if (v.hasBottomEdge) {
                dfs(row + 1, column, visited, grid);
            }
        }
    }

    private static Vertex getVertex(char c) {
        Vertex v = null;
        switch (c) {
            case '0':
                v = new Vertex(true, true, true, true);
                break;
            case '1':
                v = new Vertex(false, true, true, true);
                break;
            case '2':
                v = new Vertex(true, true, true, false);
                break;
            case '3':
                v = new Vertex(false, true, true, false);
                break;
            case '4':
                v = new Vertex(true, false, true, true);
                break;
            case '5':
                v = new Vertex(false, false, true, true);
                break;
            case '6':
                v = new Vertex(true, false, true, false);
                break;
            case '7':
                v = new Vertex(false, false, true, false);
                break;
            case '8':
                v = new Vertex(true, true, false, true);
                break;
            case '9':
                v = new Vertex(false, true, false, true);
                break;
            case 'A':
                v = new Vertex(true, true, false, false);
                break;
            case 'B':
                v = new Vertex(false, true, false, false);
                break;
            case 'C':
                v = new Vertex(true, false, false, true);
                break;
            case 'D':
                v = new Vertex(false, false, false, true);
                break;
            case 'E':
                v = new Vertex(true, false, false, false);
                break;
            case 'F':
                v = new Vertex(false, false, false, false);
                break;
        }
        return v;
    }

}

class Vertex {

    boolean hasLeftEdge;
    boolean hasRightEdge;
    boolean hasTopEdge;
    boolean hasBottomEdge;

    Vertex(boolean hasLeftEdge, boolean hasRightEdge, boolean hasTopEdge, boolean hasBottomEdge) {
        this.hasLeftEdge = hasLeftEdge;
        this.hasRightEdge = hasRightEdge;
        this.hasTopEdge = hasTopEdge;
        this.hasBottomEdge = hasBottomEdge;
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

