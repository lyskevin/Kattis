import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int[] digits = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    private static StringNumber[] minimums = new StringNumber[101];
    private static StringNumber[] maximums = new StringNumber[101];

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        generateNumbers(0, new StringBuilder());
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fio.nextInt();
            fio.println(minimums[n].number + " " + maximums[n].number);
        }
        fio.close();
    }

    private static void generateNumbers(int n, StringBuilder s) {
        // n > 100 is an invalid value
        if (n > 100) {
            return;
        } else if (n == 0) {
            // Start from 1 to avoid leading 0s
            for (int i = 1; i <= 9; i++) {
                s.append(i);
                generateNumbers(n + digits[i], s);
                s.deleteCharAt(s.length() - 1);
            }
        } else {
            StringNumber sn = new StringNumber(s.toString());
            // Number is between minimum and maximum for this value of n
            // In this case, we do not want to proceed with any further computations
            if (minimums[n] != null && sn.compareTo(minimums[n]) > 0
                    && maximums[n] != null && sn.compareTo(maximums[n]) < 0) {
                return;
            }
            // New minimum found
            if (minimums[n] == null || sn.compareTo(minimums[n]) <= 0) {
                minimums[n] = sn;
            }
            // New maximum found
            if (maximums[n] == null || sn.compareTo(maximums[n]) >= 0) {
                maximums[n] = sn;
            }
            for (int i = 0; i <= 9; i++) {
                s.append(i);
                generateNumbers(n + digits[i], s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

}

class StringNumber implements Comparable<StringNumber> {

    String number;

    StringNumber(String number) {
        this.number = number;
    }

    @Override
    public int compareTo(StringNumber other) {
        if (this.number.length() != other.number.length()) {
            return this.number.length() - other.number.length();
        } else {
            for (int i = 0; i < this.number.length(); i++) {
                if (this.number.charAt(i) != other.number.charAt(i)) {
                    return this.number.charAt(i) - other.number.charAt(i);
                }
            }
            return 0;
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

