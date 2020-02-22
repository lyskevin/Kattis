import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fio.nextInt();
            int[][] coordinates = new int[n + 2][2];
            for (int j = 0; j < n + 2; j++) {
                coordinates[j][0] = fio.nextInt();
                coordinates[j][1] = fio.nextInt();
            }
            int[][] connections = new int[n + 2][n + 2];
            for (int j = 0; j < n + 2; j++) {
                for (int k = 0; k < n + 2; k++) {
                    if (Math.abs(coordinates[j][0] - coordinates[k][0])
                            + Math.abs(coordinates[j][1] - coordinates[k][1]) <= 1000) {
                        connections[j][k] = 1;
                    }
                }
            }
            // Floyd Warshall's to solve transitive closure problem
            for (int m = 0; m < n + 2; m++) {
                for (int j = 0; j < n + 2; j++) {
                    for (int k = 0; k < n + 2; k++) {
                        connections[j][k] = connections[j][k] | (connections[j][m] & connections[m][k]);
                    }
                }
            }
            if (connections[0][n + 1] == 1) {
                fio.println("happy");
            } else {
                fio.println("sad");
            }
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

