import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String number = fio.next();
        int n = fio.nextInt();
        int periodIndex = number.indexOf('.');
        StringBuilder sb = new StringBuilder("1");
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        BigInteger multiplier = new BigInteger(sb.toString());
        sb = new StringBuilder(number.replace(".", ""));
        BigInteger numberWithoutPeriod = new BigInteger(sb.toString());
        sb.append(number.substring(number.length() - n));
        BigInteger multipliedNumber = new BigInteger(sb.toString());
        sb = new StringBuilder("1");
        for (int i = 0; i < number.length() - n - periodIndex - 1; i++) {
            sb.append('0');
        }
        BigInteger postSubtractionMultiplier = new BigInteger(sb.toString());
        BigInteger numerator = multipliedNumber.subtract(numberWithoutPeriod)
                .divide(multiplier);
        BigInteger denominator = multiplier.subtract(new BigInteger("1"))
                .multiply(postSubtractionMultiplier);
        BigInteger gcd = gcd(numerator, denominator);
        fio.println(numerator.divide(gcd) + "/" + denominator.divide(gcd));
        fio.close();
    }

    private static BigInteger gcd(BigInteger number1, BigInteger number2) {
        BigInteger max = number1.max(number2);
        BigInteger min = number1.min(number2);
        while(min.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = max.remainder(min);
            max = min;
            min = remainder;
        }
        return max;
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

