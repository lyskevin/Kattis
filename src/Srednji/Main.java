import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int[] map = new int[200001];

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        int B = fio.nextInt();
        int[] A = new int[N];
        int bIndex = 0;

        for (int i = 0; i < N; i++) {
            int number = fio.nextInt();
            A[i] = number;
            if (number == B) {
                bIndex = i;
            }
        }

        // Difference = Count of numbers > B - count of numbers < B
        // Mapping: Difference -> Number of subsequences starting at B with this specific difference
        // If difference < 0 (i.e. (count of numbers > B) < (count of numbers < B)) then we use index 100000 + |difference|
        int difference = 0;
        for (int i = bIndex; i < N; i++) {
            if (A[i] > B) {
                difference++;
            } else if (A[i] < B) {
                difference--;
            }

            int key = difference >= 0 ? difference : 100000 - difference;
            map[key]++;
        }

        // Find the required number of subsequences
        // Each subsequence is guaranteed to be of odd length because even length subsequences
        // will never be formed if we use -1 * difference as the key
        difference = 0;
        long count = 0l;
        for (int i = bIndex; i >= 0; i--) {
            if (A[i] > B) {
                difference++;
            } else if (A[i] < B) {
                difference--;
            }

            int key = difference <= 0 ? -1 * difference : 100000 + difference;
            count += map[key];
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

