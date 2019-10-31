import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String input = fio.nextLine();
        int whitespaceCount = 0;
        int lowercaseCount = 0;
        int uppercaseCount = 0;
        int symbolCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character == '_') {
                whitespaceCount++;
            } else if (character >= 97 && character <= 122) {
                lowercaseCount++;
            } else if (character >= 65 && character <= 90) {
                uppercaseCount++;
            } else {
                symbolCount++;
            }
        }
        fio.println(1.0 * whitespaceCount / input.length());
        fio.println(1.0 * lowercaseCount / input.length());
        fio.println(1.0 * uppercaseCount / input.length());
        fio.println(1.0 * symbolCount / input.length());
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

