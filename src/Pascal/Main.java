import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        if (n == 1) {
            fio.println(0);
        } else {
            // Pre-compute prime factors up to sqrt(n)
            ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            int index = 0;
            int primeFactor = primes.get(index);
            int smallestPrimeFactor = 0;
            // Try pre-computed prime factors
            while (n % primeFactor != 0) {
                index++;
                if (index == primes.size()) {
                    break;
                }
                primeFactor = primes.get(index);
            }
            if (n % primeFactor != 0) {
                primeFactor = n;
            }
            // Answer is n - (n / smallest prime factor of n)
            fio.println(n - (n / primeFactor));
        }
        fio.close();
    }

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        } else if (n < 2 || n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= (int) Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
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

