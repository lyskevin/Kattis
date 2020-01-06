import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        // Pre-compute prime factors up to sqrt(1000000000) (i.e. sqrt(upper bound of input))
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(1000000000)); i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        FastIO fio = new FastIO();
        while (true) {
            try {
                long n = fio.nextLong();
                long sum = sumProperDivisors(n, primes);
                if (Math.abs(sum - n) == 0) {
                    fio.println(n + " perfect");
                } else if (Math.abs(sum - n) <= 2) {
                    fio.println(n + " almost perfect");
                } else {
                    fio.println(n + " not perfect");
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }

    // Standard prime factorisation algorithm with a slight modification
    // to calculate the sum of the specified number's proper divisors
    private static long sumProperDivisors(long n, ArrayList<Integer> primes) {
        int index = 0;
        int primeFactor = primes.get(index);
        long sum = 1;
        long nCopy = n;
        // Standard prime factorisation algorithm
        while (primeFactor * primeFactor <= nCopy) {
            int power = 0;
            while (nCopy % primeFactor == 0) {
                power++;
                nCopy /= primeFactor;
            }
            sum *= (((long) Math.pow(primeFactor, power + 1)) - 1) / (primeFactor - 1);
            index++;
            if (index == primes.size()) {
                break;
            }
            primeFactor = primes.get(index);
        }
        if (nCopy == n) {
            return 1;
        } else {
            if (nCopy > 1) {
                sum *= (((long) Math.pow(nCopy, 2)) - 1) / (nCopy - 1);
            }
            return sum - n;
        }
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

