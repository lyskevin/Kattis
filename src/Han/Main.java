import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int q = fio.nextInt();
        int[] frequencies = new int[26];
        int reference = 0;
        boolean isReversed = false;
        for (int i = 0; i < q; i++) {
            String query = fio.next();
            int n = fio.nextInt();
            if (query.equals("UPIT")) {
                int x = fio.next().charAt(0) - 'a';
                numberOfTimes = frequencies[x] + (n - reference) / 26;
                if (isReversed) {
                    if ((n - reference) 
                } else {
                    if ((n - reference) % 26 >= x) {
                        numberOfTimes++;
                    }
                }
                fio.println(numberOfTimes);
            } else {
                isReversed = !isReversed;
                // update frequencies here
            }
        }
    }   
}

a b c d

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

