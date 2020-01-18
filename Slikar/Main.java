import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int r = fio.nextInt();
        int c = fio.nextInt();
        char[][] grid = new char[r][c];
        Queue<Vertex> bfsQueue = new LinkedList<>();
        int startingRow = 0;
        int startingColumn = 0;
        for (int i = 0; i < r; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < c; j++) {
                char character = row.charAt(j);
                grid[i][j] = character;
                if (character == 'S') {
                    startingRow = i;
                    startingColumn = j;
                } else if (character == '*') {
                    // All flooded squares go into the queue first
                    // Cannot move to a square if water spreads to it on the same turn
                    bfsQueue.offer(new Vertex(i, j, true, 0));
                }
            }
        }
        bfsQueue.offer(new Vertex(startingRow, startingColumn, false, 0));
        int numberOfMoves = bfs(grid, bfsQueue);
        if (numberOfMoves == -1) {
            fio.println("KAKTUS");
        } else {
            fio.println(numberOfMoves);
        }
        fio.close();
    }

    private static int bfs(char[][] grid, Queue<Vertex> bfsQueue) {
        while (!bfsQueue.isEmpty()) {
            Vertex vertex = bfsQueue.poll();
            int row = vertex.row;
            int column = vertex.column;
            boolean isFlooded = vertex.isFlooded;
            int numberOfMoves = vertex.numberOfMoves;
            int numberOfRows = grid.length;
            int numberOfColumns = grid[0].length;
            int topRow = row - 1;
            int bottomRow = row + 1;
            int leftColumn = column - 1;
            int rightColumn = column + 1;
            if (isFlooded) {
                // Change adjacent squares to be flooded
                if (topRow >= 0 && (grid[topRow][column] == '.'
                            || grid[topRow][column] == 'S')) {
                    grid[topRow][column] = '*';
                    bfsQueue.offer(new Vertex(topRow, column, true,
                                numberOfMoves + 1));
                }
                if (bottomRow < numberOfRows && (grid[bottomRow][column] == '.'
                            || grid[bottomRow][column] == 'S')) {
                    grid[bottomRow][column] = '*';
                    bfsQueue.offer(new Vertex(bottomRow, column, true,
                                numberOfMoves + 1));
                }
                if (leftColumn >= 0 && (grid[row][leftColumn] == '.'
                            || grid[row][leftColumn] == 'S')) {
                    grid[row][leftColumn] = '*';
                    bfsQueue.offer(new Vertex(row, leftColumn, true,
                                numberOfMoves + 1));
                }
                if (rightColumn < numberOfColumns && (grid[row][rightColumn] == '.'
                            || grid[row][rightColumn] == 'S')) {
                    grid[row][rightColumn] = '*';
                    bfsQueue.offer(new Vertex(row, rightColumn, true,
                                numberOfMoves + 1));
                }
            } else {
                // Try to traverse adjacent squares if they are not flooded
                if (topRow >= 0) {
                    if (grid[topRow][column] == '.') {
                        grid[topRow][column] = 'S';
                        bfsQueue.offer(new Vertex(topRow, column, false,
                                    numberOfMoves + 1));
                    } else if (grid[topRow][column] == 'D') {
                        // Exit reached
                        return vertex.numberOfMoves + 1;
                    }
                }
                if (bottomRow < numberOfRows) {
                    if (grid[bottomRow][column] == '.') {
                        grid[bottomRow][column] = 'S';
                        bfsQueue.offer(new Vertex(bottomRow, column, false,
                                    numberOfMoves + 1));
                    } else if (grid[bottomRow][column] == 'D') {
                        return vertex.numberOfMoves + 1;
                    }
                }
                if (leftColumn >= 0) {
                    if (grid[row][leftColumn] == '.') {
                        grid[row][leftColumn] = 'S';
                        bfsQueue.offer(new Vertex(row, leftColumn, false,
                                    numberOfMoves + 1));
                    } else if (grid[row][leftColumn] == 'D') {
                        return vertex.numberOfMoves + 1;
                    }
                }
                if (rightColumn < numberOfColumns) {
                    if (grid[row][rightColumn] == '.') {
                        grid[row][rightColumn] = 'S';
                        bfsQueue.offer(new Vertex(row, rightColumn, false,
                                    numberOfMoves + 1));
                    } else if (grid[row][rightColumn] == 'D') {
                        return vertex.numberOfMoves + 1;
                    }
                }
            }
        }
        // Impossible to escape
        return -1;
    }

}

class Vertex {

    int row;
    int column;
    boolean isFlooded;
    int numberOfMoves;

    Vertex(int row, int column, boolean isFlooded, int numberOfMoves) {
        this.row = row;
        this.column = column;
        this.isFlooded = isFlooded;
        this.numberOfMoves = numberOfMoves;
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

