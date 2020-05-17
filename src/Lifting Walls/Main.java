import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        double l = fio.nextDouble();
        double w = fio.nextDouble();
        int n = fio.nextInt();
        double r = fio.nextDouble();
        Point[] cranes = new Point[n];
        for (int i = 0; i < n; i++) {
            cranes[i] = new Point(fio.nextDouble(), fio.nextDouble());
        }
        Point[] walls = new Point[4];
        walls[0] = new Point(-l / 2, 0);
        walls[1] = new Point(l / 2, 0);
        walls[2] = new Point(0, -w / 2);
        walls[3] = new Point(0, w / 2);
        int minimumCount = 4;
        boolean hasSolution = false;
        // Check cranes iteratively
        for(int i = 0; i < n; i++) {
            int bitmask1 = reduceBitmask(15, cranes[i], walls, r);
            int count1 = 0;
            if (bitmask1 < 15) {
                count1++;
            }
            if (bitmask1 == 0) {
                hasSolution = true;
                minimumCount = Math.min(minimumCount, count1);
            }
            for (int j = i + 1; j < n && bitmask1 > 0; j++) {
                int bitmask2 = reduceBitmask(bitmask1, cranes[j], walls, r);
                int count2 = count1;
                if (bitmask2 < bitmask1) {
                    count2++;
                }
                if (bitmask2 == 0) {
                    hasSolution = true;
                    minimumCount = Math.min(minimumCount, count2);
                }
                for (int k = j + 1; k < n && bitmask2 > 0; k++) {
                    int bitmask3 = reduceBitmask(bitmask2, cranes[k], walls, r);
                    int count3 = count2;
                    if (bitmask3 < bitmask2) {
                        count3++;
                    }
                    if (bitmask3 == 0) {
                        hasSolution = true;
                        minimumCount = Math.min(minimumCount, count3);
                    }
                    for (int m = k + 1; m < n && bitmask3 > 0; m++) {
                        int bitmask4 = reduceBitmask(bitmask3, cranes[m], walls, r);
                        int count4 = count3;
                        if (bitmask4 < bitmask3) {
                            count4++;
                        }
                        if (bitmask4 == 0) {
                            hasSolution = true;
                            minimumCount = Math.min(minimumCount, count4);
                        }
                    }
                }
            }
        }
        if (hasSolution) {
            fio.println(minimumCount);
        } else {
            fio.println("Impossible");
        }
        fio.close();
    }

    // Remove walls from bitmask that the current crane can cover
    private static int reduceBitmask(int bitmask, Point crane, Point[] walls, double radius) {
        for (int i = 0; i < 4; i++) {
            if (crane.distanceTo(walls[i]) <= radius + 10E-15) {
                bitmask &= ((1 << i) ^ 15);
            }
        }
        return bitmask;
    }

}

class Point {

    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point other) {
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

