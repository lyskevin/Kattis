import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String word = fio.nextLine();
        String letters = fio.nextLine();
        String guess = "";
        for (int i = 0; i < word.length(); i++) {
            guess += "_";
        }
        int numberOfWrongGuesses = 0;
        boolean hasWon = false;
        for (int i = 0; i < letters.length(); i++) {
            if (word.indexOf(letters.charAt(i)) > -1) {
                word = word.replaceAll(letters.charAt(i) + "", "_");
            } else {
                numberOfWrongGuesses++;
            }
            if (numberOfWrongGuesses < 10 && guess.equals(word)) {
                hasWon = true;
            }
        }
        if (hasWon) {
            fio.println("WIN");
        } else {
            fio.println("LOSE");
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

