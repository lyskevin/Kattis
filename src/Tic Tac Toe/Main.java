import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static HashSet<Grid> validGrids = new HashSet<>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        char[][] current = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                current[i][j] = '.';
            }
        } 
        generateValidGrids(true, current);

        int N = fio.nextInt();
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                fio.nextLine();
            }
            char[][] input = new char[3][3];
            for (int j = 0; j < 3; j++) {
                String row = fio.nextLine();
                for (int k = 0; k < 3; k++) {
                    input[j][k] = row.charAt(k);
                }
            }
            if (validGrids.contains(new Grid(input[0][0], input[0][1], input[0][2], input[1][0], input[1][1], input[1][2],
                        input[2][0], input[2][1], input[2][2]))) {
                fio.println("yes");
            } else {
                fio.println("no");
            }
        }

        fio.close();
    }

    private static void generateValidGrids(boolean isX, char[][] current) {
        Grid grid = new Grid(current[0][0], current[0][1], current[0][2], current[1][0], current[1][1], current[1][2],
                current[2][0], current[2][1], current[2][2]);

        if (validGrids.contains(grid)) {
            return;
        }

        validGrids.add(grid);

        if (hasGameEnded(current)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (current[i][j] == '.') {
                    if (isX) {
                        current[i][j] = 'X';
                    } else {
                        current[i][j] = 'O';
                    }
                    generateValidGrids(!isX, current); 
                    current[i][j] = '.';
                }
            }
        }
    }

    private static boolean hasGameEnded(char[][] current) {
        // Check if filled row or filled column or filled diagonals or all filled
        return hasWinningRow(current) || hasWinningColumn(current) || hasWinningDiagonal(current)
                || hasAllFilledCells(current);
    }

    private static boolean hasWinningRow(char[][] current) {
        return (current[0][0] != '.' && current[0][0] == current[0][1] && current[0][0] == current[0][2])
                || (current[1][0] != '.' && current[1][0] == current[1][1] && current[1][0] == current[1][2])
                || (current[2][0] != '.' && current[2][0] == current[2][1] && current[2][0] == current[2][2]);
    }
    
    private static boolean hasWinningColumn(char[][] current) {
        return (current[0][0] != '.' && current[0][0] == current[1][0] && current[0][0] == current[2][0])
                || (current[0][1] != '.' && current[0][1] == current[1][1] && current[0][1] == current[2][1])
                || (current[0][2] != '.' && current[0][2] == current[1][2] && current[0][2] == current[2][2]);
    }

    private static boolean hasWinningDiagonal(char[][] current) {
        return (current[0][0] != '.' && current[0][0] == current[1][1] && current[0][0] == current[2][2])
                || (current[2][0] != '.' && current[2][0] == current[1][1] && current[2][0] == current[0][2]);
    }

    private static boolean hasAllFilledCells(char[][] current) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (current[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}

class Grid {
    char c1;
    char c2;
    char c3;
    char c4;
    char c5;
    char c6;
    char c7;
    char c8;
    char c9;

    Grid(char c1, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.c7 = c7;
        this.c8 = c8;
        this.c9 = c9;
    }

    @Override
    public boolean equals(Object other) {
        Grid otherGrid = (Grid) other;
        return this.c1 == otherGrid.c1 && this.c2 == otherGrid.c2 && this.c3 == otherGrid.c3
                && this.c4 == otherGrid.c4 && this.c5 == otherGrid.c5 && this.c6 == otherGrid.c6
                && this.c7 == otherGrid.c7 && this.c8 == otherGrid.c8 && this.c9 == otherGrid.c9;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c1, c2, c3, c4, c5, c6, c7, c8, c9);
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

