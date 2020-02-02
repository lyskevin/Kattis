import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int a = fio.nextInt();
        int b = fio.nextInt();
        int k = fio.nextInt();
        int count = 0;
        for (int i = a; i <= b; i++) {
            boolean allPalindromes = true;
            for (int j = 2; j <= k; j++) {
                if (!isPalindrome(decimalToNewBase(j, i))) {
                    // Stop once the current number is not a palindrome in the current base
                    allPalindromes = false;
                    break;
                }
            }
            if (allPalindromes) {
                count++;
            }
        }
        fio.println(count);
        fio.close();
    }

    // Returns the decimal number's representation in the specified base
    // The reverse is returned but it does not matter since palindrome checking works the same from both directions
    private static String decimalToNewBase(int base, int number) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append(number % base);
            number /= base;
        }
        return sb.toString();
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
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

