import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static final int INF = 1000000000;
    public static final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int r = fio.nextInt();
        int c = fio.nextInt();
        char[][] grid = new char[r][c];
        ArrayList<Coordinates> exits = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < c; j++) {
                char character = row.charAt(j);
                grid[i][j] = character;
                if ((i == 0 || i == r - 1 || j == 0 || j == c - 1) && character == 'D') {
                    exits.add(new Coordinates(i, j));
                }
            }
        }
        int[][] cars = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cars[i][j] = INF;
            }
        }
        int x = fio.nextInt() - 1;
        int y = fio.nextInt() - 1;
        Deque<Coordinates> bfsDeque = new LinkedList<>();
        bfsDeque.add(new Coordinates(x, y));
        cars[x][y] = 0;
        while (!bfsDeque.isEmpty()) {
            Coordinates coordinates = bfsDeque.removeFirst();
            int row = coordinates.row;
            int column = coordinates.column;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + MOVES[i][0];
                int nextColumn = column + MOVES[i][1];
                if (nextRow >= 0 && nextRow < r && nextColumn >= 0 && nextColumn < c
                    && grid[nextRow][nextColumn] != '#') {
                    int nextCar = grid[nextRow][nextColumn] == 'c' ? 1 : 0;
                    if (cars[nextRow][nextColumn] > cars[row][column] + nextCar) {
                        cars[nextRow][nextColumn] = cars[row][column] + nextCar;
                        if (nextCar == 0) {
                            bfsDeque.addFirst(new Coordinates(nextRow, nextColumn));
                        } else {
                            bfsDeque.addLast(new Coordinates(nextRow, nextColumn));
                        }
                    }
                }
            }
        }
        int min = INF;
        for (Coordinates exit : exits) {
            min = Math.min(min, cars[exit.row][exit.column]);
        }
        fio.println(min + 1);
        fio.close();
    }
}

class Coordinates {

    int row;
    int column;
    
    Coordinates(int row, int column) {
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

