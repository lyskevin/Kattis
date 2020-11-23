import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int[] heights = new int[3];
        int[] widths = new int[3];
        for (int i = 0; i < 3; i++) {
            heights[i] = fio.nextInt();
            widths[i] = fio.nextInt();
        }

        boolean canFormSquare = false;
        for (int i = 0; i < 3 && !canFormSquare; i++) {
            for (int j = 0; j < 3 && !canFormSquare; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 3 && !canFormSquare; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    // Try all 2^3 orientations
                    canFormSquare = test(widths[i], heights[i], widths[j], heights[j], widths[k], heights[k])
                        || test(widths[i], heights[i], widths[j], heights[j], heights[k], widths[k])
                        || test(widths[i], heights[i], heights[j], widths[j], widths[k], heights[k])
                        || test(widths[i], heights[i], heights[j], widths[j], heights[k], widths[k])
                        || test(heights[i], widths[i], widths[j], heights[j], widths[k], heights[k])
                        || test(heights[i], widths[i], widths[j], heights[j], heights[k], widths[k])
                        || test(heights[i], widths[i], heights[j], widths[j], widths[k], heights[k])
                        || test(heights[i], widths[i], heights[j], widths[j], heights[k], widths[k]);
                }
            }
        }

        if (canFormSquare) {
            fio.println("YES");
        } else {
            fio.println("NO");
        }

        fio.close();
    }

    // Try test 1.a and test 1.b
    private static boolean test(int a, int b, int c, int d, int e, int f) {
        boolean test1A = a == c && a == e && a == b + d + f;
        boolean test1B = a == c && b + d == e && a + f == e;
        return test1A || test1B;
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

