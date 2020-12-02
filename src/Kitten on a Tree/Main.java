import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            adjList.add(new ArrayList<>());
        }

        FastIO fio = new FastIO();

        int target = fio.nextInt();
        String[] children = fio.nextLine().split(" ");
        int n = Integer.parseInt(children[0]);
        while (n > -1) {
            for (int i = 1; i < children.length; i++) {
                // Reverse the edges
                adjList.get(Integer.parseInt(children[i])).add(n);
            }
            children = fio.nextLine().split(" ");
            n = Integer.parseInt(children[0]);
        }

        dfs(target, fio);

        fio.close();
    }

    private static void dfs(int node, FastIO fio) {
        fio.print(node);
        
        if (adjList.get(node).isEmpty()) {
            fio.println();
        } else {
            fio.print(" ");
            dfs(adjList.get(node).get(0), fio);
        }

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

