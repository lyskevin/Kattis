import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        while (true) {
            try {
                int primeDivisor = 2;
                int mCopy = m;
                boolean canDivide = true;
                int nValue = n;
                if (n == 0) {
                    nValue = 1;
                }
                while (mCopy > 1 && primeDivisor <= (int) Math.sqrt(mCopy) && canDivide) {
                    int count = 0;
                    while (mCopy % primeDivisor == 0) {
                        mCopy /= primeDivisor;
                        count++;
                    }
                    if (count > 0) {
                        for (int i = primeDivisor; i <= nValue; i *= primeDivisor) {
                            count -= nValue / i;
                        }
                    }
                    if (count > 0) {
                        canDivide = false;
                    }
                    primeDivisor++;
                }
                if (!canDivide || mCopy > nValue || m == 0) {
                    fio.println(m + " does not divide " + n + "!");
                } else {
                    fio.println(m + " divides " + n + "!");
                }
                n = fio.nextInt();
                m = fio.nextInt();
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

