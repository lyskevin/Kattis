import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int p = fio.nextInt();
        int penalty = 0;
        int[] problems = new int[n - 1];
        for (int i = 0, j = 0; i < n; i++) {
            if (i == p) {
                penalty = fio.nextInt();
                j++;
            } else {
                problems[i - j] = fio.nextInt();
            }
        }
        Arrays.sort(problems); // Sort to choose problems greedily
        if (penalty > 300) { // Can't solve first problem within 300 minutes
            fio.println("0 0");
        } else {
            int count = 1;
            int remainingTime = 300 - penalty;
            int currentTime = penalty;
            for (int i = 0; i < n - 1; i++) {
                remainingTime -= problems[i];
                if (remainingTime >= 0) { // Can solve this problem in time
                    count++;
                    currentTime += problems[i];
                    penalty += currentTime;
                }
            }
            fio.println(count + " " + penalty);
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

