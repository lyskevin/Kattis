import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int w = fio.nextInt();
        int p = fio.nextInt();
        int[] partitions = new int[p + 2];
        for (int i = 1; i <= p; i++) {
            partitions[i] = fio.nextInt();
        }
        partitions[p + 1] = w;
        TreeSet<Integer> widths = new TreeSet<>();
        // Generate all possible widths
        for (int i = 0; i < partitions.length - 1; i++) {
            for (int j = i + 1; j < partitions.length; j++) {
                widths.add(partitions[j] - partitions[i]);
            }
        }
        // Print widths
        boolean isFirstWidth = true;
        for (Integer width : widths) {
            if (isFirstWidth) {
                isFirstWidth = false;
            } else {
                fio.print(" ");
            }
            fio.print(width);
        }
        fio.println();
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

