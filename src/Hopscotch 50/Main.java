import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int INF = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int k = fio.nextInt();

        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = INF;
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = fio.nextInt();
                if (grid[i][j] == 1) {
                    pq.offer(new State(i, j, 0));
                    distances[i][j] = 0;
                }
            }
        }
        
        boolean isFound = false;
        while (!pq.isEmpty() && !isFound) {
            State state = pq.poll();
            
            if (grid[state.row][state.column] == k) {
                fio.println(state.distance);
                isFound = true;
            }

            if (state.distance > distances[state.row][state.column]) {
                continue;
            }

            for (int i = 0; i < n && !isFound; i++) {
                for (int j = 0; j < n; j++) {
                    int distance = Math.abs(i - state.row) + Math.abs(j - state.column);
                    int currentNumber = grid[state.row][state.column];
                    int nextNumber = grid[i][j];
                    if (nextNumber == currentNumber + 1
                            && distances[i][j] > state.distance + distance) {
                        distances[i][j] = state.distance + distance;
                        pq.offer(new State(i, j, distances[i][j]));
                    }
                }
            }
        }

        if (!isFound) {
            fio.println(-1);
        }

        fio.close();
    }
}

class State implements Comparable<State> {
    int row;
    int column;
    int distance;

    State(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }

    @Override
    public int compareTo(State other) {
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

