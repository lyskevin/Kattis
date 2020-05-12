import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int r = fio.nextInt();
        int c = fio.nextInt();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        boolean[][] visited = new boolean[r][c];
        int totalNumberOfHandshakes = 0;
        int mirkoMaxHandshakes = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int mirkoHandshakes = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (i + k >= 0 && i + k < r && j + l >= 0 && j + l < c && (i + k != i || j + l != j)) { // Valid position
                            if (grid[i][j] == '.' && grid[i + k][j + l] == 'o') { // Mirko's handshake
                                mirkoHandshakes++;
                            }
                            if (grid[i][j] == 'o' && grid[i + k][j + l] == 'o'
                                    && !visited[i + k][j + l]) { // Handshakes among other church members
                                totalNumberOfHandshakes++;
                            }
                        }
                    }
                }
                mirkoMaxHandshakes = Math.max(mirkoMaxHandshakes, mirkoHandshakes);
                visited[i][j] = true;
            }
        }
        fio.println(totalNumberOfHandshakes + mirkoMaxHandshakes); // Total = Mirko's max + handshakes among all other members
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

