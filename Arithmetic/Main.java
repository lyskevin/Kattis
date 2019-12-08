import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final char[] HEXADECIMAL_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String input = fio.nextLine();
        if (input.equals("0")) {
            fio.println(0);
        } else {
            int leadingLength = input.length() % 4;
            String leadingSubstring = input.substring(0, leadingLength);
            StringBuilder output = new StringBuilder();
            output.append(octalToHexadecimal(leadingSubstring));
            for (int i = leadingLength; i < input.length(); i += 4) {
                output.append(octalToHexadecimal(input.substring(i, i + 4)));
            }
            int startingIndex = 0;
            while (output.charAt(startingIndex) == '0') {
                startingIndex++;
            }
            fio.println(output.substring(startingIndex));
        }
        fio.close();
    }

    private static String octalToHexadecimal(String s) {
        int value = 0;
        int multiplier = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            value += (s.charAt(i) - '0') * multiplier;
            multiplier *= 8;
        }
        StringBuilder hexadecimal = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            hexadecimal.append(HEXADECIMAL_DIGITS[value % 16]);
            value /= 16;
        }
        return hexadecimal.reverse().toString();
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

