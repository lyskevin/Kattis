import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int d = fio.nextInt();
        HashMap<Integer, Integer> quotientFrequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int number = fio.nextInt();
            int quotient = number / d;
            // Count quotient frequencies
            if (quotientFrequencies.containsKey(quotient)) {
                quotientFrequencies.put(quotient, quotientFrequencies.get(quotient) + 1);
            } else {
                quotientFrequencies.put(quotient, 1);
            }
        }
        long count = 0;
        // Sum of arithmetic prograssion (AP) formula to find number of pairs for each quotient
        for (Integer quotient : quotientFrequencies.keySet()) {
            long frequency = (long) quotientFrequencies.get(quotient);
            count += frequency * (frequency - 1) / 2;
        }
        fio.println(count);
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

