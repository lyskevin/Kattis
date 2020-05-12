import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int[] values = new int[5];
    private static int[][] memoTable;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String input = fio.nextLine();
        while (!input.equals("0")) {
            memoTable = new int[101][101];
            boolean isTautology = true;
            // Try all 2^5 variable values with pruning (i.e. once any expression evaluates to false)
            for (int i = 0; i < 2 && isTautology; i++) {
                values[0] = i;
                for (int j = 0; j < 2 && isTautology; j++) {
                    values[1] = j;
                    for (int k = 0; k < 2 && isTautology; k++) {
                        values[2] = k;
                        for (int l = 0; l < 2 && isTautology; l++) {
                            values[3] = l;
                            for (int m = 0; m < 2 && isTautology; m++) {
                                values[4] = m;
                                if (evaluate(input, 0, input.length()) == 0) {
                                    isTautology = false;
                                }
                            }
                        }
                    }
                }
            }
            if (isTautology) {
                fio.println("tautology");
            } else {
                fio.println("not");
            }
            input = fio.nextLine();
        }
        fio.close();
    }

    private static int evaluate(String s, int start, int end) {
        if (s.charAt(start) >= 'p' && s.charAt(start) <= 't') { // Variable
            return values[s.charAt(start) - 'p'];
        } else if (s.charAt(start) == 'N') { // Logical not
            return 1 ^ evaluate(s, start + 1, end);
        } else { // Binary relation
            int index = start + 2;
            while (!isWFF(s, start + 1, index)) { // Find the first WFF in the binary relation
                index++;
            }
            // Apply binary relation to both WFFs
            if (s.charAt(start) == 'A') { // Logical or
                return or(evaluate(s, start + 1, index), evaluate(s, index, end));
            } else if (s.charAt(start) == 'C') { // Logical implication
                return implies(evaluate(s, start + 1, index), evaluate(s, index, end));
            } else if (s.charAt(start) == 'E') { // Logical equality
                return equals(evaluate(s, start + 1, index), evaluate(s, index, end));
            } else { // Logical and
                return and(evaluate(s, start + 1, index), evaluate(s, index, end));
            }
        }
    }

    // Returns true if the specified string with given start and end indices is a WFF
    // Memoizes the result in a table (0: not memoized, 1: not isWFF, 2: isWFF)
    private static boolean isWFF(String s, int start, int end) {
        if (memoTable[start][end] > 0) { // Result already memoized in table
            return memoTable[start][end] == 1 ? false : true;
        }
        if (s.length() == 0) { // End of expression reached
            memoTable[start][end] = 1;
            return false;
        }
        if (s.charAt(start) >= 'p' && s.charAt(start) <= 't') { // Variable found
            memoTable[start][end] = 2;
            return true;
        }
        if (s.charAt(start) == 'N') { // Logical not; recursively check sub-expression
            boolean result = isWFF(s, start + 1, end);
            memoTable[start][end] = result ? 2 : 1;
            return result;
        }
        // Binary relation; recursively check sub-expression
        int index = start + 2;
        while (index < end && !isWFF(s, start + 1, index)) {
            index++;
        }
        boolean result = false;
        if (index < end) {
            result = isWFF(s, index, end);
        }
        memoTable[start][end] = result ? 2 : 1; // Memoize result
        return result;
    }

    // Helper methods using bitwise operations
    private static int and(int p, int q) {
        return p & q;
    }

    private static int or(int p, int q) {
        return p | q;
    }

    private static int implies(int p, int q) {
        return not(p) | q;
    }

    private static int not(int p) {
        return p ^ 1;
    }

    private static int equals(int p, int q) {
        return p == q ? 1 : 0;
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

