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
        while (!(n == 0 && m == 0)) {
            ArrayList<ArrayList<Vertex>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int start = fio.nextInt();
                int end = fio.nextInt();
                double distance = fio.nextDouble();
                adjList.get(start).add(new Vertex(end, distance));
                adjList.get(end).add(new Vertex(start, distance));
            }
            PriorityQueue<Vertex> pq = new PriorityQueue<>();
            double[] distances = new double[n];
            for (int i = 1; i < n; i++) {
                distances[i] = 100000000000.0;
            }
            pq.add(new Vertex(0, 0.0));
            // Dijkstra's algorithm
            while (!pq.isEmpty()) {
                Vertex u = pq.poll();
                for (Vertex v : adjList.get(u.intersection)) {
                    // Use sum of logarithms to calculate distance
                    // -1 is used as a multiplier because log(n) < 0, where n < 1
                    double distance = -1 * Math.log(v.distance);
                    if (distances[v.intersection] > distances[u.intersection] + distance) {
                        distances[v.intersection] = distances[u.intersection] + distance;
                        pq.offer(new Vertex(v.intersection, distance));
                    }
                }
            }
            fio.println(String.format("%.4f", Math.pow(Math.E, -1 * distances[n - 1])));
            n = fio.nextInt();
            m = fio.nextInt();
        }
        fio.close();
    }
}

class Vertex implements Comparable<Vertex> {

    int intersection;
    double distance;

    Vertex(int intersection, double distance) {
        this.intersection = intersection;
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

