import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int numberOfColumns = fio.nextInt();
            int numberOfRows = fio.nextInt();
            char[][] grid = new char[numberOfRows][numberOfColumns];
            Queue<Vertex> bfsQueue = new LinkedList<>();
            int startingRow = 0;
            int startingColumn = 0;
            for (int j = 0; j < numberOfRows; j++) {
                String row = fio.nextLine();
                for (int k = 0; k < numberOfColumns; k++) {
                    char character = row.charAt(k);
                    grid[j][k] = character;
                    if (character == '@') {
                        startingRow = j;
                        startingColumn = k;
                    } else if (character == '*') {
                        // All squares with fire go into the queue first
                        // Cannot move to a square if fire spreads to it on the same turn
                        bfsQueue.offer(new Vertex(j, k, true, 0));
                    }
                }
            }
            bfsQueue.offer(new Vertex(startingRow, startingColumn, false, 0));
            int numberOfMoves = bfs(grid, bfsQueue);
            if (numberOfMoves == -1) {
                fio.println("IMPOSSIBLE");
            } else {
                fio.println(numberOfMoves);
            }
        }
        fio.close();
    }

    private static int bfs(char[][] grid, Queue<Vertex> bfsQueue) {
        while (!bfsQueue.isEmpty()) {
            Vertex vertex = bfsQueue.poll();
            int row = vertex.row;
            int column = vertex.column;
            boolean isFire = vertex.isFire;
            int numberOfMoves = vertex.numberOfMoves;
            int numberOfRows = grid.length;
            int numberOfColumns = grid[0].length;
            int topRow = row - 1;
            int bottomRow = row + 1;
            int leftColumn = column - 1;
            int rightColumn = column + 1;
            if (isFire) {
                // Change adjacent squares to be on fire
                if (topRow >= 0 && (grid[topRow][column] == '.'
                            || grid[topRow][column] == '@')) {
                    grid[topRow][column] = '*';
                    bfsQueue.offer(new Vertex(topRow, column, true,
                                numberOfMoves + 1));
                }
                if (bottomRow < numberOfRows && (grid[bottomRow][column] == '.'
                            || grid[bottomRow][column] == '@')) {
                    grid[bottomRow][column] = '*';
                    bfsQueue.offer(new Vertex(bottomRow, column, true,
                                numberOfMoves + 1));
                }
                if (leftColumn >= 0 && (grid[row][leftColumn] == '.'
                            || grid[row][leftColumn] == '@')) {
                    grid[row][leftColumn] = '*';
                    bfsQueue.offer(new Vertex(row, leftColumn, true,
                                numberOfMoves + 1));
                }
                if (rightColumn < numberOfColumns && (grid[row][rightColumn] == '.'
                            || grid[row][rightColumn] == '@')) {
                    grid[row][rightColumn] = '*';
                    bfsQueue.offer(new Vertex(row, rightColumn, true,
                                numberOfMoves + 1));
                }
            } else {
                // Exit reached
                if (row == 0 || column == 0 || row == numberOfRows - 1
                        || column == numberOfColumns - 1) {
                    return numberOfMoves + 1;
                }
                // Try to traverse adjacent squares if they are not on fire
                if (topRow >= 0 && grid[topRow][column] == '.') {
                    grid[topRow][column] = '@';
                    bfsQueue.offer(new Vertex(topRow, column, false,
                                numberOfMoves + 1));
                }
                if (bottomRow < numberOfRows && grid[bottomRow][column] == '.') {
                    grid[bottomRow][column] = '@';
                    bfsQueue.offer(new Vertex(bottomRow, column, false,
                                numberOfMoves + 1));
                }
                if (leftColumn >= 0 && grid[row][leftColumn] == '.') {
                    grid[row][leftColumn] = '@';
                    bfsQueue.offer(new Vertex(row, leftColumn, false,
                                numberOfMoves + 1));
                }
                if (rightColumn < numberOfColumns && grid[row][rightColumn] == '.') {
                    grid[row][rightColumn] = '@';
                    bfsQueue.offer(new Vertex(row, rightColumn, false,
                                numberOfMoves + 1));
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
    boolean isFire;
    int numberOfMoves;

    Vertex(int row, int column, boolean isFire, int numberOfMoves) {
        this.row = row;
        this.column = column;
        this.isFire = isFire;
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

