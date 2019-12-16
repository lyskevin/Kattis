import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final int[][] MOVES = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int l = fio.nextInt();
        int r = fio.nextInt();
        int c = fio.nextInt();
        while (!(l == 0 && r == 0 && c == 0)) {
            char[][][] grid = new char[l][r][c];
            int sL = 0;
            int sR = 0;
            int sC = 0;
            int eL = 0;
            int eR = 0;
            int eC = 0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String row = fio.nextLine();
                    for (int k = 0; k < c; k++) {
                        char cell = row.charAt(k);
                        if (cell == 'S') {
                            sL = i;
                            sR = j;
                            sC = k;
                        }
                        if (cell == 'E') {
                            eL = i;
                            eR = j;
                            eC = k;
                        }
                        grid[i][j][k] = cell; 
                    }
                }
                fio.nextLine();
            }
            boolean[][][] visited = new boolean[l][r][c];
            int[][][] distances = new int[l][r][c];
            Queue<Coordinates> bfsQueue = new LinkedList<>();
            bfsQueue.offer(new Coordinates(sL, sR, sC, 0));
            visited[sL][sR][sC] = true;
            while (!bfsQueue.isEmpty()) {
                Coordinates coordinates = bfsQueue.poll();
                for (int i = 0; i < 6; i++) {
                    int nextL = coordinates.a + MOVES[i][0];
                    int nextR = coordinates.b + MOVES[i][1];
                    int nextC = coordinates.c + MOVES[i][2];
                    if (nextL >= 0 && nextL < l
                            && nextR >= 0 && nextR < r
                            && nextC >= 0 && nextC < c
                            && !visited[nextL][nextR][nextC]
                            && grid[nextL][nextR][nextC] != '#') {
                        visited[nextL][nextR][nextC] = true;
                        distances[nextL][nextR][nextC] = coordinates.d + 1;
                        bfsQueue.offer(new Coordinates(nextL, nextR, nextC, coordinates.d + 1));
                    }
                }
            }
            if (visited[eL][eR][eC]) {
                fio.println("Escaped in " + distances[eL][eR][eC] + " minute(s).");
            } else {
                fio.println("Trapped!");
            }
            l = fio.nextInt();
            r = fio.nextInt();
            c = fio.nextInt();
        }
        fio.close();
    }
}

class Coordinates {

    int a;
    int b;
    int c;
    int d;

    Coordinates(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

