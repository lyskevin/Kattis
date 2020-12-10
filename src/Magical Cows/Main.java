import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int C = fio.nextInt();
        int N = fio.nextInt();
        int M = fio.nextInt();

        HashMap<Integer, Long> frequencies = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int count = fio.nextInt();
            if (!frequencies.containsKey(count)) {
                frequencies.put(count, 0l);
            }
            frequencies.put(count, frequencies.get(count) + 1);
        }

        long farms[] = new long[51];
        farms[0] = N;

        for (int i = 1; i <= 50; i++) {
            long totalFrequency = 0l;
            HashMap<Integer, Long> newFrequencies = new HashMap<>();

            for (Integer count : frequencies.keySet()) {
                Long frequency = frequencies.get(count);
                int newCount = count * 2;
                if (newCount > C) {
                    int half1 = newCount / 2;
                    if (!newFrequencies.containsKey(half1)) {
                        newFrequencies.put(half1, 0l);
                    }
                    newFrequencies.put(half1, newFrequencies.get(half1) + frequency);

                    int half2 = newCount - (newCount / 2);
                    if (!newFrequencies.containsKey(half2)) {
                        newFrequencies.put(half2, 0l);
                    }
                    newFrequencies.put(half2, newFrequencies.get(half2) + frequency);
                    
                    totalFrequency += (frequency * 2);
                } else {
                    if (!newFrequencies.containsKey(newCount)) {
                        newFrequencies.put(newCount, 0l);
                    }
                    newFrequencies.put(newCount, newFrequencies.get(newCount) + frequency);
                    totalFrequency += frequency;
                }
            }

            frequencies = newFrequencies;
            farms[i] = totalFrequency;
        }

        for (int i = 0; i < M; i++) {
            fio.println(farms[fio.nextInt()]);
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

