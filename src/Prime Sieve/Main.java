import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int q = fio.nextInt();

        BitSet primes = new BitSet(n + 1);
        for (int i = 2; i <= n; i++) {
            primes.set(i);
        }

        for (int i = 2; i * i <= n; i++) {
            if (primes.get(i)) {
                for (int j = i * i; j <= n; j += i) {
                    primes.set(j, false);
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (primes.get(i)) {
                count++;
            }
        }

        fio.println(count);

        for (int i = 0; i < q; i++) {
            int number = fio.nextInt();
            if (primes.get(number)) {
                fio.println(1);
            } else {
                fio.println(0);
            }
        }

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

