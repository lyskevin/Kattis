import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        while (n > 0) {
            int maxCount = 0;
            String favouriteWord = "";
            for (int i = 0; i < n; i++) {
                String word = fio.nextLine();
                int count = 0;
                for (int j = 0; j < word.length() - 1; j++) {
                    // Check if current letter is a vowel and the next letter is the same vowel
                    if ((word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i'
                                || word.charAt(j) == 'o' || word.charAt(j) == 'u' || word.charAt(j) == 'y')
                            && word.charAt(j) == word.charAt(j + 1)) {
                        count++;
                        j++;
                    }
                }
                // There appears to be a case where the answer is a word with 0 double vowels
                // Hence the use of >=
                if (count >= maxCount) {
                    favouriteWord = word;
                    maxCount = count;
                }
            }
            fio.println(favouriteWord);
            n = fio.nextInt();
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

