import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        // Pre-compute prime factors up to sqrt(Integer.MAX_VALUE)
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(Integer.MAX_VALUE)); i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        while (n > 0) {
            int next = n * 2 + 1;
            // Generate larger values until a prime >= 2n + 1 is found
            while (!isPrime(next, primes)) {
                next += 2;
            }
            if (isPrime(n, primes)) {
                fio.println(next);
            } else {
                fio.println(next + " (" + n + " is not prime)");
            }
            n = fio.nextInt();
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

    private static boolean isPrime(int n, ArrayList<Integer> primes) {
        if (n == Integer.MAX_VALUE) {
            return true;
        } else {
            for (int i = 0; i < primes.size(); i++) {
                if (n == primes.get(i)) {
                    return true;
                } else if (n % primes.get(i) == 0) {
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

