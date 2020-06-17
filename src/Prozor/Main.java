import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int r = fio.nextInt();
        int s = fio.nextInt();
        int k = fio.nextInt();
        char[][] grid = new char[r][s];
        int[][] rangeSums = new int[r][s];

        // Generate 1D range sums for each row and store grid
        for (int i = 0; i < r; i++) {
            String row = fio.nextLine();
            int sum = 0;
            for (int j = 0; j < s; j++) {
                char c = row.charAt(j);
                grid[i][j] = c;
                sum += c == '*' ? 1 : 0;
                rangeSums[i][j] = sum;
            }
        }

        // Find max 2D range sum
        int startRow = 0;
        int startColumn = 0;
        int max = 0;
        for (int i = 0; i < r - k + 1; i++) {
            for (int j = 0; j < s - k + 1; j++) {
                int sum = 0;
                for (int l = i + 1; l < i + k - 1; l++) {
                    sum += rangeSums[l][j + k - 2] - rangeSums[l][j];
                }
                if (sum > max) {
                    max = sum;
                    startRow = i;
                    startColumn = j;
                }
            }
        }

        // Print answer
        fio.println(max);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if (i >= startRow && i <= startRow + k - 1
                        && j >= startColumn && j <= startColumn + k - 1) {
                    if (i == startRow || i == startRow + k - 1) {
                        if (j == startColumn || j == startColumn + k - 1) {
                            fio.print("+");
                        } else {
                            fio.print("-");
                        }
                    } else if (j == startColumn || j == startColumn + k - 1) {
                        fio.print("|");
                    } else {
                        fio.print(grid[i][j]);
                    }
                } else {
                    fio.print(grid[i][j]);
                }
            }
            fio.println();
        }
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

