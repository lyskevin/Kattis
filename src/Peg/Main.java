import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        char[][] board = new char[7][7];
        for (int i = 0; i < 7; i++) {
            String input = fio.nextLine();
            for (int j = 0; j < 7; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        int numberOfMoves = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                // Valid jump towards the right
                if (j >= 2 && board[i][j] == '.' && board[i][j - 1] == 'o' && board[i][j - 2] == 'o') {
                    numberOfMoves++;
                }
                // Valid jump towards the left
                if (j >= 2 && board[i][7 - j - 1] == '.' && board[i][7 - j] == 'o' && board[i][7 - j + 1] == 'o') {
                    numberOfMoves++;
                }
                // Valid jump downwards
                if (i >= 2 && board[i][j] == '.' && board[i - 1][j] == 'o' && board[i - 2][j] == 'o') {
                    numberOfMoves++;
                }
                // Valid jump upwards
                if (i >= 2 && board[7 - i - 1][j] == '.' && board[7 - i][j] == 'o' && board[7 - i + 1][j] == 'o') {
                    numberOfMoves++;
                }
            }
        }
        fio.println(numberOfMoves);
        fio.close();
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

