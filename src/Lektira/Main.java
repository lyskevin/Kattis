import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String word = fio.next();
        String chosenWord = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"; // 51 z's
        for (int i = 1; i <= word.length() - 2; i++) {
            for (int j = i + 1; j <= word.length() - 1; j++) {
                StringBuilder sb = new StringBuilder();
                // Reverse first partition
                for (int k = i - 1; k >= 0; k--) {
                    sb.append(word.charAt(k));
                }
                // Reverse second partition
                for (int k = j - 1; k >= i; k--) {
                    sb.append(word.charAt(k));
                }
                // Reverse third partition
                for (int k = word.length() - 1; k >= j; k--) {
                    sb.append(word.charAt(k));
                }
                // Choose lexicographically smallest word
                if (sb.toString().compareTo(chosenWord) < 0) {
                    chosenWord = sb.toString();
                }
            }
        }
        fio.println(chosenWord);
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

