import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int[][] MOVES = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private static final int INF = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        int M = fio.nextInt();
        char[][] grid = new char[N][M];
        Deque<State> deque = new LinkedList<>();
        int[][] distances = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < M; j++) {
                char c = row.charAt(j);
                grid[i][j] = c;
                if (c == 'W') {
                    deque.offer(new State(i, j, -1));
                    distances[i][j] = -1;
                } else {
                    distances[i][j] = INF;
                }
            }
        }

        int[] results = new int[26];
        for (int i = 0; i < 26; i++) {
            results[i] = INF;
        }

        while (!deque.isEmpty()) {
            State state = deque.poll();
            
            char current = grid[state.row][state.column];
            for (int i = 0; i < 8; i++) {
                int nextRow = state.row + MOVES[i][0];
                int nextColumn = state.column + MOVES[i][1];
                if (nextRow >= 0 && nextRow < N && nextColumn >= 0 && nextColumn < M) {
                    char next = grid[nextRow][nextColumn];
                    int nextDistance = state.distance;
                    nextDistance += current == next ? 0 : 1;
                    if (distances[nextRow][nextColumn] > nextDistance) {
                        distances[nextRow][nextColumn] = nextDistance;
                        if (results[next - 'A'] > nextDistance) {
                            results[next - 'A'] = nextDistance;
                        }
                        if (current == next) {
                            deque.offerFirst(new State(nextRow, nextColumn, nextDistance));
                        } else {
                            deque.offer(new State(nextRow, nextColumn, nextDistance));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if ('A'+ i != 'W' && results[i] < INF) {
                fio.println(((char) ('A' + i)) + " " + results[i]);
            }
        }

        fio.close();
    }
}

class State {
    int row;
    int column;
    int distance;

    State(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
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

