import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numberOfTestCases = fio.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int n = fio.nextInt();
            int t = fio.nextInt();
            int[] buttons = new int[n];
            for (int j = 0; j < n; j++) {
                buttons[j] = fio.nextInt();
            }
            boolean[] visited = new boolean[3601];
            int[] distances = new int[3601];
            Queue<IntegerPair> bfsQueue = new LinkedList<>();
            bfsQueue.offer(new IntegerPair(0, 0));
            visited[0] = true;
            while (!bfsQueue.isEmpty()) {
                IntegerPair integerPair = bfsQueue.poll();
                for (int j = 0; j < n; j++) {
                    int nextTime = buttons[j] >= 0 ? Math.min(buttons[j] + integerPair.time, 3600)
                            : Math.max(buttons[j] + integerPair.time, 0);
                    if (!visited[nextTime]) {
                        visited[nextTime] = true;
                        distances[nextTime] = integerPair.distance + 1;
                        bfsQueue.offer(new IntegerPair(nextTime, integerPair.distance + 1));
                    }
                }
            }
            int minimumTime = t;
            while (!visited[minimumTime]) {
                minimumTime++;
            }
            fio.println(distances[minimumTime] + " " + (minimumTime - t));
        }
        fio.close();
    }
}

class IntegerPair {

    int time;
    int distance;

    IntegerPair(int time, int distance) {
        this.time = time;
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

