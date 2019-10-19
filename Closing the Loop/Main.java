import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            int s = fio.nextInt();
            PriorityQueue<Integer> redLengths =
                    new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> blueLengths =
                    new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < s; j++) {
                String input = fio.next();
                if (input.charAt(input.length() - 1) == 'R') {
                    redLengths.offer(
                            Integer.parseInt(input.substring(0, input.length() - 1))
                    );
                } else {
                    blueLengths.offer(
                            Integer.parseInt(input.substring(0, input.length() - 1))
                    );
                }
            }
            int totalLength = 0;
            int count = 0;
            while (!redLengths.isEmpty() && !blueLengths.isEmpty()) {
                totalLength += redLengths.poll() + blueLengths.poll() - 1;
                count++;
            }
            fio.println("Case #" + (i + 1) + ": " + (totalLength - count));
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

