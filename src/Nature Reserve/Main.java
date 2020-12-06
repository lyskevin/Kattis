import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int T = fio.nextInt();

        for (int k = 0; k < T; k++) {
            int N = fio.nextInt();
            int M = fio.nextInt();
            int L = fio.nextInt();
            int S = fio.nextInt();

            ArrayList<ArrayList<Tuple>> adjList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }

            HashSet<Integer> startingStations = new HashSet<>();
            for (int i = 0; i < S; i++) {
                startingStations.add(fio.nextInt() - 1);
            }

            for (int i = 0; i < M; i++) {
                int start = fio.nextInt() - 1;
                int end = fio.nextInt() - 1;
                long cost = fio.nextLong() + L;
                adjList.get(start).add(new Tuple(end, cost));
                adjList.get(end).add(new Tuple(start, cost));
            }

            PriorityQueue<Tuple> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N];
            int count = 0;
            for (Integer startingStation : startingStations) {
                visited[startingStation] = true;
                count++;
            }

            for (Integer startingStation : startingStations) {
                adjList.get(startingStation).forEach(neighbour -> {
                    if (!visited[neighbour.node]) {
                        pq.offer(neighbour);
                    }
                });
            }

            long totalCost = 0l;
            while (!pq.isEmpty() && count < N) {
                Tuple tuple = pq.poll();

                if (visited[tuple.node]) {
                    continue;
                }

                totalCost += tuple.cost;
                visited[tuple.node] = true;
                count++;

                // forEach passes the time limit but normal for loops and enhanced for loops do not
                adjList.get(tuple.node).forEach(neighbour -> {
                    if (!visited[neighbour.node]) {
                        pq.offer(neighbour);
                    }
                });
            }

            fio.println(totalCost);
        }

        fio.close();
    }
}

class Tuple implements Comparable<Tuple> {
    int node;
    long cost;

    Tuple(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
        public int compareTo(Tuple other) {
            int compare = Long.compare(this.cost, other.cost);
            if (compare != 0) {
                return compare;
            } else {
                return this.node - other.node;
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

