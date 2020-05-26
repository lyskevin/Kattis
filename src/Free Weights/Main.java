import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int[] weights1 = new int[n];
        int[] allWeights = new int[2 * n];
        for (int i = 0; i < n; i++) {
            allWeights[i] = weights1[i] = fio.nextInt();
        }
        int[] weights2 = new int[n];
        for (int i = 0; i < n; i++) {
            allWeights[n + i] = weights2[i] = fio.nextInt();
        }

        // Generate an array containing all weights in sorted order
        Arrays.sort(allWeights);
        int[] sortedWeights = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sortedWeights[i + 1] = allWeights[2 * i];
        }

        // Possible to not have to move anything (i.e. output 0)
        sortedWeights[0] = 0;
        int low = 0;
        int high = n;
        boolean isFound = false;
        int min = 0;

        // Binary search to find minimum possible weight
        while (low <= high && !isFound) {
            int middle = (low + high) / 2;
            boolean isValidWeight = isValidWeight(sortedWeights[middle], weights1)
                && isValidWeight(sortedWeights[middle], weights2);
            if (isValidWeight && (middle == 0 ||
                        !isValidWeight(sortedWeights[middle - 1], weights1)
                        || !isValidWeight(sortedWeights[middle - 1], weights2))) {
                min = sortedWeights[middle];
                isFound = true;
            } else if (isValidWeight) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        fio.println(min);
        fio.close();
    }

    // Observation: For the specified weight to be valid, weights which are larger than it
    // must appear consecutively if we ignore smaller or equivalent weights
    private static boolean isValidWeight(int weight, int[] weights) {
        boolean hasFirst = false; // Search for pairs of consecutive weights
        int previousWeight = 0;
        for (int i = 0, n = weights.length; i < n; i++) {
            if (weights[i] > weight) {
                if (hasFirst && weights[i] != previousWeight) {
                    return false;
                } else if (!hasFirst) {
                    previousWeight = weights[i];
                }
                hasFirst = !hasFirst;
            }
        }
        return !hasFirst;
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

