import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static boolean[] validBitmasks = new boolean[1024];
    private static boolean[][] usedIndices;
    private static int[] sequence = new int[12];
    private static int count;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int p = fio.nextInt();
        for (int i = 0; i < p; i++) {
            int k = fio.nextInt();
            for (int j = 0; j < 12; j++) {
                sequence[j] = fio.nextInt();
            }
            count = 0;
            usedIndices = new boolean[12][12];
            generateIslands(1, 1); // Only use start and end indices in the range [1, 10]
            fio.println(k + " " + count);
        }
        fio.close();
    }

    private static void generateIslands(int startIndex, int endIndex) {
        if (!usedIndices[startIndex][endIndex]) {
            if (endIndex < 11) {
                if (isValidIsland(startIndex, endIndex)) {
                    count++;
                }
                // Add one extra number to the current sequence
                generateIslands(startIndex, endIndex + 1);
                usedIndices[startIndex][endIndex + 1] = true;
                // Do not use next consecutive number; prune non-contiguous sequence
                // and thus move the start index of the next sequence to end index + 1
                generateIslands(endIndex + 1, endIndex + 1);
                usedIndices[endIndex + 1][endIndex + 1] = true;
            }
        }
    }

    private static boolean isValidIsland(int startIndex, int endIndex) {
        boolean isValidIsland = true;
        for (int i = startIndex; i <= endIndex; i++) {
            if (sequence[i] <= sequence[startIndex - 1] || sequence[i] <= sequence[endIndex + 1]) {
                isValidIsland = false;
            }
        }
        return isValidIsland;
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

