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
        boolean[][] restrictions = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int ingredient1 = fio.nextInt();
            int ingredient2 = fio.nextInt();
            restrictions[ingredient1][ingredient2] = true;
            restrictions[ingredient2][ingredient1] = true;
        }
        int count = countSubsets(new boolean[n + 1], restrictions, 1);
        fio.println(count);
        fio.close();
    }

    private static int countSubsets(boolean[] ingredients, boolean[][] restrictions, int index) {
        // Valid subset obtained after considering all ingredients
        if (index == ingredients.length) {
            return 1;
        }
        int count = 0;
        // Check if the ingredient at the current index violates any restrictions
        // with previously used ingredients
        boolean hasRestriction = false;
        for (int i = 1; i < index; i++) {
            if (ingredients[i] && restrictions[i][index]) {
                hasRestriction = true;
            }
        }
        // The current ingredient does not violate any restrictions ==> use it
        if (!hasRestriction) {
            ingredients[index] = true;
            count += countSubsets(ingredients, restrictions, index + 1);
            ingredients[index] = false;
        }
        // Always consider subsets which do not use the current ingredient
        count += countSubsets(ingredients, restrictions, index + 1);
        return count;
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

