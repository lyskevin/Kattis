import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        // Store locations' item data
        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = fio.nextInt();
        }
        // Build adjacency matrix
        int m = fio.nextInt();
        int[][] roads = new int[n + 1][n + 1];
        for (int i = 0; i < m ; i++) {
            int location1 = fio.nextInt();
            int location2 = fio.nextInt();
            int distance = fio.nextInt();
            roads[location1][location2] = distance;
            roads[location2][location1] = distance;
        }
        // Run Dijkstra's
        PriorityQueue<PathCost> pq = new PriorityQueue<>();
        pq.offer(new PathCost(1, 0, items[1]));
        PathCost[] pathCosts = new PathCost[n + 1];
        while (!pq.isEmpty()) {
            PathCost pathCost = pq.poll();
            if (pathCosts[pathCost.location] == null) {
                pathCosts[pathCost.location] = pathCost;
                if (pathCost.location == n) {
                    break;
                }
                for (int i = 1; i <= n; i++) {
                    if (roads[pathCost.location][i] > 0) {
                        pq.offer(new PathCost(i, pathCost.distance + roads[pathCost.location][i],
                                pathCost.numberOfItems + items[i]));
                    }
                }
            }
        }
        if (pathCosts[n] != null) {
            fio.println(pathCosts[n].distance + " " + pathCosts[n].numberOfItems);
        } else {
            fio.println("impossible");
        }
        fio.close();
    }
}

class PathCost implements Comparable<PathCost> {

    int location;
    int distance;
    int numberOfItems;

    PathCost(int location, int distance, int numberOfItems) {
        this.location = location;
        this.distance = distance;
        this.numberOfItems = numberOfItems;
    }

    // Path cost weighted by minimum distance, then by maximum number of items
    @Override
    public int compareTo(PathCost other) {
        if (this.distance != other.distance) {
            return this.distance - other.distance;
        } else {
            return other.numberOfItems - this.numberOfItems;
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

