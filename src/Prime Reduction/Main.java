import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        // Pre-compute prime factors up to sqrt(1000000000)
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(1000000000)); i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        while (n != 4) {
            int sum = 0;
            int nCopy = n;
            int count = 0;
            while (true) {
                int index = 0;
                int primeFactor = primes.get(index);
                count++;
                // Standard prime factorisation algorithm
                while (primeFactor * primeFactor <= nCopy) {
                    while (nCopy % primeFactor == 0) {
                        nCopy /= primeFactor;
                        sum += primeFactor;
                    }
                    index++;
                    if (index == primes.size()) {
                        break;
                    }
                    primeFactor = primes.get(index);
                }
                if (nCopy > 1) {
                    sum += nCopy;
                }
                if (nCopy == sum) {
                    break;
                } else {
                    nCopy = sum;
                    sum = 0;
                }
            }
            fio.println(sum + " " + count);
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

