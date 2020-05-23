import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int[] paintCans;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        paintCans = new int[n];
        for (int i = 0; i < n; i++) {
            paintCans[i] = fio.nextInt();
        }
        Arrays.sort(paintCans);
        long wastage = 0l;
        for (int i = 0; i < m; i++) {
            wastage += getPaintWastage(fio.nextInt());
        }
        fio.println(wastage);
        fio.close();
    }

    // Binary search to find the waste generated per required paint amount
    private static int getPaintWastage(int amountRequired) {
        int low = 0;
        int high = paintCans.length;
        boolean isFound = false;
        int wastage = 0;
        while (low <= high && !isFound) {
            int middle = (low + high) / 2;
            if (paintCans[middle] < amountRequired) {
                low = middle + 1;
            }
            else if (middle == 0
                    || paintCans[middle - 1] < amountRequired && paintCans[middle] >= amountRequired) {
                isFound = true;
                wastage = paintCans[middle] - amountRequired;
            } else {
                high = middle - 1;
            }
        }
        return wastage;
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

