import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        String s = fio.nextLine();
        boolean[] P = new boolean[14];
        boolean[] K = new boolean[14];
        boolean[] H = new boolean[14];
        boolean[] T = new boolean[14];
        boolean duplicateFound = false;

        for (int i = 0; i < s.length() && !duplicateFound; i += 3) {   
            char suit = s.charAt(i);
            int number = Integer.parseInt(s.substring(i + 1, i + 3));

            boolean[] suitArray;
            if (suit == 'P') {
                suitArray = P;
            } else if (suit == 'K') {
                suitArray = K;
            } else if (suit == 'H') {
                suitArray = H;
            } else {
                suitArray = T;
            }

            if (suitArray[number]) {
                fio.println("GRESKA");
                duplicateFound = true;
            } else {
                suitArray[number] = true;
            }
        }

        if (!duplicateFound) {
            for (int i = 0; i < 4; i++) {
                if (i > 0) {
                    fio.print(" ");
                }

                boolean[] suitArray;
                if (i == 0) {
                    suitArray = P;
                } else if (i == 1) {
                    suitArray = K;
                } else if (i == 2) {
                    suitArray = H;
                } else {
                    suitArray = T;
                }

                int count = 13;
                for (int j = 1; j <= 13; j++) {
                    if (suitArray[j]) {
                        count--;
                    }
                }
                fio.print(count);
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

