import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        double C = fio.nextDouble();
        double X = fio.nextDouble();
        double M = fio.nextDouble();
        int result = 0;        

        for (int i = 0; i < 6; i++) {
            int speed = fio.nextInt();
            double efficiency = fio.nextDouble();
            if (calculateMaxDistance(C / 2, speed, efficiency, X) >= M) {
                result = speed;
            }
        }

        if (result == 0) {
            fio.println("NO");
        } else {
            fio.println("YES " + result);
        }

        fio.close();
    }

    private static double calculateMaxDistance(double fuel, int speed, double efficiency, double lossRate) {
        return fuel / (lossRate + (speed / efficiency)) * speed;
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

