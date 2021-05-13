import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int[][] MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static char[] ALLOWED_ZONES = {'D', 'U', 'R', 'L'};

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int t = fio.nextInt();
        int N = fio.nextInt();
        int M = fio.nextInt();
        int startRow = 0;
        int startCol = 0;
        char[][] grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.charAt(j);
                if (row.charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int distance = -1;
        Queue<State> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new State(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()) {
            State state = queue.poll();

            if (state.row == 0 || state.col == 0 || state.row == N - 1 || state.col == M - 1) {
                distance = state.distance;
                break;
            }

            for (int i = 0; i < MOVES.length; i++) {
                int nextRow = state.row + MOVES[i][0];
                int nextCol = state.col + MOVES[i][1];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !visited[nextRow][nextCol]
                        && (grid[nextRow][nextCol] == '0' || grid[nextRow][nextCol] == ALLOWED_ZONES[i])) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new State(nextRow, nextCol, state.distance + 1));
                }
            }
        }

        fio.println(distance > -1 && distance <= t ? distance : "NOT POSSIBLE");

        fio.close();
    }
}

class State {
    int row;
    int col;
    int distance;

    State(int row, int col, int distance) {
        this.row = row;
        this.col = col;
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

