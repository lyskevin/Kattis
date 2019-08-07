import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfRows = fr.nextInt();
        int numberOfColumns = fr.nextInt();
        char[][] grid = new char[numberOfRows][numberOfColumns];
        Queue<Vertex> bfsQueue = new LinkedList<>();
        int joeRow = 0;
        int joeColumn = 0;
        for (int i = 0; i < numberOfRows; i++) {
            String row = fr.nextLine();
            for (int j = 0; j < numberOfColumns; j++) {
                char character = row.charAt(j);
                grid[i][j] = character;
                if (character == 'J') {
                    joeRow = i;
                    joeColumn = j;
                } else if (character == 'F') {
                    bfsQueue.offer(new Vertex(i, j, true, 0));
                }
            }
        }
        bfsQueue.offer(new Vertex(joeRow, joeColumn, false, 0));
        int numberOfMoves = bfs(grid, bfsQueue);
        if (numberOfMoves == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(numberOfMoves);
        }

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
                if (topRow >= 0 && (grid[topRow][column] == '.'
                            || grid[topRow][column] == 'J')) {
                    grid[topRow][column] = 'F';
                    bfsQueue.offer(new Vertex(topRow, column, true,
                                numberOfMoves + 1));
                }
                if (bottomRow < numberOfRows && (grid[bottomRow][column] == '.'
                            || grid[bottomRow][column] == 'J')) {
                    grid[bottomRow][column] = 'F';
                    bfsQueue.offer(new Vertex(bottomRow, column, true,
                                numberOfMoves + 1));
                }
                if (leftColumn >= 0 && (grid[row][leftColumn] == '.'
                            || grid[row][leftColumn] == 'J')) {
                    grid[row][leftColumn] = 'F';
                    bfsQueue.offer(new Vertex(row, leftColumn, true,
                                numberOfMoves + 1));
                }
                if (rightColumn < numberOfColumns && (grid[row][rightColumn] == '.'
                            || grid[row][rightColumn] == 'J')) {
                    grid[row][rightColumn] = 'F';
                    bfsQueue.offer(new Vertex(row, rightColumn, true,
                                numberOfMoves + 1));
                }
            } else {
                if (row == 0 || column == 0 || row == numberOfRows - 1
                        || column == numberOfColumns - 1) {
                    return numberOfMoves + 1;
                }
                if (topRow >= 0 && grid[topRow][column] == '.') {
                    grid[topRow][column] = 'J';
                    bfsQueue.offer(new Vertex(topRow, column, false,
                                numberOfMoves + 1));
                }
                if (bottomRow < numberOfRows && grid[bottomRow][column] == '.') {
                    grid[bottomRow][column] = 'J';
                    bfsQueue.offer(new Vertex(bottomRow, column, false,
                                numberOfMoves + 1));
                }
                if (leftColumn >= 0 && grid[row][leftColumn] == '.') {
                    grid[row][leftColumn] = 'J';
                    bfsQueue.offer(new Vertex(row, leftColumn, false,
                                numberOfMoves + 1));
                }
                if (rightColumn < numberOfColumns && grid[row][rightColumn] == '.') {
                    grid[row][rightColumn] = 'J';
                    bfsQueue.offer(new Vertex(row, rightColumn, false,
                                numberOfMoves + 1));
                }
            }
        }
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
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
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

