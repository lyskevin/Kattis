import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static Segment[] segments;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int t = fio.nextInt();
        segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            segments[i] = new Segment(fio.nextInt(), fio.nextInt());
        }
        double low = -1000.0;
        double high = 10000000000.0; // c may be greater than 1000
        double c = 0.0;
        // 60 iterations is enough for c to converge
        // log_2((10^10 - (-1000)) / 10^-6) < 100
        for (int i = 0; i < 60; i++) {
            c = (low + high) / 2;
            double time = calculateTime(c);
            if (time < 0.0 || time > t) {
                low = c;
            } else {
                high = c;
            }
        }
        fio.println(c);
        fio.close();
    }

    private static double calculateTime(double c) {
        double time = 0.0;
        for (int i = 0; i < segments.length; i++) {
            double trueSpeed = segments[i].speedometerReading + c;
            // Return a large number if true speed < 0; want to increase c
            if (trueSpeed < 0.0) {
                return 1000000000;
            }
            time += segments[i].distance / (segments[i].speedometerReading + c);
        }
        return time;
    }

}

class Segment {

    int distance;
    int speedometerReading;

    Segment(int distance, int speedometerReading) {
        this.distance = distance;
        this.speedometerReading = speedometerReading;
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

