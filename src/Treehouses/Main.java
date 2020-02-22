import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int e = fio.nextInt();
        int p = fio.nextInt();
        // Read and store points
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(i, fio.nextDouble(), fio.nextDouble());
        }
        UnionFind uf = new UnionFind(n);
        // Union sets with trees which are close to the ground
        for (int i = 0; i < e - 1; i++) {
            uf.unionSet(i, i + 1);
        }
        // Union sets with trees which are connected by cable
        for (int i = 0; i < p; i++) {
            uf.unionSet(fio.nextInt() - 1, fio.nextInt() - 1);
        }
        // Store edges
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!uf.isSameSet(i, j)) {
                    pq.add(new Edge(points[i], points[j], points[i].distanceTo(points[j])));
                }
            }
        }
        // Run Kruskal's algorithm to connect the unconnected trees to form an MST
        double total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (!uf.isSameSet(edge.start.id, edge.end.id)) {
                total += edge.distance;
                uf.unionSet(edge.start.id, edge.end.id);
            }
        }
        fio.println(total);
        fio.close();
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

class Edge implements Comparable<Edge> {

    Point start;
    Point end;
    double distance;

    Edge(Point start, Point end, double distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.distance, other.distance);
    }

}

class Point {

    int id;
    double x;
    double y;

    Point(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point other) {
        return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
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

