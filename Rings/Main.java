import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int[][] neighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        int[][] ringNumbers = new int[n][m];

        // Fill outer rings with 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'T') {
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + neighbours[k][0];
                        int nextColumn = j + neighbours[k][1];
                        if (!isValidRow(nextRow, grid) || !isValidColumn(nextColumn, grid)) {
                            ringNumbers[i][j] = 1;
                        } else if (grid[nextRow][nextColumn] == '.') {
                            ringNumbers[i][j] = 1;
                        }
                    }
                }
            }
        }
        
        // Fill inner rings until all of them have been filled
        int counter = 1;
        boolean hasUnfilledRing = true;
        while (hasUnfilledRing) {
            counter++;
            hasUnfilledRing = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'T' && ringNumbers[i][j] == 0) {
                        hasUnfilledRing = true;
                        for (int k = 0; k < 4; k++) {
                            int nextRow = i + neighbours[k][0];
                            int nextColumn = j + neighbours[k][1];
                            if (isValidRow(nextRow, grid) && isValidColumn(nextColumn, grid)
                                    && ringNumbers[nextRow][nextColumn] == counter - 1) {
                                ringNumbers[i][j] = counter;
                            }
                        }
                    }
                }
            }
        }

        // Print formatted output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (counter >= 10) {
                    if (ringNumbers[i][j] == 0) {
                        fio.print("...");
                    } else if (ringNumbers[i][j] < 10) {
                        fio.print(".." + ringNumbers[i][j]);
                    } else {
                       fio.print("." + ringNumbers[i][j]); 
                    }
                } else {
                    if (ringNumbers[i][j] == 0) {
                        fio.print("..");
                    } else {
                        fio.print("." + ringNumbers[i][j]);
                    }
                }

            }
            fio.println();
        }
        fio.close();
    }


    private static boolean isValidRow(int row, char[][] grid) {
        return row >= 0 && row < grid.length;
    }

    private static boolean isValidColumn(int column, char[][] grid) {
        return column >= 0 && column < grid[0].length;
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

