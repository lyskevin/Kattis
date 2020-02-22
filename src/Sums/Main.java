import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int k;
    private static int a;

    // k: number of terms; a: first term in sequence to sum; n: given number
    // Using the sum of arithmetic progression formula, we can deduce that k * (2a + k - 1) = 2n
    // k and (2a + k - 1) are factors of 2n, so we find the distinct factors of 2n and test each of them
    // to find the smallest value of k, which yields the smallest number of summands
    public static void main(String[] args) {
        // Pre-compute prime factors up to sqrt(2000000000)
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(2000000000)); i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fio.nextInt();
            ArrayList<Integer> primeFactors = generatePrimeFactors(2 * n, primes);
            k = Integer.MAX_VALUE;
            a = 0;
            boolean[] usedPrimeFactors = new boolean[primeFactors.size()];
            HashSet<Integer> usedFactors = new HashSet<>();
            findSummands(primeFactors, usedPrimeFactors, usedFactors, 1, 2 * n);
            // k's value has not changed from the default, so impossible
            if (k == Integer.MAX_VALUE) {
                fio.println("IMPOSSIBLE");
            } else {
                fio.print(n + " = ");
                for (int j = a; j < a + k; j++) {
                    if (j > a) {
                        fio.print(" + ");
                    }
                    fio.print(j);
                }
                fio.println();
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

    public static ArrayList<Integer> generatePrimeFactors(int n, ArrayList<Integer> primes) {
        int index = 0;
        ArrayList<Integer> primeFactors = new ArrayList<>();
        int primeFactor = primes.get(index);
        // Standard prime factorisation algorithm
        while (primeFactor * primeFactor <= n) {
            while (n % primeFactor == 0) {
                n /= primeFactor;
                primeFactors.add(primeFactor);
            }
            index++;
            if (index == primes.size()) {
                break;
            }
            primeFactor = primes.get(index);
        }
        if (n > 1) {
            primeFactors.add(n);
        }
        return primeFactors;
    }

    private static void findSummands(ArrayList<Integer> primeFactors, boolean[] usedPrimeFactors,
            HashSet<Integer> usedFactors, int currentFactor, int number) {
        // Current factor seen before
        if (usedFactors.contains(currentFactor)) {
            return;
        } else {
            // Record that the current factor has been used
            usedFactors.add(currentFactor);
            if (currentFactor > k) {
                return;
            } else {
                // Check that k and a are numbers which satisfy the constraints of k * (2a + k - 1) = 2n
                int firstTerm = number / currentFactor + 1 - currentFactor;
                if (firstTerm > 0 && firstTerm % 2 == 0 && currentFactor > 1) {
                    k = currentFactor;
                    a = firstTerm / 2;
                    return;
                } else {
                    for (int i = 0; i < usedPrimeFactors.length; i++) {
                        if (!usedPrimeFactors[i]) {
                            // Use the current prime factor (to find more distinct factors)
                            // if it has not been used before
                            // The true/false statements work since the method calls are recursive in nature
                            usedPrimeFactors[i] = true;
                            findSummands(primeFactors, usedPrimeFactors, usedFactors,
                                    currentFactor * primeFactors.get(i), number);
                            usedPrimeFactors[i] = false;
                        }
                    }
                }
            }
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

