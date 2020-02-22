import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        UnionFind uf = new UnionFind(n);
        // Map each number to a representative person
        PriorityQueue<Edge> edgePQ = new PriorityQueue<>();
        HashMap<Integer, Integer> numberToPeopleMappings = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int m = fio.nextInt();
            for (int j = 0; j < m; j++) {
                int d = fio.nextInt();
                if (numberToPeopleMappings.containsKey(d)) {
                    edgePQ.offer(new Edge(i, numberToPeopleMappings.get(d), d));
                } else {
                    numberToPeopleMappings.put(d, i);
                }
            }
        }
        ArrayList<Edge> mstEdges = new ArrayList<>();
        // Run Kruskal's algorithm
        int totalWeight = 0;
        while (!edgePQ.isEmpty()) {
            Edge edge = edgePQ.poll();
            if (!uf.isSameSet(edge.start, edge.end)) {
                uf.unionSet(edge.start, edge.end);
                mstEdges.add(edge);
                totalWeight += edge.weight;
            }
        }
        // MST can be formed
        if (mstEdges.size() == n - 1) {
            // Sort edges lexicographically
            Comparator<Edge> lexicographicalEdgeComparator =
                (x, y) -> x.start != y.start ? x.start - y.start : x.end - y.end;
            Collections.sort(mstEdges, lexicographicalEdgeComparator);
            for (Edge edge : mstEdges) {
                fio.println(edge);
            }
        } else {
            fio.println("impossible");
        }
        fio.close();
    }
}

class Edge implements Comparable<Edge> {

    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = Math.min(start, end);
        this.end = Math.max(start, end);
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return (start + 1) + " " + (end + 1) + " " + weight;
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

