import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int N;
    private static int C;
    private static WordCloud[] wordClouds;

    // dpTable[index] stores the best possible total height with wordClouds[index]
    // as the starting (top left) word cloud
    private static int[] dpTable;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        N = fio.nextInt();
        C = fio.nextInt();

        wordClouds = new WordCloud[N];
        for (int i = 0; i < N; i++) {
            wordClouds[i] = new WordCloud(fio.nextInt(), fio.nextInt());
        }
        dpTable = new int[N + 1];

        solve(0);
        fio.println(dpTable[0]);
        fio.close();
    }

    private static void solve(int index) {

        // Stop here
        if (index == N) {
            return;
        }

        // Result already memoized
        if (dpTable[index] > 0) {
            return;
        }

        // Continuously try to add to this row and store the best result
        int result = 1000000000;
        int nextIndex = index;
        int maxRowHeight = 0;
        int nextWidth = 0;
        while (nextIndex < N && (nextWidth += wordClouds[nextIndex].w) <= C) {
            maxRowHeight = Math.max(maxRowHeight, wordClouds[nextIndex].h);
            nextIndex++;
            solve(nextIndex);

            // Best result is minimum sum of max (current) row height and new block
            // (starting from the next row) with wordClouds[nextIndex] as the top left word cloud
            result = Math.min(result, maxRowHeight + dpTable[nextIndex]);
        }
        
        dpTable[index] = result;
    }
}

class WordCloud {
    int w;
    int h;

    WordCloud(int w, int h) {
        this.w = w;
        this.h = h;
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

