import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        String[] dictionary = new String[N];
        for (int i = 0; i < N; i++) {
            dictionary[i] = fio.nextLine();
        }

        String[] keyMap = new String[256];
        keyMap['a'] = keyMap['b'] = keyMap['c'] = "2";
        keyMap['d'] = keyMap['e'] = keyMap['f'] = "3";
        keyMap['g'] = keyMap['h'] = keyMap['i'] = "4";
        keyMap['j'] = keyMap['k'] = keyMap['l'] = "5";
        keyMap['m'] = keyMap['n'] = keyMap['o'] = "6";
        keyMap['p'] = keyMap['q'] = keyMap['r'] = keyMap['s'] = "7"; 
        keyMap['t'] = keyMap['u'] = keyMap['v'] = "8"; 
        keyMap['w'] = keyMap['x'] = keyMap['y'] = keyMap['z'] = "9"; 

        String S = fio.nextLine();

        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = dictionary[i];
            StringBuilder keyPresses = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                keyPresses.append(keyMap[word.charAt(j)]);
            }
            if (keyPresses.toString().equals(S)) {
                count++;
            }
        }

        fio.println(count);

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

