import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * @author lyskevin
 */
public class Main {

    private static final BigInteger TEN_THOUSAND = new BigInteger("10000");

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                BigInteger a = new BigInteger(fio.nextLong() + "");
                String operator = fio.next();
                BigInteger b = new BigInteger(fio.nextLong() + "");
                if (operator.equals("+")) {
                    fio.println(a.add(b).mod(TEN_THOUSAND));
                } else if (operator.equals("*")) {
                    fio.println(a.multiply(b).mod(TEN_THOUSAND));
                } else {
                    // modPow can compute power % m
                    fio.println(a.modPow(b, TEN_THOUSAND));
                }
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

