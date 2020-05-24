import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int w;
    private static int v;
    private static Coordinates[] gates;
    private static int[] skis;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        w = fio.nextInt();
        v = fio.nextInt();
        int n = fio.nextInt();
        gates = new Coordinates[n];
        for (int i = 0; i < n; i++) {
            gates[i] = new Coordinates(fio.nextDouble(), fio.nextDouble());
        }
        int s = fio.nextInt();
        skis = new int[s];
        for (int i = 0; i < s; i++) {
            skis[i] = fio.nextInt();
        }
        Arrays.sort(skis);
        int low = 0;
        int high = s - 1;
        int ski = 0;
        boolean isFound = false;
        // Using while (low <= high) is a bit too slow for a Java solution
        // log_2(1000000) ~= 20; i.e. binary search should converge t0 the answer within 20 iterations
        for (int i = 0; i < 20 && !isFound; i++) {
            int middle = (low + high) / 2;
            boolean isMiddleSkiValid = isValidSki(skis[middle]);
            // Check for fastest possible ski that can be used
            if ((middle == s - 1 && isMiddleSkiValid) 
                    || (isMiddleSkiValid && !isValidSki(skis[middle + 1]))) {
                isFound = true;
                ski = skis[middle];
            } else if (isMiddleSkiValid) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        if (isFound) {
            fio.println(ski);
        } else {
            fio.println("IMPOSSIBLE");
        }
        fio.close();
    }

    private static boolean isValidSki(int ski) {
        boolean isValidSki = true;
        double xMin = gates[0].x;
        double xMax = gates[0].x + w;
        for (int i = 0; i < gates.length - 1 && isValidSki; i++) {
            double timeBetweenGates = (gates[i + 1].y - gates[i].y) / ski;
            // Find min and max x coordinates that can be reached from current position
            xMin = Math.max(1.0, xMin - v * timeBetweenGates);
            xMax = Math.min(100000000.0, xMax + v * timeBetweenGates);
            // Limit min and max x coordinates using next gate position
            double newXMin = Math.max(xMin, gates[i + 1].x);
            double newXMax = Math.min(xMax, gates[i + 1].x + w);
            if (newXMin > xMax || newXMax < xMin) { // Not possible to pass through the next gate
                isValidSki = false;
            } else {
                xMin = newXMin;
                xMax = newXMax;
            }
        }
        return isValidSki;
    }

}

class Coordinates {

    double x;
    double y;

    Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
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

