import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int m = fio.nextInt();
        int n = fio.nextInt();
        int t = fio.nextInt();
        long result = 1l;
        boolean isAccepted = true;

        switch(t) {

            // O(n!)
            case 1:
                for (int i = n; i >= 2; i--) {
                    result *= i;
                    if (result > m) {
                        isAccepted = false;
                        break;
                    }
                }
                break;

            // O(2^n)
            case 2:
                for (int i = 0; i < n; i++) {
                    result *= 2;
                    if (result > m) {
                        isAccepted = false;
                        break;
                    }
                }
                break;

            // O(n^4)
            case 3:
                for (int i = 0; i < 4; i++) {
                    result *= n;
                    if (result > m) {
                        isAccepted = false;
                        break;
                    }
                }
                break;

            // O(n^3)
            case 4:
                for (int i = 0; i < 3; i++) {
                    result *= n;
                    if (result > m) {
                        isAccepted = false;
                        break;
                    }
                }
                break;

            // O(n^2)
            case 5:
                for (int i = 0; i < 2; i++) {
                    result *= n;
                    if (result > m) {
                        isAccepted = false;
                        break;
                    }
                }
                break;

            // O(n log n)
            case 6:
                if ((n * Math.log(n) / Math.log(2)) > m) {
                    isAccepted = false;
                }
                break;

            // O(n)
            case 7:
                if (n > m) {
                    isAccepted = false;
                }
                break;
        }

        if (!isAccepted || n > m) {
            fio.println("TLE");
        } else {
            fio.println("AC");
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

