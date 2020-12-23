import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int[] map = new int[256];
        map['B'] = 1;
        map['F'] = 1;
        map['P'] = 1;
        map['V'] = 1;
        map['C'] = 2;
        map['G'] = 2;
        map['J'] = 2;
        map['K'] = 2;
        map['Q'] = 2;
        map['S'] = 2;
        map['X'] = 2;
        map['Z'] = 2;
        map['D'] = 3;
        map['T'] = 3;
        map['L'] = 4;
        map['M'] = 5;
        map['N'] = 5;
        map['R'] = 6;

        while (true) {
            try {
                String s = fio.nextLine();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (map[c] > 0) {
                        fio.print(map[c]);
                    }
                    while (i < s.length() - 1 && map[s.charAt(i + 1)] == map[c]) {
                        i++;
                    }
                }
                fio.println();
            } catch (NullPointerException e) {
                break;
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

