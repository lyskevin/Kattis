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
        int p = fio.nextInt();
        
        HashSet<Integer> insecureBuildings = new HashSet<>();
        for (int i = 0; i < p; i++) {
            insecureBuildings.add(fio.nextInt() - 1);
        }

        // Always 0 if only 1 building
        if (n == 1) {
            fio.println(0);
            fio.close();
            System.exit(0);
        }

        if (n == 2) {
            // 2 buildings are connected; does not matter if they are both insecure
            if (m == 1) {
                fio.nextInt();
                fio.nextInt();
                fio.println(fio.nextInt());
            } else {
                // Buildings are not connected so impossible to form the network
                fio.println("impossible");
            }
            fio.close();
            System.exit(0);
        }

        PriorityQueue<Edge> secureEdges = new PriorityQueue<>();
        PriorityQueue<Edge> insecureEdges = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            int start = fio.nextInt() - 1;
            int end = fio.nextInt() - 1;
            int cost = fio.nextInt();

            // Cannot use this edge as one of the insecure buildings will be a non-leaf node
            if (insecureBuildings.contains(start) && insecureBuildings.contains(end)) {
                continue;
            }

            if (insecureBuildings.contains(start) || insecureBuildings.contains(end)) {
                insecureEdges.offer(new Edge(start, end, cost));
            } else {
                secureEdges.offer(new Edge(start, end, cost));
            }
        }

        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int mstSize = 1;

        // Form MST with only secure buildings
        while (!secureEdges.isEmpty() && mstSize < n - insecureBuildings.size()) {
            Edge edge = secureEdges.poll();
            if (!uf.isSameSet(edge.start, edge.end)) {
                mstSize++;
                totalCost += edge.cost;
                uf.unionSet(edge.start, edge.end);
            }
        }

        // Check that MST can be formed using secure buildings
        if (mstSize < n - insecureBuildings.size()) {
            fio.println("impossible");
            fio.close();
            System.exit(0);
        }

        // Form MST with insecure buildings, which will all become leaf nodes
        while(!insecureEdges.isEmpty() && mstSize < n) {
            Edge edge = insecureEdges.poll();

            if (!uf.isSameSet(edge.start, edge.end)) {
                mstSize++;
                totalCost += edge.cost;
                uf.unionSet(edge.start, edge.end);
            }
        }

        // Check that MST includes all buildings
        if (mstSize < n) {
            fio.println("impossible");
        } else {
            fio.println(totalCost);
        }

        fio.close();
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int cost;

    Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
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

