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
        Vertex[][] grid = new Vertex[r][c];
        int centerRow = (r - 1) / 2;
        int centerColumn = (c - 1) / 2;
        Vertex start = new Vertex(centerRow, centerColumn);
        grid[centerRow][centerColumn] = start;
        Queue<Vertex> bfsQueue = new LinkedList<>();
        bfsQueue.add(start);
        while (!bfsQueue.isEmpty()) {
            Vertex u = bfsQueue.poll();
            if (u.row - 1 >= 0 && grid[u.row - 1][u.column] == null) {
                Vertex v = new Vertex(u.row - 1, u.column);
                u.top = true;
                v.bottom = true;
                grid[u.row - 1][u.column] = v;
                bfsQueue.add(v);
            }
            if (u.row + 1 < r && grid[u.row + 1][u.column] == null) {
                Vertex v = new Vertex(u.row + 1, u.column);
                u.bottom = true;
                v.top = true;
                grid[u.row + 1][u.column] = v;
                bfsQueue.add(v);
            }
            if (u.column - 1 >= 0 && grid[u.row][u.column - 1] == null) {
                Vertex v = new Vertex(u.row, u.column - 1);
                u.left = true;
                v.right = true;
                grid[u.row][u.column - 1] = v;
                bfsQueue.add(v);
            }
            if (u.column + 1 < c && grid[u.row][u.column + 1] == null) {
                Vertex v = new Vertex(u.row, u.column + 1);
                u.right = true;
                v.left = true;
                grid[u.row][u.column + 1] = v;
                bfsQueue.add(v);
            }
        }
        for (int i = 0; i < 2 * c; i++) {
            if (i % 2 == 0) {
                fio.print(" ");
            } else {
                fio.print("_");
            }
        }
        fio.println();
        for (int i = 0; i < r; i++) {
            fio.print("|");
            for (int j = 0; j < c; j++) {
                if (grid[i][j].bottom) {
                    fio.print(" ");
                } else {
                    fio.print("_");
                }
                if (grid[i][j].right) {
                    fio.print(" ");
                } else {
                    fio.print("|");
                }
            }
            fio.println();
        }
        fio.close();
    }
}

class Vertex {

    boolean left;
    boolean right;
    boolean top;
    boolean bottom;
    int row;
    int column;

    Vertex(int row, int column) {
        this.row = row;
        this.column = column;
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

