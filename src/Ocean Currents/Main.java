import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static final int INFINITY = 1000000000;

    public static final int[][] NEXT_POSITIONS = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) {

        FastIO fio = new FastIO();
        int numberOfRows = fio.nextInt();
        int numberOfColumns = fio.nextInt();
        int[][] grid = new int[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            String rowInput = fio.nextLine();
            for (int j = 0; j < numberOfColumns; j++) {
                grid[i][j] = rowInput.charAt(j) - '0';
            }
        }

        int numberOfTestCases = fio.nextInt();

        for (int i = 0; i < numberOfTestCases; i++) {
            int rowStart = fio.nextInt() - 1;
            int columnStart = fio.nextInt() - 1;
            int rowDestination = fio.nextInt() - 1;
            int columnDestination = fio.nextInt() - 1;

            int[][] distances = new int[numberOfRows][numberOfColumns];
            for (int j = 0; j < numberOfRows; j++) {
                for (int k = 0; k < numberOfColumns; k++) {
                    distances[j][k] = INFINITY;
                }
            }
            
            Deque<Node> bfsDeque = new LinkedList<>();
            bfsDeque.addFirst(new Node(rowStart, columnStart));
            distances[rowStart][columnStart] = 0;
            while (!bfsDeque.isEmpty()) {
                Node node = bfsDeque.removeFirst();
                int row = node.row;
                int column = node.column;
                for (int j = 0; j < 8; j++) {
                    int nextRow = row + NEXT_POSITIONS[j][0];
                    int nextColumn = column + NEXT_POSITIONS[j][1];
                    if (nextRow >= 0 && nextRow < numberOfRows 
                                && nextColumn >= 0 && nextColumn < numberOfColumns) {
                        int nextDistance = grid[row][column] == j ? 0 : 1;
                        if (distances[nextRow][nextColumn] > distances[row][column] + nextDistance) {
                            distances[nextRow][nextColumn] = distances[row][column] + nextDistance;
                            if (nextDistance == 0) {
                                bfsDeque.addFirst(new Node(nextRow, nextColumn));
                            } else {
                                bfsDeque.addLast(new Node(nextRow, nextColumn));
                            }
                        }
                    }
                }
            }

            fio.println(distances[rowDestination][columnDestination]);

        }

        fio.close();

    }

}

class Node {
    
    int row;
    int column;

    Node(int row, int column) {
        this.row = row;
        this.column = column;
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

