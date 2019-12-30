import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        // Pre-compute prime factors up to sqrt(Integer.MAX_VALUE) (i.e. sqrt(upper bound of input))
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(Integer.MAX_VALUE)); i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        FastIO fio = new FastIO();
        while (true) {
            try {
                long n = fio.nextLong();
                ArrayList<Tuple> primeFactors = generatePrimeFactors(n, primes);
                long neighbor = 1;
                for (int i = 0; i < primeFactors.size(); i++) {
                    Tuple tuple = primeFactors.get(i);
                    // TLE if the loop is still executed when frequency is 1,
                    // especially if the current prime factor is large
                    if (tuple.frequency > 1) {
                        for (int j = 0; j < tuple.primeFactor; j++) {
                            neighbor *= tuple.frequency;
                        }
                    }
                }
                fio.println(n + " " + neighbor);
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

    public static ArrayList<Tuple> generatePrimeFactors(long n, ArrayList<Integer> primes) {
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

