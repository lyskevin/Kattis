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
            HashMap<Long, Integer> rangeSumFrequencies = new HashMap<>();
            long rangeSum = 0l;
            int[] sequence = new int[n];

            // Store the sequence
            // Map each range sum (from index 0 to the current position) to its frequency
            for (int j = 0; j < n; j++) {
                int number = fio.nextInt();
                sequence[j] = number;
                rangeSum += number;
                if (!rangeSumFrequencies.containsKey(rangeSum)) {
                    rangeSumFrequencies.put(rangeSum, 0);
                }
                rangeSumFrequencies.put(rangeSum, rangeSumFrequencies.get(rangeSum) + 1);
            }

            long count = 0l;
            rangeSum = 0l;

            // For every valid subsequence sum x,
            // x - current range sum = 47 ==> x = 47 + current range sum
            for (int j = 0; j < n; j++) {

                // Get frequency of valid subsequence sum x
                if (rangeSumFrequencies.containsKey(47l + rangeSum)) {
                    count += rangeSumFrequencies.get(47l + rangeSum);
                }

                rangeSum += sequence[j];

                // Remove current range sum from the frequency mappings
                if (rangeSumFrequencies.get(rangeSum) == 1) {
                    rangeSumFrequencies.remove(rangeSum);
                } else {
                    rangeSumFrequencies.put(rangeSum, rangeSumFrequencies.get(rangeSum) - 1);
                }
            }
            fio.println(count);
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

