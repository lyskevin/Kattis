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
        ArrayList<ArrayList<Street>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Read inputs
        for (int i = 0; i < m; i++) {
            int start = fio.nextInt() - 1;
            int end = fio.nextInt() - 1;
            int distance = fio.nextInt();
            String colour = fio.next();
            adjList.get(start).add(new Street(end, distance, colour));
            adjList.get(end).add(new Street(start, distance, colour));
        }

        // Initialise distances array; 128 = 2^7
        int[][] distances = new int[n][128];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 128; j++) {
                distances[i][j] = 1000000000;
            }
        }

        // Initialise priority queue and starting state of distances array
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(0, 0, 0));
        distances[0][0] = 0;
    
        // Dijkstra's
        while (!pq.isEmpty()) {
            State state = pq.poll();

            // Stop here
            if (state.location == 0 && state.bitmask == 127) {
                break;
            }

            // Lazy data structure
            if (state.distance == distances[state.location][state.bitmask]) {
                for (Street street : adjList.get(state.location)) {
                    int newBitmask = state.bitmask | getColourBitmask(street.colour);
                    if (state.distance + street.distance < distances[street.end][newBitmask]) {
                        distances[street.end][newBitmask] = state.distance + street.distance;
                        pq.offer(new State(street.end, newBitmask, state.distance + street.distance));
                    }
                }
            }
        }

        fio.println(distances[0][127]);
        fio.close();
    }

    // Bitmask: ROYGBIV
    private static int getColourBitmask(String colour) {
        switch (colour) {
            case "R":
                return 1 << 6;
            case "O":
                return 1 << 5;
            case "Y":
                return 1 << 4;
            case "G":
                return 1 << 3;
            case "B":
                return 1 << 2;
            case "I":
                return 1 << 1;
            case "V":
                return 1;
            default:
                return 0;
        }
    }
}

class State implements Comparable<State> {

    int location;
    int bitmask;
    int distance;

    State(int location, int bitmask, int distance) {
        this.location = location;
        this.bitmask = bitmask;
        this.distance = distance;
    }

    @Override
    public int compareTo(State other) {
        return this.distance - other.distance;
    }

}

class Street {

    int end;
    int distance;
    String colour;

    Street(int end, int distance, String colour) {
        this.end = end;
        this.distance = distance;
        this.colour = colour;
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

