import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();  // no. of cities
        int m = fio.nextInt();  // no. of roads
        int f = fio.nextInt();  // no. of flights
        int s = fio.nextInt();  // start
        int t = fio.nextInt();  // end
        ArrayList<ArrayList<Edge>> roadAdjList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> flightAdjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            roadAdjList.add(new ArrayList<>());
            flightAdjList.add(new ArrayList<>());
        }
        // Initialise roads
        for (int i = 0; i < m; i++) {
            int start = fio.nextInt();
            int end = fio.nextInt();
            int distance = fio.nextInt();
            roadAdjList.get(start).add(new Edge(start, end, distance));
            roadAdjList.get(end).add(new Edge(end, start, distance));
        }
        // Initialise flights
        for (int i = 0; i < f; i++) {
            flightAdjList.get(fio.nextInt()).add(fio.nextInt());
        }
        long[] distances = new long[n];
        for (int i = 0; i < n; i++) {
            distances[i] = 1000000000000000000l;
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(s, 0l, false));
        distances[s] = 0l;
        // Dijkstra's
        while (!pq.isEmpty()) {
            Vertex u = pq.poll();
            if (u.city == t) {
                break;
            }
            // Use roads
            for (Edge edge : roadAdjList.get(u.city)) {
                if (distances[edge.end] > u.distance + edge.distance) {
                    distances[edge.end] = u.distance + edge.distance;
                    pq.offer(new Vertex(edge.end, u.distance + edge.distance, u.ticketUsed));
                }
            }
            // Use flight (if applicable) provided that ticket has not been used yet
            if (!u.ticketUsed) {
                for (Integer city : flightAdjList.get(u.city)) {
                    if (distances[city] > u.distance) {
                        distances[city] = u.distance;
                        pq.offer(new Vertex(city, u.distance, true));
                    }
                }
            }
        }
        fio.println(distances[t]);
        fio.close();
    }
}

class Vertex implements Comparable<Vertex> {

    int city;
    long distance;
    boolean ticketUsed;

    Vertex(int city, long distance, boolean ticketUsed) {
        this.city = city;
        this.distance = distance;
        this.ticketUsed = ticketUsed;
    }

    @Override
    public int compareTo(Vertex other) {
        return Long.compare(this.distance, other.distance);
    }

}

class Edge {

    int start;
    int end;
    int distance;

    Edge(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
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

