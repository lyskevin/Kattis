import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        Stack<Character> brackets = new Stack<>();
        int numberOfCharacters = fio.nextInt();
        String input = fio.nextLine();
        for (int i = 0; i < numberOfCharacters; i++) {
            char character = input.charAt(i);
            if (character == '(' || character == '{' || character == '[') {
                brackets.push(character);
            } else if (character != ' ') {
                if (!brackets.isEmpty()) {
                    if ((character == ')' && ((char) brackets.peek()) == '(')
                        || (character == '}' && ((char) brackets.peek()) == '{')
                        || (character == ']' && ((char) brackets.peek()) == '[')) {
                        brackets.pop();
                    } else {
                        System.out.println(character + " " + i);
                        return;
                    }
                } else {
                    System.out.println(character + " " + i);
                    return;
                }
            }
        }
        System.out.println("ok so far");
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

