import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int[] fruits = new int[n];
        int totalFruitWeights = 0;
        for (int i = 0; i < n; i++) {
            int fruit = fio.nextInt();
            fruits[i] = fruit;
            totalFruitWeights += fruit;
        }
        long smallBasketWeights = calculateSmallBasketWeights(fruits, 0, 0);
        long totalBasketWeights = ((long) Math.pow(2, n - 1)) * totalFruitWeights; // Total weight of all subsets
        fio.println(totalBasketWeights - smallBasketWeights);
        fio.close();
    }

    // Calculate total weight of all subsets with weight < 200
    private static long calculateSmallBasketWeights(int[] fruits, int index, int weight) {
        if (index == fruits.length) {
            return weight;
        }
        long result = 0;
        if (weight + fruits[index] < 200) {
            // Take fruit
            result += calculateSmallBasketWeights(fruits, index + 1, weight + fruits[index]);
        }
        // Do not take fruit
        result += calculateSmallBasketWeights(fruits, index + 1, weight);
        return result;
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

