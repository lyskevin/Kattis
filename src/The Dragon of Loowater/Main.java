import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        while (!(n == 0 && m == 0)) {
            int[] heads = new int[n];
            int[] heights = new int[m];
            for (int i = 0; i < n; i++) {
                heads[i] = fio.nextInt();
            }
            for (int i = 0; i < m; i++) {
                heights[i] = fio.nextInt();
            }
            Arrays.sort(heads);
            Arrays.sort(heights);
            int headIndex = 0;
            int heightIndex = 0;
            int total = 0;
            while (headIndex < n && heightIndex < m) {
                while (heightIndex < m && heights[heightIndex] < heads[headIndex]) {
                    heightIndex++;
                }
                total += heights[heightIndex];
                headIndex++;
                heightIndex++;
            }
            if (headIndex < n) {
                fio.println("Loowater is doomed!");
            } else {
                fio.println(total);
            }
            n = fio.nextInt();
            m = fio.nextInt();
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

