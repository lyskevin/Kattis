import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                String s = fio.nextLine();
                HashSet<String> palindromes = new HashSet<>();
                for (int i = 0; i < s.length() - 1; i++) {
                    // Check odd length palindromes with the character at index i as the middle
                    int start = i - 1;
                    int end = i + 1;
                    boolean isPalindrome = true;
                    while (start >= 0 && end < s.length()) {
                        if (s.charAt(start) == s.charAt(end)) {
                            palindromes.add(s.substring(start, end + 1));
                        } else {
                            break;
                        }
                        start--;
                        end++;
                    }
                    start = i;
                    end = i + 1;
                    // Check even length palindromes with the character at index i as the middle (left-hand side)
                    while (start >= 0 && end < s.length()) {
                        if (s.charAt(start) == s.charAt(end)) {
                            palindromes.add(s.substring(start, end + 1));
                        } else {
                            break;
                        }
                        start--;
                        end++;
                    }
                }
                String[] sortedPalindromes = palindromes.toArray(new String[palindromes.size()]);
                Arrays.sort(sortedPalindromes);
                for (int i = 0; i < sortedPalindromes.length; i++) {
                    fio.println(sortedPalindromes[i]);
                }
                fio.println();
            } catch (NullPointerException e) {
                break;
            }
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

