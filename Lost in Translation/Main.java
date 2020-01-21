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
        // Store language text to integer mappings
        HashMap<String, Integer> languageMappings = new HashMap<>();
        languageMappings.put("English", 0);
        for (int i = 1; i <= n; i++) {
            languageMappings.put(fio.next(), i);
        }
        // Get adjacency list (using Vertex for convenience)
        ArrayList<ArrayList<Vertex>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int language1 = languageMappings.get(fio.next());
            int language2 = languageMappings.get(fio.next());
            long cost = fio.nextLong();
            adjList.get(language1).add(new Vertex(language2, 0, cost));
            adjList.get(language2).add(new Vertex(language1, 0, cost));
        }
        // Perform BFS
        Queue<Vertex> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Vertex(0, 0, 0l));
        Vertex[] visited = new Vertex[n + 1];
        visited[0] = new Vertex(0, 0, 0l);
        long[] edgeCosts = new long[n + 1];
        while (!bfsQueue.isEmpty()) {
            Vertex u = bfsQueue.poll();
            for (Vertex v : adjList.get(u.language)) {
                // Store the minimum cost to translate the text to a given language from any other language
                if (visited[v.language] == null
                        || (visited[v.language].distance >= u.distance + 1
                        && edgeCosts[v.language] > v.cost)) {
                    Vertex next = new Vertex(v.language, u.distance + 1, u.cost + v.cost);
                    visited[v.language] = next;
                    bfsQueue.offer(next);
                    edgeCosts[v.language] = v.cost;
                }
            }
        }
        long totalCost = 0l;
        boolean hasSolution = true;
        for (int i = 1; i < n + 1 && hasSolution; i++) {
            // Index i not visited ==> BFS spanning tree cannot be formed; i.e. some languages are not covered
            if (visited[i] == null) {
                hasSolution = false;
            }
            totalCost += edgeCosts[i];
        }
        if (hasSolution) {
            fio.println(totalCost);
        } else {
            fio.println("Impossible");
        }
        fio.close();
    }
}

class Vertex {

    int language;
    int distance;
    long cost;

    Vertex(int language, int distance, long cost) {
        this.language = language;
        this.distance = distance;
        this.cost = cost;
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

