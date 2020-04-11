import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int r = fio.nextInt();
        int c = fio.nextInt();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = fio.nextLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        UnionFind uf = new UnionFind(r * c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i < r - 1 && grid[i][j] == grid[i + 1][j]) {
                    uf.unionSet(i * c + j, (i + 1) * c + j);
                }
                if (j < c - 1 && grid[i][j] == grid[i][j + 1]) {
                    uf.unionSet(i * c + j, i * c + j + 1);
                }
            }
        }
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            int r1 = fio.nextInt() - 1;
            int c1 = fio.nextInt() - 1;
            int r2 = fio.nextInt() - 1;
            int c2 = fio.nextInt() - 1;
            if (grid[r1][c1] == grid[r2][c2]) {
                fio.println(uf.isSameSet(r1 * c + c1, r2 * c + c2) ? grid[r1][c1] == '0' ? "binary" : "decimal" : "neither");
            } else {
                fio.println("neither");
            }
        }
        fio.close();
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

}

