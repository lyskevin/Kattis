import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    static int[][] boards = new int[2000][80];

    public static void main(String[] args) {
        boards[0][0] = 1;
        for (int i = 1; i < 2000; i++) {
            // Copy previous board
            for (int j = 0; j < 80; j++) {
                boards[i][j] = boards[i - 1][j];
            }
            // Find index of first zero
            int zeroIndex = 0;
            while (boards[i][zeroIndex] > 0) {
                zeroIndex++;
            }
            // Set number at index of first zero to index + 1
            // Then, decrement all preceding numbers by 1
            // This ensures that the total number of counters is consistent
            // and also that the board goes back to the previous board after
            // distributing the counters at this index
            boards[i][zeroIndex] = zeroIndex + 1;
            for (int j = 0; j < zeroIndex; j++) {
                boards[i][j]--;
            }
        }
        FastIO fio = new FastIO();
        int p = fio.nextInt();
        for (int i = 0; i < p; i++) {
            int k = fio.nextInt();
            int n = fio.nextInt();
            int numberOfBuckets = 0;
            for (int j = 0; j < 80; j++) {
                if (boards[n - 1][j] > 0) {
                    numberOfBuckets = j + 1;
                }
            }
            fio.println(k + " " + numberOfBuckets);
            for (int j = 0; j < numberOfBuckets; j++) {
                fio.print(boards[n - 1][j]);
                if (j == numberOfBuckets - 1 || j % 10 == 9) {
                    fio.println();
                } else {
                    fio.print(" ");
                }
            }
        }
        fio.close();
    }

    private static int[] copyBoard(int[] board) {
        int[] copy = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i];
        }
        return copy;
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

