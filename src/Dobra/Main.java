import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static char[] word;
    private static ArrayList<Integer> underscoreIndices = new ArrayList<>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        String input = fio.nextLine();
        word = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            word[i] = input.charAt(i);

            if (input.charAt(i) == '_') {
                underscoreIndices.add(i);
            }
        }

        fio.println(solve(0));

        fio.close();
    }

    private static long solve(int index) {
        if (index == underscoreIndices.size()) {
            for (int i = 0; i < word.length; i++) {
                if (word[i] == 'L') {
                    return 1;
                }
            }

            return 0;
        }

        long count = 0;

        word[underscoreIndices.get(index)] = 'L';
        if (isValidState()) {
            count += solve(index + 1); 
        }
        
        word[underscoreIndices.get(index)] = 'A';
        if (isValidState()) {
            count += 5 * solve(index + 1); 
        }

        word[underscoreIndices.get(index)] = 'B';
        if (isValidState()) {
            count += 20 * solve(index + 1); 
        }

        word[underscoreIndices.get(index)] = '_';
        return count;
    }

    private static boolean isValidState() {
        for (int i = 0; i < word.length; i++) {
            if ((i < word.length - 2) && ((isVowel(word[i]) && isVowel(word[i + 1]) && isVowel(word[i + 2]))
                    || (isConsonant(word[i]) && isConsonant(word[i + 1]) && isConsonant(word[i + 2])))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isVowel(char character) {
        return character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U';
    }

    private static boolean isConsonant(char character) {
        return !isVowel(character) && character != '_';
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

