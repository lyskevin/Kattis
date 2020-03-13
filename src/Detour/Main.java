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
        HashMap<Integer, HashSet<Tuple>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            int a = fio.nextInt();
            int b = fio.nextInt();
            long d = fio.nextLong();
            adjList.get(a).add(new Tuple(b, d));
            adjList.get(b).add(new Tuple(a, d));
        }
        int[] predecessors = new int[n];
        long[] distances = new long[n];
        for (int i = 0; i < n; i++) {
            predecessors[i] = -1;
            distances[i] = 1000000000000000000l;
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        distances[1] = 0l;
        pq.add(new Tuple(1, 0l));
        while (!pq.isEmpty()) {
            Tuple u = pq.poll();
            if (u.distance > distances[u.location]) {
                continue;
            }
            for (Tuple v : adjList.get(u.location)) {
                if (distances[v.location] > distances[u.location] + v.distance) {
                    distances[v.location] = distances[u.location] + v.distance;
                    predecessors[v.location] = u.location;
                    pq.add(new Tuple(v.location, distances[v.location]));
                }
            }
        }
        int location = 0;
        while (predecessors[location] != -1) {
            adjList.get(location).remove(new Tuple(predecessors[location], 0l));
            location = predecessors[location];
        }
        predecessors = new int[n];
        for (int i = 0; i < n; i++) {
            predecessors[i] = -1;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> bfsQueue = new LinkedList<>();
        visited[0] = true;
        bfsQueue.add(0);
        while (!bfsQueue.isEmpty()) {
            Integer u = bfsQueue.poll();
            for (Tuple v : adjList.get(u)) {
                if (!visited[v.location]) {
                    visited[v.location] = true;
                    predecessors[v.location] = u;
                    bfsQueue.add(v.location);
                }
            }
        }
        if (!visited[1]) {
            fio.println("impossible");
        } else {
            ArrayList<Integer> shortestPathReverse = new ArrayList<>();
            shortestPathReverse.add(1);
            location = 1;
            while (predecessors[location] != -1) {
                location = predecessors[location];
                shortestPathReverse.add(location);
            }
            fio.print(shortestPathReverse.size());
            for (int i = shortestPathReverse.size() - 1; i >= 0; i--) {
                fio.print(" " + shortestPathReverse.get(i));
            }
            fio.println();
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

    @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            } else if (!(other instanceof Tuple)) {
                return false;
            } else {
                return this.location == ((Tuple) other).location;
            }
        }

    @Override
        public int hashCode() {
            return Objects.hash(location);
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

