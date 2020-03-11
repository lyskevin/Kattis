import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int[][] MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int x = fio.nextInt();
        int y = fio.nextInt();
        int[][] garden = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                garden[i][j] = fio.nextInt();
            }
        }
        boolean[][] visited = new boolean[y][x];
        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visited[i][j]) {
                    result += bfs(garden, visited, i, j);
                }
            }
        }
        fio.println(result);
        fio.close();
    }

    private static int bfs(int[][] garden, boolean[][] visited, int y, int x) {
        Queue<Tuple> bfsQueue = new LinkedList<>();
        visited[y][x] = true;
        bfsQueue.offer(new Tuple(x, y));
        int size = 0;
        boolean isPool = true;
        while (!bfsQueue.isEmpty()) {
            Tuple u = bfsQueue.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nextY = u.y + MOVES[i][0];
                int nextX = u.x + MOVES[i][1];
                if (nextY >= 0 && nextY < garden.length && nextX >= 0 && nextX < garden[0].length) {
                    if (garden[nextY][nextX] < garden[y][x]) {
                        isPool = false;
                    } else if (garden[nextY][nextX] == garden[y][x] && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        bfsQueue.offer(new Tuple(nextX, nextY));
                    } 
                }
            }
        }
        if (isPool) {
            return size;
        } else {
            return 0;
        }
    }

}

class Tuple {

    int x;
    int y;

    Tuple(int x, int y) {
        this.x = x;
        this.y = y;
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

