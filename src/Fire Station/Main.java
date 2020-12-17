import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int INF = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int f = fio.nextInt();
            int n = fio.nextInt();

            ArrayList<ArrayList<Tuple>> adjList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                adjList.add(new ArrayList<>());
            }

            HashSet<Integer> fireStations = new HashSet<>();
            for (int j = 0; j < f; j++) {
                fireStations.add(fio.nextInt() - 1);
            }

            while (true) {
                try {
                    String input = fio.nextLine();
                    if (input.equals("")) {
                        break;
                    }
                    String[] details = input.split(" ");
                    int u = Integer.parseInt(details[0]) - 1;
                    int v = Integer.parseInt(details[1]) - 1;
                    int d = Integer.parseInt(details[2]);
                    adjList.get(u).add(new Tuple(v, d));
                    adjList.get(v).add(new Tuple(u, d));
                } catch (NullPointerException e) {
                    break;
                }
            }

            int result = Integer.MAX_VALUE;
            int node = 0;

            for (int j = 0; j < n; j++) {
                if (fireStations.contains(j)) {
                    continue;
                }

                int[] distances = new int[n];
                for (int k = 0; k < n; k++) {
                    distances[k] = INF;
                }

                PriorityQueue<Tuple> pq = new PriorityQueue<>();
                // Connect imaginary  source to all fire stations
                for (int fireStation : fireStations) {
                    pq.offer(new Tuple(fireStation, 0));
                    distances[fireStation] = 0;
                }

                // Connect imaginary source to fire station that we want to test
                pq.offer(new Tuple(j, 0));
                distances[j] = 0;
    
                int maxDistance = 0;

                while (!pq.isEmpty()) {
                    Tuple tuple = pq.poll();

                    if (tuple.distance > distances[tuple.node]) {
                        continue;
                    }

                    maxDistance = Math.max(maxDistance, tuple.distance);

                    for (Tuple neighbour : adjList.get(tuple.node)) {
                        if (distances[neighbour.node] > tuple.distance + neighbour.distance) {
                            distances[neighbour.node] = tuple.distance + neighbour.distance;
                            pq.offer(new Tuple(neighbour.node, distances[neighbour.node]));
                        }
                    }
                }

                if (maxDistance < result) {
                    node = j;
                    result = maxDistance;
                }
            }

            fio.println(node + 1);
        }

        fio.close();
    }
}

class Tuple implements Comparable<Tuple> {
    int node;
    int distance;

    Tuple(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
        public int compareTo(Tuple other) {
            return this.distance - other.distance;
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

