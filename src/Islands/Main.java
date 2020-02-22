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
        char[][] map = new char[numberOfRows][numberOfColumns];
        boolean landExists = false;
        for (int i = 0; i < numberOfRows; i++) {
            String row = fr.nextLine();
            for (int j = 0; j < numberOfColumns; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        boolean[][] isVisited = new boolean[numberOfRows][numberOfColumns];
        int minimumNumberOfIslands = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (!isVisited[i][j] && map[i][j] == 'L') {
                    dfs(i, j, map, isVisited);
                    minimumNumberOfIslands++;
                }
            }
        }
        System.out.println(minimumNumberOfIslands);
    }

    private static void dfs(int row, int column, char[][] map,
        boolean[][] isVisited) {
        int topRow = row - 1;
        if (topRow >= 0 && map[topRow][column] != 'W'
            && !isVisited[topRow][column]) {
            isVisited[topRow][column] = true;
            dfs(topRow, column, map, isVisited);
        }
        int bottomRow = row + 1;
        if (bottomRow < map.length && map[bottomRow][column] != 'W'
            && !isVisited[bottomRow][column]) {
            isVisited[bottomRow][column] = true;
            dfs(bottomRow, column, map, isVisited);
        }
        int leftColumn = column - 1;
        if (leftColumn >= 0 && map[row][leftColumn] != 'W'
            && !isVisited[row][leftColumn]) {
            isVisited[row][leftColumn] = true;
            dfs(row, leftColumn, map, isVisited);
        }
        int rightColumn = column + 1;
        if (rightColumn < map[row].length && map[row][rightColumn] != 'W'
            && !isVisited[row][rightColumn]) {
            isVisited[row][rightColumn] = true;
            dfs(row, rightColumn, map, isVisited);
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

