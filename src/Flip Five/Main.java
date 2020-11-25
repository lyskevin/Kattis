import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int P = fio.nextInt();
        for (int i = 0; i < P; i++) {
            int grid = 0;
            for (int j = 0; j < 3; j++) {
                String row = fio.nextLine();
                for (int k = 0; k < 3; k++) {
                    grid *= 2;
                    if (row.charAt(k) == '*') {
                        grid++;
                    }
                }
            }

            boolean[] visited = new boolean[512];
            visited[0] = true;
            Queue<State> bfsQueue = new LinkedList<>();
            bfsQueue.offer(new State(0, 0));

            while (!bfsQueue.isEmpty()) {
                State state = bfsQueue.poll();
                if (state.bitmask == grid) {
                    fio.println(state.distance);
                    break;
                }

                for (int j = 0; j < 9; j++) {
                    int newBitmask = state.bitmask ^ (1 << j);
                    if (j % 3 > 0) { // Right
                        newBitmask ^= (1 << (j - 1));
                    }
                    if (j % 3 < 2) { // Left
                        newBitmask ^= (1 << (j + 1));
                    }
                    if (j / 3 > 0) { // Down
                        newBitmask ^= (1 << (j - 3));
                    }
                    if (j / 3 < 2) { // Up
                        newBitmask ^= (1 << (j + 3));
                    }

                    if (!visited[newBitmask]) {
                        visited[newBitmask] = true;
                        bfsQueue.offer(new State(newBitmask, state.distance + 1));
                    }
                }
            }
        }

        fio.close();
    }
}

class State {
    int bitmask;
    int distance;

    State(int bitmask, int distance) {
        this.bitmask = bitmask;
        this.distance = distance;
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

