import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        int K = fio.nextInt();

        boolean[] primes = new boolean[N + 1];
        for (int i = 2; i < N + 1; i++) {
            primes[i] = true;
        }

        int count = 0;
        long prime = 2;
        long result = 0;
        while (count < K) {
            if (primes[(int) prime]) {
                count++;
                if (count == K) {
                    result = prime;
                }
                for (long i = prime * prime; i <= N && count < K; i += prime) {
                    if (primes[(int) i]) {
                        primes[(int) i] = false;
                        count++;
                    }
                    if (count == K) {
                        result = (int) i;
                    }
                }
            }
            prime++;
        }

        fio.println(result);
        fio.close();
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

