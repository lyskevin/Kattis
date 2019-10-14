import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            int f = fio.nextInt();
            HashMap<String, Integer> uniqueIDs = new HashMap<>();
            int id = 0;
            UnionFind uf = new UnionFind(f + 1);
            for (int j = 0; j < f; j++) {
                String s1 = fio.next();
                String s2 = fio.next();
                if (!uniqueIDs.containsKey(s1)) {
                    uniqueIDs.put(s1, id);
                    id++;
                }
                if (!uniqueIDs.containsKey(s2)) {
                    uniqueIDs.put(s2, id);
                    id++;
                }
                uf.unionSet(uniqueIDs.get(s1).intValue(), uniqueIDs.get(s2).intValue());
                fio.println(uf.getSize(uniqueIDs.get(s1).intValue()));
            }
        }
        fio.close();
    }
}

class UnionFind {

    public int[] p;
    public int[] rank;
    public int[] size;
    public int numSets;

    public UnionFind(int n) {
        p = new int[n];
        rank = new int[n];
        size = new int[n];
        numSets = n;
        for (int i = 0; i < n; i++) {
            p[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int findSet(int i) { 
        if (p[i] == i) return i;
        else {
            p[i] = findSet(p[i]);
            return p[i]; 
        } 
    }

    public Boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) { 
        if (!isSameSet(i, j)) { 
            numSets--; 
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) {
                p[y] = x;
                size[x] = size[x] + size[y];
            }
            else { 
                p[x] = y;
                size[y] = size[x] + size[y];
                if (rank[x] == rank[y]) {
                    rank[y] = rank[y] + 1;
                }
            } 
        } 
    }

    public int numDisjointSets() {
        return numSets;
    }

    public void addToSet(int i) {
        size[findSet(i)] -= 1;
    }

    public boolean canAddToSet(int i) {
        return size[findSet(i)] > 0;
    }

    public int getSize(int i) {
        return size[findSet(i)];
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

