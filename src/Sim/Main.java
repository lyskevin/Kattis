import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int T = fio.nextInt();
        for (int i = 0; i < T; i++) {
            String s = fio.nextLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator(0);

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '[') {
                    iterator = list.listIterator(0);
                } else if (c == ']') {
                    iterator = list.listIterator(list.size());
                } else if (c == '<') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(c);
                }
            }

            for (Character c : list) {
                fio.print(c);
            }

            fio.println();
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

