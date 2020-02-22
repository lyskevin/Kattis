import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        // Pre-compute relevant prime factors
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(Integer.MAX_VALUE)) + 1; i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        while (true) {
            try {
                long n = fio.nextLong();
                boolean isNegative = false;
                if (n < 0) {
                    isNegative = true;
                    n = Math.abs(n);
                }
                // Generate prime factors and their respective frequencies
                ArrayList<Tuple> primeFactors = generatePrimeFactors(n, primes);
                if (isNegative) {
                    fio.print(-1 + " ");
                }
                // Format and print output accordingly
                for (int i = 0; i < primeFactors.size(); i++) {
                    if (i > 0) {
                        fio.print(" ");
                    }
                    Tuple tuple = primeFactors.get(i);
                    if (tuple.frequency == 1) {
                        fio.print(tuple.primeFactor);
                    } else {
                        fio.print(tuple.primeFactor + "^" + tuple.frequency);
                    }
                }
                fio.println();
            } catch (NullPointerException e) {
                break;
            }
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

    public static ArrayList generatePrimeFactors(long n, ArrayList<Integer> primes) {
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

