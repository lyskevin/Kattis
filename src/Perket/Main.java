import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int n;
    private static int[] information;
    private static int minimum = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        n = fio.nextInt();
        information = new int[n * 2];
        for (int i = 0; i < n; i++) {
            information[i * 2] = fio.nextInt();
            information[i * 2 + 1] = fio.nextInt();
        }
        generateSubsets(0, 1, 0, 0);
        fio.println(minimum);
        fio.close();
    }

    private static void generateSubsets(int index, int sourness, int bitterness,
            int numberOfUsedIngredients) {
        if (index == n) {
            if (numberOfUsedIngredients > 0) {
                minimum = Math.min(minimum, Math.abs(sourness - bitterness));
            }
            return;
        }
        generateSubsets(index + 1, sourness, bitterness, numberOfUsedIngredients); // Do not use current ingredient
        generateSubsets(index + 1, sourness * information[2 * index],
                bitterness + information[2 * index + 1], numberOfUsedIngredients + 1); // Use current ingredient
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

