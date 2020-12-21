import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        String operation = fio.next();

        if (operation.equals("E")) {
            fio.println(encode(fio.next()));
        } else {
            fio.println(decode(fio.next()));
        }

        fio.close();
    }

    private static String encode(String s) {
        int index = 1;
        char previous = s.charAt(0);
        int count = 1;
        StringBuilder result = new StringBuilder();

        while (index < s.length()) {
            if (s.charAt(index) == previous) {
                count++;
            } else {
                result.append((char) previous);
                result.append(count);
                count = 1;
                previous = s.charAt(index);
            }
            index++;
        }

        result.append((char) previous);
        result.append(count);

        return result.toString();
    }

    private static String decode(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {
            for (int j = 0; j < s.charAt(i + 1) - '0'; j++) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
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

