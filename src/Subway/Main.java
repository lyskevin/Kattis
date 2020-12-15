import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final double INF = 1000000000.0;
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        Coordinates start = new Coordinates(fio.nextInt(), fio.nextInt());
        Coordinates end = new Coordinates(fio.nextInt(), fio.nextInt());

        HashMap<Coordinates, HashSet<Coordinates>> adjList = new HashMap<>();

        HashSet<Coordinates> allLocations = new HashSet<>();
        allLocations.add(start);
        allLocations.add(end);

        HashMap<Coordinates, Double> times = new HashMap<>();
        times.put(start, 0.0);
        times.put(end, INF);

        while (true) {
            try {
                String[] input = fio.nextLine().split(" ");
                for (int i = 0; i < input.length - 4; i += 2) {
                    Coordinates first = new Coordinates(Integer.parseInt(input[i]), Integer.parseInt(input[i + 1]));
                    Coordinates second = new Coordinates(Integer.parseInt(input[i + 2]), Integer.parseInt(input[i + 3]));
                    if (!adjList.containsKey(first)) {
                        adjList.put(first, new HashSet<>());
                    }
                    adjList.get(first).add(second);
                    if (!adjList.containsKey(second)) {
                        adjList.put(second, new HashSet<>());
                    }
                    adjList.get(second).add(first);
                    if (!times.containsKey(first)) {
                        times.put(first, INF);
                    }
                    if (!times.containsKey(second)) {
                        times.put(second, INF);
                    }
                    allLocations.add(first);
                    allLocations.add(second);
                }
            } catch (NullPointerException e) {
                break;
            }
        }


        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(start, 0.0));

        while (!pq.isEmpty()) {
            State state = pq.poll();

            if (state.coordinates.equals(end)) {
                break;
            }

            if (adjList.containsKey(state.coordinates)) {
                for (Coordinates trainStation : adjList.get(state.coordinates)) {
                    double time = state.time + (state.coordinates.distanceTo(trainStation) / 40000.0) * 60;
                    if (times.get(trainStation) > time) {
                        times.put(trainStation, time);
                        pq.offer(new State(trainStation, time));
                    }
                }
            }

            for (Coordinates location : allLocations) {
                double time = state.time + (state.coordinates.distanceTo(location) / 10000.0) * 60;
                if (times.get(location) > time) {
                    times.put(location, time);
                    pq.offer(new State(location, time));
                }
            }
        }

        fio.println(Math.round(times.get(end)));

        fio.close();
    }
}

class State implements Comparable<State> {
    Coordinates coordinates;
    double time;

    State(Coordinates coordinates, double time) {
        this.coordinates = coordinates;
        this.time = time;
    }

    @Override   
        public int compareTo(State other) {
            return Double.compare(this.time, other.time);
        }
}

class Coordinates {
    int x;
    int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
        public boolean equals(Object other) {
            Coordinates otherCoordinates = (Coordinates) other;
            return this.x == otherCoordinates.x && this.y == otherCoordinates.y;
        }

    @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    public double distanceTo(Coordinates other) {
        return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
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

