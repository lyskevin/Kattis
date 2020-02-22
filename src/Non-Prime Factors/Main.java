import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int q = fio.nextInt();
        // Pre-compute prime factors up to sqrt(2000000) (i.e. sqrt(upper bound of input))
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(2000000)) + 1; i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        int[] results = new int[2000001];
        for (int i = 0; i < q; i++) {
            int n = fio.nextInt();
            int result = 0;
            if (results[n] == 0) {
                // No. of non-prime factors = no. of divisors - no. of prime factors
                result = numberOfDivisors(n, primes) - numberOfPrimeFactors(n, primes);
                results[n] = result;
            } else {
                result = results[n];
            }
            fio.println(result);
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

    public static int numberOfPrimeFactors(int n, ArrayList<Integer> primes) {
        int index = 0;
        int count = 0;
        int primeFactor = primes.get(index);
        // Standard prime factorisation algorithm
        while (primeFactor * primeFactor <= n) {
            if (n % primeFactor == 0) {
                count++;
                while (n % primeFactor == 0) {
                    n /= primeFactor;
                }
            }
            index++;
            if (index == primes.size()) {
                break;
            }
            primeFactor = primes.get(index);
        }
        if (n > 1) {
            count++;
        }
        return count;
    }

    public static int numberOfDivisors(int n, ArrayList<Integer> primes) {
        int index = 0;
        int count = 1;
        int primeFactor = primes.get(index);
        while (primeFactor * primeFactor <= n) {
            int power = 0;
            while (n % primeFactor == 0) {
                n /= primeFactor;
                power++;
            }
            // Each unique prime factor increase the total number of prime
            // factors by a multiple of (power + 1)
            count *= power + 1;
            index++;
            if (index == primes.size()) {
                break;
            }
            primeFactor = primes.get(index);
        }
        if (n > 1) {
            count *= 2;
        }
        return count;
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

