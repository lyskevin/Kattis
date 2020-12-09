import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int n;
    private static int k;
    private static int[] boxes;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        n = fio.nextInt();
        k = fio.nextInt();
        boxes = new int[n];
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            boxes[i] = fio.nextInt();
            sum += boxes[i];
        }

        // log2(1B) ~= 30, so 40 iterations is more than enough
        int low = 1;
        int high = sum;
        for (int i = 0; i < 40; i++) {
            int mid = (low + high) / 2;
            boolean canPartition = canPartition(mid);

            if (canPartition && (mid == 1 || !canPartition(mid - 1))) { // Answer found
                fio.println(mid);
                break;
            } else if (canPartition) { // Go lower
                high = mid - 1;
            } else { // Go higher
                low = mid + 1;
            }
        }

        fio.close();
    }

    private static boolean canPartition(int maxSum) {
        int count = 1;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            if (currentSum + boxes[i] <= maxSum) {
                currentSum += boxes[i];
            } else {
                count++;
                currentSum = boxes[i];
                if (currentSum > maxSum) {
                    return false;
                }
            }
        }
        return count <= k;
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

