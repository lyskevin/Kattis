import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static TreeSet<Integer> possibleNumbers = new TreeSet<>();

    public static void main(String[] args) {
        // Use numbers in from [0, 9] as the starting digit
        for (int i = 0; i < 10; i++) {
            generateAllPossibleNumbers(0, i);
        }
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int number = fio.nextInt();
            fio.println(number + Math.min(number - possibleNumbers.floor(number),
                        possibleNumbers.ceiling(number) - number));
        }
        fio.close();
    }

    private static void generateAllPossibleNumbers(int number, int digit) {
        if (digit < 10) {
            possibleNumbers.add(number);
            if (digit % 3 == 0) { // 9 and 0 are terminal states
                if (digit == 3 || digit == 6) { // Can only move down
                    generateAllPossibleNumbers(number * 10 + digit, digit + 1);
                }
            }
            generateAllPossibleNumbers(number * 10 + digit, digit + 1); // Move right
            generateAllPossibleNumbers(number * 10 + digit, digit + 3); // MOve down
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

