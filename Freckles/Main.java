import java.io.*;
import java.util.*;
import java.text.*;

/**
 * @author lyskevin
 */
public class Main {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fio.nextInt();
            double[][] freckles = new double[n][2];
            for (int j = 0; j < n; j++) {
                freckles[j][0] = fio.nextDouble();
                freckles[j][1] = fio.nextDouble();
            }
            PriorityQueue<Edge> edgePQ = new PriorityQueue<>();
            // Connect each freckle to all other freckles
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double distance = Math.sqrt(Math.pow(freckles[j][0] - freckles[k][0], 2)
                            + Math.pow(freckles[j][1] - freckles[k][1], 2));
                    edgePQ.offer(new Edge(j, k, distance));
                }
            }
            UnionFind uf = new UnionFind(n);
            double totalDistance = 0.0;
            int numberOfEdges = 0;
            // Run Kruskal's algorithm
            // Need to stop when number of edges == n - 1; will get TLE verdict otherwise
            while (!edgePQ.isEmpty() && numberOfEdges < n - 1) {
                Edge edge = edgePQ.poll();
                if (!uf.isSameSet(edge.start, edge.end)) {
                    totalDistance += edge.distance;
                    uf.unionSet(edge.start, edge.end);
                    numberOfEdges++;
                }
            }
            fio.println(df.format(totalDistance));
        }
        fio.close();
    }
}

class Edge implements Comparable<Edge> {

    int start;
    int end;
    double distance;

    Edge(int start, int end, double distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.distance, other.distance);
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

