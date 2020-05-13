import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int x;
    private static int smallestNumberLargerThanX;
    private static int[] digits;
    private static boolean[] usedDigits;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        x = fio.nextInt();
        int copy = x;
        digits = new int[(int) Math.log10(x) + 1];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = copy % 10;
            copy /= 10;
        }
        usedDigits = new boolean[6];
        findLargestNumber(0, 0);
        if (smallestNumberLargerThanX <= x) {
            fio.println(0);
        } else {
            fio.println(smallestNumberLargerThanX);
        }
        fio.close();
    }

    // Try all permutations to get the required number
    private static void findLargestNumber(int number, int numberOfUsedDigits) {
        if (numberOfUsedDigits == digits.length) {
            if (number > x) {
                if (smallestNumberLargerThanX == 0) {
                    smallestNumberLargerThanX = number;
                } else {
                    smallestNumberLargerThanX = Math.min(smallestNumberLargerThanX, number);
                }
            }
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (!usedDigits[i]) {
                usedDigits[i] = true;
                findLargestNumber(number * 10 + digits[i], numberOfUsedDigits + 1);
                usedDigits[i] = false;
            }
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

