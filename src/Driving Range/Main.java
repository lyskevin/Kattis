import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        // Store edges
        PriorityQueue<Edge> edgePQ = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            edgePQ.offer(new Edge(fio.nextInt(), fio.nextInt(), fio.nextInt()));
        }
        // Run Kruskal's algorithm
        UnionFind uf = new UnionFind(n);
        int numberOfEdges = 0;
        int lastDistance = 0;
        while (!edgePQ.isEmpty()) {
            Edge edge = edgePQ.poll();
            if (!uf.isSameSet(edge.start, edge.end)) {
                uf.unionSet(edge.start, edge.end);
                numberOfEdges++;
                // Track weight of last edge (if it exists);
                if (numberOfEdges == n - 1) {
                    lastDistance = edge.distance;
                }
            }
        }
        if (lastDistance == 0) {
            fio.println("IMPOSSIBLE");
        } else {
            fio.println(lastDistance);
        }
        fio.close();
    }
}

class Edge implements Comparable<Edge> {

    int start;
    int end;
    int distance;

    Edge(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return this.distance - other.distance;
    }

}

class UnionFind {                                              
    public int[] p;
    public int[] rank;
    public int numSets;

    public UnionFind(int N) {
        p = new int[N];
        rank = new int[N];
        numSets = N;
        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }

    public int findSet(int i) { 
        if (p[i] == i) return i;
        else {
            p[i] = findSet(p[i]);
            return p[i]; 
        } 
    }

    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    public void unionSet(int i, int j) { 
        if (!isSameSet(i, j)) { 
            numSets--; 
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank[x] > rank[y]) 
                p[y] = x;
            else { 
                p[x] = y;
                if (rank[x] == rank[y]) 
                    rank[y] = rank[y]+1; 
            } 
        } 
    }

    public int numDisjointSets() { return numSets; }
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

