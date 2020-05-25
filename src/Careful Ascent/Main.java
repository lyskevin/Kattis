import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static Shield[] shields;
    private static int y;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int x = fio.nextInt();
        y = fio.nextInt();
        int n = fio.nextInt();
        shields = new Shield[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            shields[i] = new Shield(fio.nextInt(), fio.nextInt(), fio.nextDouble());
        }
        Arrays.sort(shields);
        double low = -1000000000.0;
        double high = 1000000000.0;
        double middle = 0.0;
        // Binary search to find the answer; should converge within 60 iterations
        for (int i = 0; i < 60; i++) {
            middle = (low + high) / 2;
            if (calculateHorizontalDistance(middle) < x) {
                low = middle;
            } else {
                high = middle;
            }
        }
        fio.println(middle);
        fio.close();
    }

    private static double calculateHorizontalDistance(double horizontalSpeed) {
        double distance = 0.0;
        int startY = 0;
        for (Shield shield : shields) {
            // Account for regions which are not shielded
            if (startY < shield.l) {
                distance += (shield.l - startY) * horizontalSpeed;
            }
            distance += (shield.u - shield.l) * shield.f * horizontalSpeed;
            startY = shield.u;
        }
        if (startY < y) {
            distance += (y - startY) * horizontalSpeed;
        }
        return distance;
    }

}

class Shield implements Comparable<Shield> {

    int l;
    int u;
    double f;

    Shield(int l, int u, double f) {
        this.l = l;
        this.u = u;
        this.f = f;
    }

    @Override
    public int compareTo(Shield other) {
        return this.l - other.l;
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

