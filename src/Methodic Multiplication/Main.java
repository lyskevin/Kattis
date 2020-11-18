import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        String s1 = fio.nextLine();
        LinkedList<Character> x = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) {
            x.add(s1.charAt(i));
        }

        String s2 = fio.nextLine();
        LinkedList<Character> y = new LinkedList<>();
        for (int i = 0; i < s2.length(); i++) {
            y.add(s2.charAt(i));
        }

        LinkedList<Character> result = multiply(x, y);
        while (!result.isEmpty()) {
            fio.print(result.remove());
        }
        
        fio.println();
        fio.close();
    }

    private static LinkedList<Character> add(LinkedList<Character> x, LinkedList<Character> y) {
 
        // x + 0 = 0
        if (y.size() == 1) {
            return x;
        }

        // x + S(y) = S(x + y)
        y.remove();
        y.remove();
        y.removeLast();
        LinkedList<Character> result = add(x, y);
        result.addFirst('(');
        result.addFirst('S');
        result.add(')');
        y.addFirst('(');
        y.addFirst('S');
        y.add(')');

        return result;
    }

    private static LinkedList<Character> multiply(LinkedList<Character> x, LinkedList<Character> y) {
     
        // x . 0 = 0
        if (y.size() == 1) {
            LinkedList<Character> result = new LinkedList<>();
            result.add('0');
            return result;
        }

        // x . S(y) = x . y + x
        y.remove();
        y.remove();
        y.removeLast();
        LinkedList<Character> result = add(multiply(x, y), x);
        y.addFirst('(');
        y.addFirst('S');
        y.add(')');

        return result;
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

