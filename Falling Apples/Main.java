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
        char[][] newGrid = new char[r][c];
        // Iterate from bottom to top and left to right
        for (int i = 0; i < c; i++) {
            // Track all available empty slots below current position
            PriorityQueue<Integer> emptySlots = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = r - 1; j >= 0; j--) {
                // Obstacle encountered; reset empty slots
                if (grid[j][i] == '#') {
                    emptySlots = new PriorityQueue<>(Comparator.reverseOrder());
                    newGrid[j][i] = '#';
                } else if (grid[j][i] == 'a') {
                    // Empty slot available; place apple at lowest possible one
                    if (!emptySlots.isEmpty()) {
                        int newRow = emptySlots.poll();
                        newGrid[newRow][i] = 'a';
                        emptySlots.add(j);
                    } else {
                        // Apple remains in position
                        newGrid[j][i] = 'a';
                    }
                } else {
                    emptySlots.add(j);
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (newGrid[i][j] == 'a' || newGrid[i][j] == '#') {
                    fio.print(newGrid[i][j]);
                } else {
                    fio.print(".");
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

