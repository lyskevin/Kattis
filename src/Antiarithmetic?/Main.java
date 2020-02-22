import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String input = fio.next();
        while (!input.equals("0")) {
            int n = Integer.parseInt(input.substring(0, input.length() - 1));
            int[] numbers = new int[n];
            int[] positions = new int[n];
            for (int i = 0; i < n; i++) {
                int number = fio.nextInt();
                numbers[i] = number;
                positions[number] = i;
            }
            boolean isAntiarithmetic = true;
            for (int i = 0; i < n - 2 && isAntiarithmetic; i++) {
                int number = numbers[i];
                // Prune search space using difference instead of iterating over subsets
                // Check positive differences
                int difference = 1;
                while (number + difference + difference < n) {
                    if (positions[number + difference] > i
                            && positions[number + difference + difference] > positions[number + difference]) {
                        isAntiarithmetic = false;
                    }
                    difference++;
                }
                // Check negative differences
                difference = -1;
                while (number + difference + difference >= 0) {
                    if (positions[number + difference] > i
                            && positions[number + difference + difference] > positions[number + difference]) {
                        isAntiarithmetic = false;
                    }
                    difference--;
                }
            }
            if (isAntiarithmetic) {
                fio.println("yes");
            } else {
                fio.println("no");
            }
            input = fio.next();
        }
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

