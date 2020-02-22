import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        boolean isNegative = false;
        long n = fio.nextLong();
        if (n < 0) {
            isNegative = true;
        }
        n = Math.abs(n);
        // Pre-compute prime factors up to sqrt(int max) (i.e. sqrt(upper bound of input))
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(Integer.MAX_VALUE)); i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        while (n > 0) {
            ArrayList<Tuple> primeFactors = generatePrimeFactors(n, primes);
            int gcd = primeFactors.get(0).frequency;
            for (int i = 1; i < primeFactors.size(); i++) {
                gcd = gcd(gcd, primeFactors.get(i).frequency);
            }
            // Find the highest odd divisor of the gcd if the given number is negative
            if (gcd % 2 == 0 && isNegative) {
                while (gcd % 2 == 0) {
                    gcd /= 2;
                }
                fio.println(gcd);
            } else {
                fio.println(gcd);
            }
            isNegative = false;
            n = fio.nextLong();
            if (n < 0) {
                isNegative = true;
            }
            n = Math.abs(n);
        }
        fio.close();
    }

    private static ArrayList generatePrimeFactors(long n, ArrayList<Integer> primes) {
        int index = 0;
        ArrayList<Tuple> primeFactors = new ArrayList<>();
        long primeFactor = primes.get(index);
        // Standard prime factorisation algorithm
        while (primeFactor * primeFactor <= n) {
            if (n % primeFactor == 0) {
                Tuple tuple = new Tuple(primeFactor);
                while (n % primeFactor == 0) {
                    n /= primeFactor;
                    tuple.frequency++;
                }
                primeFactors.add(tuple);
            }
            index++;
            if (index == primes.size()) {
                break;
            }
            primeFactor = primes.get(index);
        }
        if (n > 1) {
            Tuple tuple = new Tuple(n);
            tuple.frequency++;
            primeFactors.add(tuple);
        }
        return primeFactors;
    }

    private static int gcd(int number1, int number2) {
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        int max = Math.max(number1, number2);
        int min = Math.min(number1, number2);
        while (min > 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return max;
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

class Tuple {

    long primeFactor;
    int frequency;

    Tuple(long primeFactor) {
        this.primeFactor = primeFactor;
        this.frequency = 0;
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

