import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int[][] locations = new int[n + 2][2];
        for (int i = 1; i <= n; i++) {
            locations[i][0] = fio.nextInt();
            locations[i][1] = fio.nextInt();
        }
        locations[0][0] = fio.nextInt();
        locations[0][1] = fio.nextInt();
        locations[n + 1][0] = fio.nextInt();
        locations[n + 1][1] = fio.nextInt();
        // Initialise adjacency list
        ArrayList<ArrayList<Vertex>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 2; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 2; j++) {
                double distance = ((locations[i][0] - locations[j][0]) * (locations[i][0] - locations[j][0]))
                        + ((locations[i][1] - locations[j][1]) * (locations[i][1] - locations[j][1]));
                adjList.get(i).add(new Vertex(j, distance));
                adjList.get(j).add(new Vertex(i, distance));
            }
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(0, 0.0));
        double[] distances = new double[n + 2];
        int[] predecessors = new int[n + 2];
        predecessors[0] = -1;
        for (int i = 1; i < n + 2; i++) {
            distances[i] = 1000000000000000.0;
            predecessors[i] = -1;
        }
        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Vertex u = pq.poll();
            if (u.distance > distances[u.location]) {
                continue;
            }
            if (u.location == n + 1) {
                break;
            }
            for (Vertex v : adjList.get(u.location)) {
                if (distances[v.location] > distances[u.location] + v.distance) {
                    distances[v.location] = distances[u.location] + v.distance;
                    pq.offer(new Vertex(v.location, distances[v.location]));
                    // Store predecessors
                    predecessors[v.location] = u.location;
                }
            }
        }
        int location = n + 1;
        ArrayList<Integer> shortestPathReverse = new ArrayList<>();
        // Reconstruct path
        while (predecessors[location] != -1) {
            location = predecessors[location];
            shortestPathReverse.add(location);
        }
        // Print path
        if (shortestPathReverse.size() == 1) {
            fio.println("-");
        } else {
            for (int i = shortestPathReverse.size() - 2; i >= 0; i--) {
                fio.println(shortestPathReverse.get(i) - 1);
            }
        }
        fio.close();
    }
}

class Vertex implements Comparable<Vertex> {

    int location;
    double distance;

    Vertex(int location, double distance) {
        this.location = location;
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(this.distance, other.distance);
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

