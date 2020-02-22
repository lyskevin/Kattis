import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int[] characterFrequencies = new int[26];
        String s = fio.nextLine();
        for (int i = 0; i < s.length(); i++) {
            characterFrequencies[s.charAt(i) - 'a']++;
        }
        int numberOfCharactersWithOddFrequencies = 0;
        for (int i = 0; i < 26; i++) {
            if (characterFrequencies[i] % 2 != 0) {
                numberOfCharactersWithOddFrequencies++;
            }
        }
        // Leave one character with an odd frequency
        if (numberOfCharactersWithOddFrequencies > 1) {
            fio.println(numberOfCharactersWithOddFrequencies - 1);
        } else {
            fio.println(0);
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

