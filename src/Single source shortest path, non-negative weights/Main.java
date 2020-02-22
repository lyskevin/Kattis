import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final int INF = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        int q = fio.nextInt();
        int s = fio.nextInt();
        while (!(n == 0 && m == 0 && q == 0 && s == 0)) {
            // Create adjacency list
            ArrayList<ArrayList<IntegerTriple>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            // Store all edges in adjacency list
            for (int i = 0; i < m; i++) {
                int start = fio.nextInt();
                int end = fio.nextInt();
                int weight = fio.nextInt();
                adjList.get(start).add(new IntegerTriple(start, end, weight));
            }
            // Run Dijkstra's algorithm to get the shortest distances from the source node to all other nodes
            int[] distances = new int[n];
            for (int i = 0; i < n; i++) {
                if (i != s) {
                    distances[i] = INF;
                }
            }
            PriorityQueue<IntegerTriple> pq = new PriorityQueue<>();
            for (IntegerTriple triple : adjList.get(s)) {
                pq.add(triple);
            }
            while (!pq.isEmpty()) {
                IntegerTriple triple = pq.poll();
                if (distances[triple.end] > distances[triple.start] + triple.weight) {
                    distances[triple.end] = distances[triple.start] + triple.weight;
                    for (IntegerTriple neighbour : adjList.get(triple.end)) {
                        pq.add(neighbour);
                    }
                }
            }
            // Process queries
            for (int i = 0; i < q; i++) {
                int destination = fio.nextInt();
                if (distances[destination] < INF) {
                    fio.println(distances[destination]);
                } else {
                    fio.println("Impossible");
                }
            }
            n = fio.nextInt();
            m = fio.nextInt();
            q = fio.nextInt();
            s = fio.nextInt();
            if (!(n == 0 && m == 0 && q == 0 && s == 0)) {
                fio.println();
            }
        }
        fio.close();
    }

}

class IntegerTriple implements Comparable<IntegerTriple> {

    int start;
    int end;
    int weight;

    IntegerTriple(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
        public int compareTo(IntegerTriple other) {
            return this.weight - other.weight;
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

