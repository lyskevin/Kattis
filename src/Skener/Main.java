import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numberOfRows = fio.nextInt();
        int numberOfColumns = fio.nextInt();
        int newNumberOfRows = fio.nextInt();
        int newNumberOfColumns = fio.nextInt();
        char[][] grid = new char[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < numberOfColumns; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < newNumberOfRows; j++) { 
                for (int k = 0; k < numberOfColumns; k++) {
                    for (int m = 0; m < newNumberOfColumns; m++) {
                        output.append(grid[i][k]);
                    }
                }
                output.append("\n");
            }
        }
        System.out.print(output);
        // For each character, print it newNumberOfColumns times
        // For each row, print it newNumberOfRows times
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

