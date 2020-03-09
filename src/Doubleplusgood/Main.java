import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static HashSet<Long> results = new HashSet<>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String[] numbers = fio.nextLine().split("\\+");
        countWays(numbers[0], 1, numbers);
        fio.println(results.size());
        fio.close();
    }

    private static void countWays(String carry, int index, String[] numbers) {
        if (index == numbers.length) {
            String[] parts = carry.split("\\+");
            long result = 0l;
            // Perform cumulative integer addition
            for (String part : parts) {
                result += Long.parseLong(part);
            }
            results.add(result);
        } else {
            countWays(carry + numbers[index], index + 1, numbers); // Concatenation operation
            countWays(carry + "+" + numbers[index], index + 1, numbers); // Addition operation
        }
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

