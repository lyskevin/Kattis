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
        int[] entryTimes = new int[n];
        int[] exitTimes = new int[m];
        for (int i = 0; i < n; i++) {
            entryTimes[i] = fio.nextInt();
        }
        for (int i = 0; i < m; i++) {
            exitTimes[i] = fio.nextInt();
        }
        int difference = 2000000000;
        int frequency = 0;
        HashMap<Integer, Integer> differences = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int exitTime = exitTimes[i];
            for (int j = 0; j < n; j++) {
                int entryTime = entryTimes[j];
                if (exitTime >= entryTime) {
                    int currentDifference = exitTime - entryTime;
                    int currentFrequency = 1;
                    if (differences.containsKey(currentDifference)) {
                        currentFrequency += differences.get(currentDifference).intValue();
                    }
                    if (currentFrequency > frequency
                            || currentFrequency == frequency && currentDifference < difference) {
                        difference = currentDifference;
                        frequency = currentFrequency;
                    }
                    differences.put(currentDifference, currentFrequency);
                } else {
                    break;
                }
            }
        }
        if (frequency == 0) {
            fio.println(0);
        } else {
            fio.println(difference);
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

