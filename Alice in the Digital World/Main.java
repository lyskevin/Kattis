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
            int m = fio.nextInt();
            int[] numbers = new int[n];
            int[] rangeSums = new int[n];
            int rangeSum = 0;
            for (int j = 0; j < n; j++) {
                numbers[j] = fio.nextInt();
                rangeSum += numbers[j];
                rangeSums[j] = rangeSum;
            }
            int max = 0;
            for (int j = 0; j < n; j++) {
                // Perform range sum query whenever m is found
                if (numbers[j] == m) {
                    int start = getStart(j, numbers, m);
                    int end = getEnd(j, numbers, m);
                    int result = 0;
                    if (start == 0) {
                        result = rangeSums[end];
                    } else {
                        result = rangeSums[end] - rangeSums[start - 1];
                    }
                    max = Math.max(max, result);
                }
            }
            fio.println(max);
        }
        fio.close();
    }

    // Get start index of current subarray (inclusive)
    private static int getStart(int index, int[] numbers, int m) {
        while (index > 0) {
            if (numbers[index - 1] <= m) {
                return index;
            } else {
                index--;
            }
        }
        return 0;
    }

    // Get end index of current subarray (inclusive)
    private static int getEnd(int index, int[] numbers, int m) {
        while (index < numbers.length - 1) {
            if (numbers[index + 1] <= m) {
                return index;
            } else {
                index++;
            }
        }
        return numbers.length - 1;
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

