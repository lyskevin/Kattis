import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfRows = fr.nextInt();
        int numberOfColumns = fr.nextInt();
        char[][] grid = new char[numberOfRows][numberOfColumns];
        boolean[][] visited = new boolean[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            String row = fr.nextLine();
            for (int j = 0; j < numberOfColumns; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        int row = 0;
        int column = 0;
        boolean isTreasureFound = false;
        boolean isLost = false;
        boolean isOut = false;
        int numberOfMoves = 0;
        while (true) {
            if (row < 0 || row >= numberOfRows || column < 0
                    || column >= numberOfColumns) {
                isOut = true;
                break;
            } else if (visited[row][column]) {
                isLost = true;
                break;
            } else {
                char direction = grid[row][column];
                visited[row][column] = true;
                if (direction == 'T') {
                    isTreasureFound = true;
                    break;
                } else {
                    if (direction == 'N') {
                        row--;
                    } else if (direction == 'S') {
                        row++;
                    } else if (direction == 'W') {
                        column--;
                    } else {
                        column++;
                    }
                    numberOfMoves++;
                }
            }
        }
        if (isLost) {
            System.out.println("Lost");
        } else if (isOut) {
            System.out.println("Out");
        } else {
            System.out.println(numberOfMoves);
        }
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
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

