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
            int n = fio.nextInt();
            int[][] board = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                String row = fio.nextLine();
                for (int k = 0; k < n; k++) {
                    board[j][k] = row.charAt(k) - '0';
                }
            }

            State state = new State(board);
            int[] result = new int[6];
            int sum = 0;

            while (!state.isFilled()) {
                int bestCount = 0;
                int bestColour = 1;
                State[] states = new State[6];
                for (int j = 1; j <= 6; j++) {
                    State stateClone = state.clone();
                    states[j - 1] = stateClone;
                    if (stateClone.board[0][0] != j) {
                        int count = stateClone.dfs(0, 0, j, stateClone.board[0][0]);
                        if (count > bestCount) {
                            bestColour = j;
                            bestCount = count;
                        }
                    }
                }

                result[bestColour - 1]++;
                state = states[bestColour - 1];
                sum++;
            }

            fio.println(sum);
            for (int j = 0; j < 6; j++) {
                if (j > 0) {
                    fio.print(" ");
                }
                fio.print(result[j]);
            }
            fio.println();
        }        

        fio.close();
    }
}

class State {
    private static int[][] MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;
    int[][] board;

    State(int[][] board) {
        visited = new boolean[board.length][board[0].length];
        this.board = copyBoard(board);
    }

    public State clone() {
        return new State(board);
    }

    boolean isFilled() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != board[0][0]) {
                    return false;
                }
            }
        }
        return true;
    }

    int dfs(int row, int column, int newColour, int originalColour) {
        boolean hasChanged = board[row][column] == originalColour;
        int result = hasChanged ? 0 : 1;
        board[row][column] = newColour;
        visited[row][column] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + MOVES[i][0];
            int nextColumn = column + MOVES[i][1];
            if (nextRow >= 0 && nextRow < board.length && nextColumn >= 0 && nextColumn < board[0].length && !visited[nextRow][nextColumn]
                    && ((hasChanged && board[nextRow][nextColumn] == originalColour) || board[nextRow][nextColumn] == newColour)) {
                result += dfs(nextRow, nextColumn, newColour, originalColour);
            }
        }

        return result;
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
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

