import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String input = fio.nextLine();
        int indentationLevel = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Increase indentation level when opening brace is reached
            if (c == '{') {
                printSpaces(indentationLevel, fio);
                fio.println(c);
                indentationLevel += 2;
            } else if (c == '}') {
                // Decrease indentation level when closing brace is reached
                indentationLevel -= 2;
                printSpaces(indentationLevel, fio);
                fio.print(c);
                // Print newline if at end of input or next character is not a comma
                if ((i == input.length() - 1) || (i < input.length() - 1 && input.charAt(i + 1) != ',')) {
                    fio.println();
                }
            } else if (c == ',') {
                fio.println(c);
            } else {
                printSpaces(indentationLevel, fio);
                // Print all alphabetical characters in the same row
                while (Character.isLetter(c)) {
                    fio.print(c);
                    // Do not need to check if i is a valid index because the last character
                    // cannot be an alphabetical character (it must be a closing brace);
                    // i.e. there is always at least one character after the last alphabetical character
                    i++;
                    c = input.charAt(i);
                }
                // Print newline if next character is not a comma
                if (c != ',') {
                    fio.println();
                }
                i--;
            }
        }
        fio.close();
    }

    private static void printSpaces(int indentationLevel, FastIO fio) {
        for (int i = 0; i < indentationLevel; i++) {
            fio.print(" ");
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

