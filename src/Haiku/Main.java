import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int S;
    private static HashSet<String> syllables = new HashSet<>();;
    private static String line;
    private static int[][] cache;
    private static final int[] REQUIRED_SYLLABLES = {5, 7, 5};

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        S = fio.nextInt();
        for (int i = 0; i < S; i++) {
            syllables.add(fio.nextLine());
        }

        boolean isPossible = true;
        for (int i = 0; i < 3 && isPossible; i++) {
            line = fio.nextLine();

            cache = new int[line.length() + 1][REQUIRED_SYLLABLES[i] + 1];
            
            for (int j = 0; j < line.length() + 1; j++) {
                for (int k = 0; k < REQUIRED_SYLLABLES[i] + 1; k++) {
                    cache[j][k] = -1;
                }
            }
            cache[line.length()][0] = 1;
    
            solve(0, REQUIRED_SYLLABLES[i]);
            isPossible = cache[0][REQUIRED_SYLLABLES[i]] == 1;
        }

        if (isPossible) {
            fio.println("haiku");
        } else {
            fio.println("come back next year");
        }
        fio.close();
    }

    private static void solve(int position, int target) {

        // Base case
        if (position == line.length() || target == 0) {
            return;
        }

        // Already memoized
        if (cache[position][target] > -1) {
            return;
        }

        // General case
        boolean hasSpace = line.charAt(position) == ' ';
        if (hasSpace) {
            position++;
        }
        int result = 0;

        for (int i = position + 1; i <= line.length(); i++) {
            if (syllables.contains(line.substring(position, i))) {
                solve(i, target - 1);
                result = Math.max(result, cache[i][target - 1]);
            }
        }

        if (hasSpace) {
            position--;
        }
        cache[position][target] = result;

        return;
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

