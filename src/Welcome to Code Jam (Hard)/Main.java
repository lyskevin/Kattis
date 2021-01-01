import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final String WELCOME = "welcome to code jam";
    private static String text;
    private static int[][] cache;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int T = fio.nextInt();
        for (int i = 0; i < T; i++) {
            text = fio.nextLine();
            cache = new int[WELCOME.length()][text.length()];

            for (int j = 0; j < WELCOME.length(); j++) {
                for (int k = 0; k < text.length(); k++) {
                    cache[j][k] = -1;
                }
            }

            fio.println(String.format("Case #%d: %04d", (i + 1), solve(0, 0)));
        }

        fio.close();
    }

    private static int solve(int welcomeIndex, int textIndex) {
        // Welcome formed
        if (welcomeIndex == WELCOME.length()) {
            return 1;
        }

        // Welcome cannot be formed using the current subset of characters in the text
        if (textIndex >= text.length()) {
            return 0;
        }

        // Already cached
        if (cache[welcomeIndex][textIndex] > -1) {
            return cache[welcomeIndex][textIndex];
        }

        // General case
        int result = 0;
        char welcomeCharacter = WELCOME.charAt(welcomeIndex);
        for (int i = textIndex; i < text.length(); i++) {
            if (text.charAt(i) == welcomeCharacter) {
                result += solve(welcomeIndex + 1, i + 1);
            }
        }

        return cache[welcomeIndex][textIndex] = result % 10000;
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

