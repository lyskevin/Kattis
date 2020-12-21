import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        String A = fio.next();
        String B = fio.next();
        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i < A.length(); i++) {
            if (B.indexOf(A.charAt(i) + "") > -1) {
                indexA = i;
                indexB = B.indexOf(A.charAt(i) + "");
                break;
            }
        }

        for (int i = 0; i < B.length(); i++) {
            for (int j = 0; j < A.length(); j++) {
                if (i == indexB) {
                    fio.print(A.charAt(j));
                } else if (j == indexA) {
                    fio.print(B.charAt(i));
                } else {
                    fio.print(".");
                }
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

