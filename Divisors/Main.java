import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= 431; i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        while (true) {
            try {
                int n = fio.nextInt();
                int k = fio.nextInt();
                int[] primeFactors = new int[432];
                for (int i = 1; i <= n; i++) {
                    int index = 0;
                    int primeFactor = primes.get(index);
                    int copy = i;
                    while (primeFactor * primeFactor <= copy) {
                        while (copy % primeFactor == 0) {
                            copy /= primeFactor;
                            primeFactors[primeFactor] += 1;
                        }
                        index++;
                        primeFactor = primes.get(index);
                    }
                    if (copy > 1) {
                        primeFactors[copy] += 1;
                    }
                }
                for (int i = 1; i <= k; i++) {
                    int index = 0;
                    int primeFactor = primes.get(index);
                    int copy = i;
                    while (primeFactor * primeFactor <= copy) {
                        while (copy % primeFactor == 0) {
                            copy /= primeFactor;
                            primeFactors[primeFactor] -= 1;
                        }
                        index++;
                        primeFactor = primes.get(index);
                    }
                    if (copy > 1) {
                        primeFactors[copy] -= 1;
                    }
                }
                for (int i = 1; i <= n - k; i++) {
                    int index = 0;
                    int primeFactor = primes.get(index);
                    int copy = i;
                    while (primeFactor * primeFactor <= copy) {
                        while (copy % primeFactor == 0) {
                            copy /= primeFactor;
                            primeFactors[primeFactor] -= 1;
                        }
                        index++;
                        primeFactor = primes.get(index);
                    }
                    if (copy > 1) {
                        primeFactors[copy] -= 1;
                    }
                }
                long count = 1;
                for (int i = 2; i <= 431; i++) {
                    if (primeFactors[i] > 0) {
                        count *= primeFactors[i] + 1;
                    }
                }
                fio.println(count);
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
            for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
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

