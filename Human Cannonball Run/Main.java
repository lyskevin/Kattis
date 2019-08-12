import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.lang.Comparable;

/**
 * @author lyskevin
 */
public class Main {

    private static final double INF = 1000000000.0;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        Coordinates source = new Coordinates(fr.nextDouble(), fr.nextDouble(),
            false);
        Coordinates destination =
            new Coordinates(fr.nextDouble(), fr.nextDouble(), false);
        int numberOfCannons = fr.nextInt();
        int numberOfCoordinates = numberOfCannons + 2;
        Coordinates[] allCoordinates = new Coordinates[numberOfCoordinates];
        allCoordinates[0] = source;
        allCoordinates[1] = destination;
        for (int i = 2; i < numberOfCoordinates; i++) {
            allCoordinates[i] =
                new Coordinates(fr.nextDouble(), fr.nextDouble(), true);
        }
        
        double[][] times = new double[numberOfCoordinates][numberOfCoordinates];
        for (int i = 0; i < numberOfCoordinates; i++) {
            for (int j = 0; j < numberOfCoordinates; j++) {
                if (i != j) {
                    double time = allCoordinates[i].timeTo(allCoordinates[j]);
                    times[i][j] = time;
                }
            }
        }
        double[] shortestTimes = new double[numberOfCoordinates];
        for (int i = 1; i < numberOfCoordinates; i++) {
            shortestTimes[i] = INF;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0.0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int coordinatesIndex = pair.coordinatesIndex;
            if (pair.time <= shortestTimes[coordinatesIndex]) {
                for (int i = 0; i < numberOfCoordinates; i++) {
                    if (i != coordinatesIndex
                        && (shortestTimes[i] > shortestTimes[coordinatesIndex] +
                            times[coordinatesIndex][i])) {
                        shortestTimes[i] = shortestTimes[coordinatesIndex]
                            + times[coordinatesIndex][i];
                        pq.offer(new Pair(i, shortestTimes[i]));
                    }
                }
            }
        }
        System.out.println(shortestTimes[1]);
    }
}

class Pair implements Comparable<Pair> {

    int coordinatesIndex;
    double time;
    
    Pair(int coordinatesIndex, double time) {
        this.coordinatesIndex = coordinatesIndex;
        this.time = time;
    }

    @Override
    public int compareTo(Pair other) {
        double timeDifference = this.time - other.time;
        if (timeDifference > 0) {
            return 1;
        } else if (timeDifference < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}

class Coordinates {

    double x;
    double y;
    boolean isCannon;

    Coordinates(double x, double y, boolean isCannon) {
        this.x = x;
        this.y = y;
        this.isCannon = isCannon;
    }

    double timeTo(Coordinates other) {
        double distance = this.distanceTo(other);
        if (this.isCannon) {
            return Math.min(distance / 5.0, 2.0 + Math.abs(distance - 50.0) / 5.0);
        } else {
            return distance / 5.0;
        }
    }

    private double distanceTo(Coordinates other) {
        double xDistance = this.x - other.x;
        double yDistance = this.y - other.y;
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
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

