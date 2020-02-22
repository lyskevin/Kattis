import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            String input = fio.nextLine();
            Stack<Character> s = new Stack<>();
            boolean hasFailed = false;
            for (int j = 0; j < input.length() && !hasFailed; j++) {
                char c = input.charAt(j);    
                if (c == '$' || c == '|' || c == '*') {
                    s.push(c);
                } else if (c == 'b') {
                    if (!s.isEmpty() && s.peek() == '$') {
                        s.pop();
                    } else {
                        hasFailed = true;
                    }
                } else if (c == 't') {
                    if (!s.isEmpty() && s.peek() == '|') {
                        s.pop();
                    } else {
                        hasFailed = true;
                    }
                } else if (c == 'j') {
                    if (!s.isEmpty() && s.peek() == '*') {
                        s.pop();
                    } else {
                        hasFailed = true;
                    }
                }
            }
            if (hasFailed || !s.isEmpty()) {
                fio.println("NO");
            } else {
                fio.println("YES");
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

