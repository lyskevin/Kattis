import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int f = fio.nextInt();
        int s = fio.nextInt();
        int g = fio.nextInt();
        int u = fio.nextInt();
        int d = fio.nextInt();
        boolean[] visited = new boolean[f + 1];
        visited[s] = true;
        Queue<Vertex> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Vertex(0, s));
        while (!bfsQueue.isEmpty()) {
            Vertex vertex = bfsQueue.poll();
            // Goal reached
            if (vertex.current == g) {
                fio.println(vertex.numberOfSteps);
                fio.close();
                return;
            }
            // Go up if possible and not visited before
            if (vertex.current + u <= f && !visited[vertex.current + u]) {
                visited[vertex.current + u] = true;
                bfsQueue.offer(new Vertex(vertex.numberOfSteps + 1, vertex.current + u));
            }
            // Go down if possible and not visited before
            if (vertex.current - d > 0 && !visited[vertex.current - d]) {
                visited[vertex.current - d] = true;
                bfsQueue.offer(new Vertex(vertex.numberOfSteps + 1, vertex.current - d));
            }
        }
        // Goal cannot be reached
        fio.println("use the stairs");
        fio.close();
    }
}

class Vertex {

    int numberOfSteps;
    int current;

    Vertex(int numberOfSteps, int current) {
        this.numberOfSteps = numberOfSteps;
        this.current = current;
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

