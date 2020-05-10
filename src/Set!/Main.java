import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String[] cards = new String[12];
        for (int i = 0; i < 12; i++) {
            cards[i] = fio.next();
        }
        boolean hasSets = false;
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 11; j++) {
                for (int k = j + 1; k < 12; k++) {
                    boolean isValid = true;
                    for (int l = 0; l < 4; l++) {
                        if (!((cards[i].charAt(l) == cards[j].charAt(l) && cards[i].charAt(l) == cards[k].charAt(l))
                                || (cards[i].charAt(l) != cards[j].charAt(l) && cards[i].charAt(l) != cards[k].charAt(l)
                                        && (cards[j].charAt(l) != cards[k].charAt(l))))) {
                            isValid = false; // Either not all same or not pairwise distinct
                        }
                    }
                    if (isValid) {
                        hasSets = true;
                        fio.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                    }
                }
            }
        }
        if (!hasSets) {
            fio.println("no sets");
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

