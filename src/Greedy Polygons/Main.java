import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        for (int i = 0; i < N; i++) {
            int n = fio.nextInt();
            int l = fio.nextInt();
            int d = fio.nextInt();
            int g = fio.nextInt();

            double isoAngle = (180.0 * (n - 2)) / n / 2;
            double isoLength = l * Math.sin(degreesToRadians(isoAngle)) / Math.sin(degreesToRadians(180.0 - 2 * isoAngle));
            double isoArea = 0.5 * isoLength * isoLength * Math.sin(degreesToRadians(180.0 - 2 * isoAngle));

            fio.println(n * isoArea + Math.PI * g * d * g * d + n * l * g * d);
        }

        fio.close();
    }

    private static double degreesToRadians(double degrees) {
        return degrees / 180.0 * Math.PI;
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

