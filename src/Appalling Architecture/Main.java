import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int h = fio.nextInt();
        int w = fio.nextInt();
        int leftBottom = -1;
        int rightBottom = -1;
        int count = 0;
        int total = 0;
        for (int i = 0; i < h; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < w; j++) {
                char c = row.charAt(j);
                if (c != '.') {
                    count++;
                    total += j;
                    if (i == h - 1) {
                        if (leftBottom == -1) {
                            leftBottom = j;
                        }
                        rightBottom = j;
                    }
                }
            }
        }
        double centerOfGravity = 1.0 * total / count;
        if (centerOfGravity < leftBottom - 0.5) {
            fio.println("left");
        } else if (centerOfGravity > rightBottom + 0.5) {
            fio.println("right");
        } else {
            fio.println("balanced");
        }
        fio.close();
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

