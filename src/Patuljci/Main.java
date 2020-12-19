import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int[] dwarves = new int[9];
        int sum = 0;
            
        for (int i = 0; i < 9; i++) {
            dwarves[i] = fio.nextInt();
            sum += dwarves[i];
        }

        boolean[] used = new boolean[9];
        boolean isFound = false;
        for (int i = 0; i < 8 && !isFound; i++) {
            for (int j = i + 1; j < 9 && !isFound; j++) {
                if (sum - dwarves[i] - dwarves[j] == 100) {
                    used[i] = true;
                    used[j] = true;
                    isFound = true;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                fio.println(dwarves[i]);
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

