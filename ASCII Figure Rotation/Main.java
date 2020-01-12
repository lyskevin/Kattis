import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        while (n > 0) {
            char[][] grid = new char[n][100];
            int maxNumberOfColumns = 0;
            for (int i = 0; i < n; i++) {
                String row = fio.nextLine();
                maxNumberOfColumns = Math.max(maxNumberOfColumns, row.length());
                int index = 0;
                while (index < row.length()) {
                    grid[i][index] = row.charAt(index);
                    index++;
                }
                // Pad rest of row with trailing spaces for convenience
                while (index < 100) {
                    grid[i][index] = ' ';
                    index++;
                }
            }
            for (int i = 0; i < maxNumberOfColumns; i++) {
                int stoppingIndex = 0;
                // Get rid of trailing spaces
                while (stoppingIndex < n && grid[stoppingIndex][i] == ' ') {
                    stoppingIndex++;
                }
                // Print appropriate characters
                for (int j = n - 1; j >= stoppingIndex; j--) {
                    if (grid[j][i] == '-') {
                        fio.print("|");
                    } else if (grid[j][i] == '|') {
                        fio.print("-");
                    } else if (grid[j][i] == '+') {
                        fio.print("+");
                    } else {
                        fio.print(" ");
                    }
                }
                fio.println();
            }
            n = fio.nextInt();
            if (n > 0) {
                fio.println();
            }
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

