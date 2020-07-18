import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int INFINITY = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        // Read starting parameters
        int n = fio.nextInt();
        int m = fio.nextInt();
        int q = fio.nextInt();
        int s = fio.nextInt();

        while (n > 0 || m > 0 || q > 0 || s > 0) {

            // Initialise adjacency list
            ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            
            // Store edges in adjacency list
            for (int i = 0; i < m; i++) {
                int u = fio.nextInt();
                int v = fio.nextInt();
                int t0 = fio.nextInt();
                int P = fio.nextInt();
                int d = fio.nextInt();
                adjList.get(u).add(new Edge(u, v, t0, P, d));
            }

            // Initialise data structures for use in Dijkstra's algorithm
            PriorityQueue<Tuple> pq = new PriorityQueue<>();
            pq.add(new Tuple(s, 0));
            int[] times = new int[n];
            for (int i = 0; i < n; i++) {
                times[i] = INFINITY;
            }
            times[s] = 0;

            // Run Dijkstra's algorithm
            while (!pq.isEmpty()) {
                Tuple tuple = pq.poll();

                // Lazy data structure
                if (times[tuple.location] == tuple.time) {
                    for (Edge neighbour : adjList.get(tuple.location)) {
                        // Minimum traversal start time is t0
                        int timeToStartTraversing = Math.max(tuple.time, neighbour.t0);

                        if (timeToStartTraversing > neighbour.t0) {
                            if (neighbour.P > 0) { // Can traverse this edge at th next t0 + t * P for some nonnegative integer t
                                int remainder = (timeToStartTraversing - neighbour.t0) % neighbour.P;
                                if (remainder != 0) {
                                    timeToStartTraversing += neighbour.P - remainder;
                                }
                            } else { // Can no longer traverse this edge
                                timeToStartTraversing = INFINITY;
                            }
                        }

                        if (times[neighbour.v] > timeToStartTraversing + neighbour.d) {
                            times[neighbour.v] = timeToStartTraversing + neighbour.d;
                            pq.add(new Tuple(neighbour.v, timeToStartTraversing + neighbour.d));
                        }
                    }
                }
            }

            // Process queries
            for (int i = 0; i < q; i++) {
                int end = fio.nextInt();
                if (times[end] < INFINITY) {
                    fio.println(times[end]);
                } else {
                    fio.println("Impossible");
                }
            }

            // Read next set of parameters
            n = fio.nextInt();
            m = fio.nextInt();
            q = fio.nextInt();
            s = fio.nextInt();

            // Print newline if there is a subsequent test case
            if (n > 0 || m > 0 || q > 0 || s > 0) {
                fio.println();
            }
        }

        fio.close();
    }
}

class Tuple implements Comparable<Tuple> {
    int location;
    int time;

    Tuple(int location, int time) {
        this.location = location;
        this.time = time;
    }

    @Override
    public int compareTo(Tuple other) {
        return this.time - other.time;
    }

}

class Edge {
    int u;
    int v;
    int t0;
    int P;
    int d;

    Edge(int u, int v, int t0, int P, int d) {
        this.u = u;
        this.v = v;
        this.t0 = t0;
        this.P = P;
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

