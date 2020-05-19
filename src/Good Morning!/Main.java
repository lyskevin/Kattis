import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static TreeSet<Integer> possibleNumbers = new TreeSet<>();

    public static void main(String[] args) {
        generateAllPossibleNumbers(0, 1);
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int number = fio.nextInt();
            if (number - possibleNumbers.floor(number) < possibleNumbers.ceiling(number) - number) {
                fio.println(possibleNumbers.floor(number));
            } else {
                fio.println(possibleNumbers.ceiling(number));
            }
        }
        fio.close();
    }

    private static void generateAllPossibleNumbers(int number, int digit) {
        if (number < 1000 && digit < 10) {
            possibleNumbers.add(number);
            if (digit == 1 || digit == 2 || digit == 4 || digit == 5) {
                generateAllPossibleNumbers(number * 10 + digit, digit + 1); // Move right; use current digit
                generateAllPossibleNumbers(number, digit + 1); // Move right; skip current digit
                generateAllPossibleNumbers(number * 10 + digit, digit + 3); // Move down
                generateAllPossibleNumbers(number, digit + 3); // Move down; skip current digit
            } else if (digit == 7) {
                generateAllPossibleNumbers(number * 10 + digit, digit + 1); // Move right
                generateAllPossibleNumbers(number, digit + 1); // Move right; skip current digit
            } else if (digit == 8) {
                generateAllPossibleNumbers(number * 10 + digit, digit + 1); // Move right; use current digit
                generateAllPossibleNumbers(number, digit + 1); // Move right; skip current digit
                generateAllPossibleNumbers(number * 10 + digit, 0); // Move down
                generateAllPossibleNumbers(number, 0); // Move down; skip current digit
            } else if (digit == 3 || digit == 6) {
                generateAllPossibleNumbers(number * 10 + digit, digit + 3); // Move down
                generateAllPossibleNumbers(number, digit + 3); // Move down; skip current digit
            } else if (digit == 0 && number == 0) {
                return;
            }
            generateAllPossibleNumbers(number * 10 + digit, digit); // Reuse current digit
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

