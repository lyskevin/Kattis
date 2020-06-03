import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String s = fio.nextLine();
        int[] digits = new int[10];
        for (int i = 0; i < s.length(); i++) {
            digits[s.charAt(i) - '0']++;
        }
        int minimumFrequency = 1000;
        int minimumDigit = 0;
        for (int i = 1; i < 10; i++) {
            if (digits[i] < minimumFrequency) {
                minimumFrequency = digits[i];
                minimumDigit = i;
            }
        }
        // Check for 0 last since the number has to be positive
        // I.e. 0 is not a valid output
        if (digits[0] < minimumFrequency) {
            minimumFrequency = digits[0];
            minimumDigit = 0;
        }
        StringBuilder sb = new StringBuilder();
        if (minimumDigit == 0) {
            sb.append("1");
        }
        for (int i = 0; i < minimumFrequency + 1; i++) {
            sb.append(minimumDigit);
        }
        fio.println(sb.toString());
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

