import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int p = fio.nextInt();
        int t = fio.nextInt();
        ArrayList<TreeSet<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            sets.add(new TreeSet<Integer>());
        }
        while (true) {
            try {
                for (int i = 0, n = t * p; i < n; i++) {
                    int a = fio.nextInt();
                    int b = fio.nextInt();
                    sets.get(a - 1).add(b);
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        UnionFind uf = new UnionFind(p);
        for (int i = 0; i < p; i++) {
            for (int j = i + 1; j < p; j++) {
                if (!uf.isSameSet(i, j) && sets.get(i).equals(sets.get(j))) {
                    uf.unionSet(i, j);
                }
            }
        }
        fio.println(uf.numDisjointSets());
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

