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

        // Initialise adjacency list
        ArrayList<ArrayList<Tuple>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = fio.nextInt();
            int b = fio.nextInt();
            long d = fio.nextLong();
            adjList.get(a).add(new Tuple(b, d));
            adjList.get(b).add(new Tuple(a, d));
        }

        // Run Dijkstra's algorithm from Amsterdam
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        long[] distances = new long[n];
        int[] predecessors = new int[n];
        pq.add(new Tuple(1, 0l));
        for (int i = 0; i < n; i++) {
            distances[i] = 1000000000000000000l;
            predecessors[i] = -1;
        }
        distances[1] = 0l;
        while (!pq.isEmpty()) {
            Tuple u = pq.poll();
            if (distances[u.location] == u.distance) {
                for (Tuple v : adjList.get(u.location)) {
                    if (distances[v.location] > distances[u.location] + v.distance) {
                        distances[v.location] = distances[u.location] + v.distance;
                        predecessors[v.location] = u.location;
                        pq.add(new Tuple(v.location, distances[v.location]));
                    }
                }
            }
        }

        // Generate and store banned edges from all vertices
        HashMap<Integer, HashSet<Integer>> bannedEdges = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int location = i;
                visited[location] = true;
                while (predecessors[location] != -1) {
                    if (!bannedEdges.containsKey(location)) {
                        bannedEdges.put(location, new HashSet<>());
                    }
                    bannedEdges.get(location).add(predecessors[location]);
                    location = predecessors[location];
                    visited[location] = true;
                }
            }
        }

        // Run BFS from Delft while excluding banned edges from use
        Queue<Integer> bfsQueue = new LinkedList<>();
        visited = new boolean[n];
        predecessors = new int[n];
        for (int i = 0; i < n; i++) {
            predecessors[i] = -1;
        }
        bfsQueue.offer(0);
        visited[0] = true;
        while (!bfsQueue.isEmpty()) {
            Integer u = bfsQueue.poll();
            for (Tuple v : adjList.get(u)) {
                if (bannedEdges.containsKey(u) && bannedEdges.get(u).contains(v.location)) {
                    continue;
                } else if (!visited[v.location]) {
                    visited[v.location] = true;
                    bfsQueue.offer(v.location);
                    predecessors[v.location] = u;
                }
            }
        }

        // Reconstruct predecessor path from Delft to Amsterdam which excludes the banned edges
        ArrayList<Integer> reversePath = new ArrayList<>();
        int location = 1;
        reversePath.add(1);
        while (predecessors[location] != -1) {
            location = predecessors[location];
            reversePath.add(location);
        }

        // Print path details if possible
        if (visited[1]) {
            fio.print(reversePath.size());
            for (int i = reversePath.size() - 1; i >= 0; i--) {
                fio.print(" " + reversePath.get(i));
            }
            fio.println();
        } else {
            fio.println("impossible");
        }
        fio.close();

    }
}

class Tuple implements Comparable<Tuple> {

    int location;
    long distance;

    Tuple(int location, long distance) {
        this.location = location;
        this.distance = distance;
    }

    @Override
        public int compareTo(Tuple other) {
            return Long.compare(this.distance, other.distance);
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

