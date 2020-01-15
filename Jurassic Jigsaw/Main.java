import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int k = fio.nextInt();
        String[] samples = new String[n];
        for (int i = 0; i < n; i++) {
            samples[i] = fio.nextLine();
        }
        // Store edges
        PriorityQueue<Edge> edgePQ = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                String sample1 = samples[i];
                String sample2 = samples[j];
                for (int m = 0; m < k; m++) {
                    if (sample1.charAt(m) != sample2.charAt(m)) {
                        count++;
                    }
                }
                edgePQ.add(new Edge(i, j, count));
            }
        }
        // Run Kruskal's algorithm
        UnionFind uf = new UnionFind(n);
        int totalDistance = 0;
        PriorityQueue<Edge> outputs = new PriorityQueue<>();
        while (!edgePQ.isEmpty()) {
            Edge edge = edgePQ.poll();
            if (!uf.isSameSet(edge.start, edge.end)) {
                uf.unionSet(edge.start, edge.end);
                totalDistance += edge.distance;
                outputs.add(edge);
            }
        }
        fio.println(totalDistance);
        while (!outputs.isEmpty()) {
            fio.println(outputs.poll());
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

    @Override
    public String toString() {
        return start + " " + end;
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

