import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int V = fio.nextInt();
        int E = fio.nextInt();
        int C = fio.nextInt();
        int K = fio.nextInt();
        int M = fio.nextInt();

        ArrayList<ArrayList<State>> adjList = new ArrayList<>();
        long[] distances = new long[V];
        for (int i = 0; i < V; i++) {
            distances[i] = INF;
            adjList.add(new ArrayList<>());
        }

        
        for (int i = 0; i < E; i++) {
            int u = fio.nextInt() - 1;
            int v = fio.nextInt() - 1;
            long w = fio.nextLong();
            adjList.get(u).add(new State(v, w));
            adjList.get(v).add(new State(u, w));
        }

        HashSet<Integer> clearings = new HashSet<>();
        for (int i = 0; i < C; i++) {
            clearings.add(fio.nextInt() - 1);
        }

        PriorityQueue<Long> walkingDistances = new PriorityQueue<>();
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(0, 0l));
        distances[0] = 0l;
        
        // Dijkstra's
        while (!pq.isEmpty()) {
            State state = pq.poll();
            
            // Lazy DS
            if (state.distance > distances[state.vertex]) {
                continue;
            }

            // At a clearing
            if (clearings.contains(state.vertex)) {
                walkingDistances.offer(state.distance * 2);
            }

            for (State neighbour : adjList.get(state.vertex)) {
                if (distances[neighbour.vertex] > state.distance + neighbour.distance) {
                    distances[neighbour.vertex] = state.distance + neighbour.distance;
                    pq.offer(new State(neighbour.vertex, distances[neighbour.vertex]));
                }
            }
        }

        if (walkingDistances.size() >= K || walkingDistances.size() >= M) {
            // Polling min(K, M) - 1 times will not TLE because it is definitely a lot smaller than 2B
            // Walking distances will have max |V| <= 20K entries and size of walking distances <= min(K, M)
            int toPoll = Math.min(K, M) - 1;  
            for (int i = 0; i < toPoll; i++) {
                walkingDistances.poll();
            }
            fio.println(walkingDistances.peek());
        } else {
            fio.println(-1);
        }

        fio.close();
    }
}

class State implements Comparable<State> {
    int vertex;
    long distance;
   
    State(int vertex, long distance) {
        this.vertex = vertex;
        this.distance = distance;
    } 

    @Override
    public int compareTo(State other) {
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

