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
            int l1 = fio.nextInt();
            int a1 = fio.nextInt();
            int l2 = fio.nextInt();
            int a2 = fio.nextInt();
            int lt = fio.nextInt();
            int at = fio.nextInt();
            boolean hasSolution = false;
            int num1 = 0;
            int num2 = 0;
            // Small range of values; can perform complete search over x
            for (int x = 1; x <= Math.min(lt / l1, at / a1); x++) {
                // Solution found if y (for this value of x) satisfies both equations
                // y must be at least 1
                if ((lt - x * l1) % l2 == 0 && (at - x * a1) % a2 == 0
                    && (lt - x * l1) / l2 == (at - x * a1) / a2) {
                    int y = (lt - x * l1) / l2;
                    if (num1 == 0 && num2 == 0 && x > 0 && y > 0) {
                        hasSolution = true;
                        num1 = x;
                        num2 = y;
                    } else if (x > 0 && y > 0) { // Multiple solutions
                        hasSolution = false;
                    }
                }
            }
            if (hasSolution) {
                fio.println(num1 + " " + num2);
            } else {
                fio.println("?");
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

