import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            int m = fio.nextInt();
            Island[] islands = new Island[m];
            for (int j = 0; j < m; j++) {
                islands[j] = new Island(fio.nextDouble(), fio.nextDouble());
            }
            PriorityQueue<Bridge> bridgePQ = new PriorityQueue<>();
            for (int j = 0; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    bridgePQ.offer(new Bridge(j, k, islands[j].distanceTo(islands[k])));
                }
            }
            int numberOfBridges = 0;
            double totalDistance = 0.0;
            UnionFind uf = new UnionFind(m);
            while(!bridgePQ.isEmpty() && numberOfBridges < m - 1) {
                Bridge bridge = bridgePQ.poll();
                if (!uf.isSameSet(bridge.island1, bridge.island2)) {
                    uf.unionSet(bridge.island1, bridge.island2);
                    numberOfBridges++;
                    totalDistance += bridge.distance;
                }
            }
            fio.println(totalDistance);
        }
        fio.close();
    }
}

class Bridge implements Comparable<Bridge> {

    int island1;
    int island2;
    double distance;

    Bridge(int island1, int island2, double distance) {
        this.island1 = island1;
        this.island2 = island2;
        this.distance = distance;
    }

    @Override
    public int compareTo(Bridge other) {
        return Double.compare(this.distance, other.distance);
    }

}

class Island {
    
    double x;
    double y;

    Island(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Island other) {
        double xDistance = this.x - other.x;
        double yDistance = this.y - other.y;
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
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

