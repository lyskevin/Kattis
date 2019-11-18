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
        int a = fio.nextInt() - 1;
        int b = fio.nextInt() - 1;
        int k = fio.nextInt();
        int g = fio.nextInt();
        ArrayList<Integer> georgeIntersections = new ArrayList<>();
        for (int i = 0; i < g; i++) {
            georgeIntersections.add(fio.nextInt() - 1);
        }
        ArrayList<HashMap<Integer, Road>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            int intersection1 = fio.nextInt() - 1;
            int intersection2 = fio.nextInt() - 1;
            int distance = fio.nextInt();
            adjList.get(intersection1).put(intersection2, new Road(intersection1, intersection2, distance));
            adjList.get(intersection2).put(intersection1, new Road(intersection2, intersection1, distance));
        }
        if (g >= 2) {
            int time = 0;
            int intersection1 = georgeIntersections.get(0);
            for (int i = 0; i < g - 1; i++) {
                int intersection2 = georgeIntersections.get(i + 1);
                Road road1 = adjList.get(intersection1).get(intersection2);
                Road road2 = adjList.get(intersection2).get(intersection1);
                int distance = road1.distance;
                road1.isClosed = true;
                road1.closeStartTime = time;
                road1.closeEndTime = time + distance;
                road2.isClosed = true;
                road2.closeStartTime = time;
                road2.closeEndTime = time + distance;
                time += distance;
                intersection1 = intersection2;
            }
        }
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = 1000000000;
        }
        PriorityQueue<Intersection> intersectionPQ = new PriorityQueue<>();
        intersectionPQ.offer(new Intersection(a, k));
        distances[a] = k;
        while (!intersectionPQ.isEmpty()) {
            Intersection intersection = intersectionPQ.poll();
            int label = intersection.label;
            for (Road road : adjList.get(intersection.label).values()) {
                if (road.isClosed) {
                    if ((intersection.distance < road.closeStartTime || intersection.distance >= road.closeEndTime)
                            && distances[road.end] > distances[label] + road.distance) {
                        distances[road.end] = distances[label] + road.distance;
                        intersectionPQ.offer(new Intersection(road.end, distances[road.end]));
                    } else if ((intersection.distance >= road.closeStartTime && intersection.distance < road.closeEndTime)
                            && distances[road.end] > road.closeEndTime + road.distance) {
                        distances[road.end] = road.closeEndTime + road.distance;
                        intersectionPQ.offer(new Intersection(road.end, distances[road.end]));
                    }
                } else if (distances[road.end] > distances[label] + road.distance) {
                    distances[road.end] = distances[label] + road.distance;
                    intersectionPQ.offer(new Intersection(road.end, distances[road.end]));
                }
            }
        }
        fio.println(distances[b] - k);
        fio.close();
    }
}

class Intersection implements Comparable<Intersection> {

    int label;
    int distance;

    Intersection(int label, int distance) {
        this.label = label;
        this.distance = distance;
    }

    @Override
    public int compareTo(Intersection other) {
        return this.distance - other.distance;
    }

}

class Road {

    int start;
    int end;
    int distance;
    boolean isClosed;
    int closeStartTime;
    int closeEndTime;

    Road(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.isClosed = false;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof Road)) {
            return false;
        } else {
            Road otherRoad = (Road) other;
            return this.start == otherRoad.start
                    && this.end == otherRoad.end
                    && this.distance == otherRoad.distance;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, distance);
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

