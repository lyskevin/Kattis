import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        // Store frequencies of each x and y coordinate
        int[] frequencies1 = new int[1001];
        int[] frequencies2 = new int[1001];
        int x1 = fio.nextInt();
        int y1 = fio.nextInt();
        frequencies1[x1]++;
        frequencies2[y1]++;
        int x2 = fio.nextInt();
        int y2 = fio.nextInt();
        frequencies1[x2]++;
        frequencies2[y2]++;
        int x3 = fio.nextInt();
        int y3 = fio.nextInt();
        frequencies1[x3]++;
        frequencies2[y3]++;
        int x4 = 0;
        // Get fourth coordinate according to the x and y coordinates which were only used once
        if (frequencies1[x1] == 1) {
            x4 = x1;
        } else if (frequencies1[x2] == 1) {
            x4 = x2;
        } else {
            x4 = x3;
        }
        int y4 = 0;
        if (frequencies2[y1] == 1) {
            y4 = y1;
        } else if (frequencies2[y2] == 1) {
            y4 = y2;
        } else {
            y4 = y3;
        }
        fio.println(x4 + " " + y4);
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

