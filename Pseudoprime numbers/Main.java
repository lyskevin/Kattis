import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        // Pre-compute prime factors up to sqrt(int max) (i.e. sqrt(upper bound of input))
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(1000000000)); i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        FastIO fio = new FastIO();
        int p = fio.nextInt();
        int a = fio.nextInt();
        // Use BigInteger's modPow method to check the given condition
        while (!(p == 0 && a == 0)) {
            if (!isPrime(p, primes)) {
                BigInteger P = new BigInteger(p + "");
                BigInteger A = new BigInteger(a + "");
                if (A.modPow(P, P).equals(A)) {
                    fio.println("yes");
                } else {
                    fio.println("no");
                }
            } else {
                fio.println("no");
            }
            p = fio.nextInt();
            a = fio.nextInt();
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
        for (int i = 0; i < primes.size(); i++) {
            if (n != primes.get(i) && n % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
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

