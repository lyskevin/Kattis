import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final String[] LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private static int l;
    private static int w;
    private static boolean[][] memoTable;
    private static boolean hasSolution;
    private static String solution;
    private static LinkedList<String> letters;
    
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        l = fio.nextInt();
        w = fio.nextInt();
        memoTable = new boolean[l][w + 1];
        letters = new LinkedList<>();
        solve(0, 0);
        if (hasSolution) {
            fio.println(solution);
        } else {
            fio.println("impossible");
        }
        fio.close();
    }

    private static void solve(int currentLength, int currentWeight) {

        if (hasSolution) { // Prune here if solution already discovered
            return;
        }

        if (currentWeight > w) { // Not possible to use the current combination of letters
            return;
        }

        if (currentLength == l) {
            if (currentWeight == w) { // Solution found
                hasSolution = true;
                StringBuilder sb = new StringBuilder();
                for (String letter : letters) {
                    sb.append(letter);
                }
                solution = sb.toString();
            }
            return;
        }

        if (memoTable[currentLength][currentWeight]) { // State already visited
            return;
        }

        memoTable[currentLength][currentWeight] = true; // Memoize state
        for (int i = 0; i < 26; i++) { // Try all 26 letters
            letters.add(LETTERS[i]);
            solve(currentLength + 1, currentWeight + i + 1);
            letters.removeLast();
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

