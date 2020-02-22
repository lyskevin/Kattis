import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int q = fio.nextInt();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < q; i++) {
            String s = fio.next();
            if (s.equals("s")) {
                int a = fio.nextInt();
                fio.println(uf.size[uf.findSet(a - 1)]);
            } else {
                int a = fio.nextInt();
                int b = fio.nextInt();
                uf.unionSet(a - 1, b - 1);
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

