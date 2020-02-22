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
        int n = fio.nextInt();
        while (n > 0) {
            fio.println(eulerPhi(n, primes));
            n = fio.nextInt();
        }
        fio.close();
    }

    // Standard prime factorisation algorithm with a slight modification
    // to compute Euler's totient/phi function
    private static int eulerPhi(int n, ArrayList<Integer> primes) {
        int index = 0;
        int count = n;
        int primeFactor = primes.get(index);
        // Standard prime factorisation algorithm
        while (primeFactor * primeFactor <= n) {
            if (n % primeFactor == 0) {
                count -= count / primeFactor; // Modification here
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
            count -= count / n;
        }
        return count;
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

