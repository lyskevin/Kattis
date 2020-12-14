import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int INF = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int m = fio.nextInt();

        ArrayList<ArrayList<Tuple>> adjList = new ArrayList<>();
        int[] fuelPrices = new int[n];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            fuelPrices[i] = fio.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int u = fio.nextInt();
            int v = fio.nextInt();
            int d = fio.nextInt();
            adjList.get(u).add(new Tuple(v, d));
            adjList.get(v).add(new Tuple(u, d));
        }

        int q = fio.nextInt();
        for (int i = 0; i < q; i++) {
            int c = fio.nextInt();
            int s = fio.nextInt();
            int e = fio.nextInt();

            int[][] totalPrices = new int[n][c + 1];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= c; k++) {
                    totalPrices[j][k] = INF;
                }
            }
            totalPrices[s][0] = 0;

            PriorityQueue<State> pq = new PriorityQueue<>();
            pq.offer(new State(s, 0, 0));
            boolean isReachable = false;
            int result = INF;

            while (!pq.isEmpty()) {
                State state = pq.poll();

                // Reached the end
                if (state.location == e) {
                    isReachable = true;
                    result = state.price;
                    break;
                }

                // Lazy DS
                if (state.price > totalPrices[state.location][state.fuel]) {
                    continue;
                }

                for (Tuple neighbour : adjList.get(state.location)) {
                    for (int j = Math.max(neighbour.distance, state.fuel); j <= c; j++) {
                        int remainingFuel = j - neighbour.distance;
                        int price = j > state.fuel ? (j - state.fuel) * fuelPrices[state.location] : 0;
                        if (state.price + price < totalPrices[neighbour.location][remainingFuel]) {
                            totalPrices[neighbour.location][remainingFuel] = state.price + price;
                            pq.offer(new State(neighbour.location, remainingFuel, state.price + price));
                        }
                    }
                }
            }

            if (isReachable) {
                fio.println(result);
            } else {
                fio.println("impossible");
            }
        }

        fio.close();
    }
}

class Tuple {
    int location;
    int distance;

    Tuple(int location, int distance) {
        this.location = location;
        this.distance = distance;
    }
}

class State implements Comparable<State> {
    int location;
    int fuel;
    int price;

    State(int location, int fuel, int price) {
        this.location = location;
        this.fuel = fuel;
        this.price = price;
    }

    @Override
        public int compareTo(State other) {
            return this.price - other.price;
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

