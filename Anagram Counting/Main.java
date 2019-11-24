import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                String word = fio.nextLine();
                int[] characterCounts = new int[200];
                for (int i = 0; i < word.length(); i++) {
                    characterCounts[word.charAt(i)]++;
                }
                BigInteger numberOfAnagrams = factorial(word.length());
                for (int i = 65; i <= 90; i++) {
                    if (characterCounts[i] > 1) {
                        numberOfAnagrams = numberOfAnagrams.divide(factorial(characterCounts[i]));
                    }
                }
                for (int i = 97; i <= 122; i++) {
                    if (characterCounts[i] > 1) {
                        numberOfAnagrams = numberOfAnagrams.divide(factorial(characterCounts[i]));
                    }
                }
                fio.println(numberOfAnagrams);
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }

    private static BigInteger factorial(int n) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(new BigInteger("" + i));
        }
        return factorial;
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

