import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int[][] display = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                display[i][j] = fio.nextInt();
            }
        }
        // Run BFS algorithm by converting each grid into a base 4 number
        Queue<Tuple> bfsQueue = new LinkedList<>();
        boolean[] visited = new boolean[1000000];
        bfsQueue.offer(new Tuple(0, display));
        int numberOfSteps = -1;
        while (!bfsQueue.isEmpty()) {
            Tuple tuple = bfsQueue.poll();
            if (getNumber(tuple.grid) == 0) {
                numberOfSteps = tuple.numberOfSteps;
                break;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] nextGrid = copyGrid(tuple.grid);
                    push(i, j, nextGrid);
                    int number = getNumber(nextGrid);
                    if (!visited[number]) {
                        visited[number] = true;
                        bfsQueue.offer(new Tuple(tuple.numberOfSteps + 1, nextGrid));
                    }
                }
            }
        }
        fio.println(numberOfSteps);
        fio.close();
    }

    // Converts the specified grid into a base 4 number
    private static int getNumber(int[][] grid) {
        int multiplier = 1;
        int number = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                number += grid[i][j] * multiplier;
                multiplier *= 4;
            }
        }
        return number;
    }

    private static int[][] copyGrid(int[][] grid) {
        int[][] newGrid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }
        return newGrid;
    }

    private static void push(int row, int column, int[][] grid) {
        grid[row][column] = (grid[row][column] + 1) % 4;
        for (int i = 0; i < 3; i++) {
            if (i != column) {
                grid[row][i] = (grid[row][i] + 1) % 4;
            }
            if (i != row) {
                grid[i][column] = (grid[i][column] + 1) % 4;
            }
        }
    }

}

class Tuple {

    int numberOfSteps;
    int[][] grid;

    Tuple(int numberOfSteps, int[][] grid) {
        this.numberOfSteps = numberOfSteps;
        this.grid = grid;
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

