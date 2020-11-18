import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int k = fio.nextInt();
        Integer[] durations = new Integer[k];
        for (int i = 0; i < k; i++) {
            durations[i] = fio.nextInt();
        }
        Arrays.sort(durations, Comparator.reverseOrder());
        int result = 0;
        PriorityQueue<Integer> excessDurations = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < durations.length; i++) {
            int currentDuration = durations[i];
            if (excessDurations.isEmpty()) {
                result += currentDuration;
                excessDurations.offer(currentDuration - 1);
            } else {
                int excessDuration = excessDurations.poll();
                if (currentDuration > excessDuration) {
                    int newExcessDuration = currentDuration - excessDuration - 1;
                    if (newExcessDuration > 0) {
                        excessDurations.offer(newExcessDuration);
                    }
                    result += newExcessDuration + 1;
                } else {
                    excessDurations.offer(excessDuration - currentDuration + 1);
                    result++;
                }
            }
        }
        fio.println(result);
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

